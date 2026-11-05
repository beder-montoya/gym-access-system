package com.bedermontoya.gym.gym_backend.member;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse create(MemberRequest request) {

        if (request.memberNumber() != null && memberRepository.existsByMemberNumber(request.memberNumber())) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Member number already in use");
        }
        Integer number;
        if (request.memberNumber() != null) {
            number = request.memberNumber();
        } else {
            number = memberRepository.findMaxMemberNumber() + 1;
        }

        Member member = new Member();
        member.setMemberNumber(number);
        member.setFirstName(request.firstName());
        member.setMiddleName(request.middleName());
        member.setLastName(request.lastName());
        member.setSecondLastName(request.secondLastName());
        member.setBirthDate(request.birthDate());
        member.setPhone(request.phone());
        member.setAddress(request.address());
        member.setEmergencyContactName(request.emergencyContactName());
        member.setEmergencyContactPhone(request.emergencyContactPhone());

        Member saved = memberRepository.save(member);
        return toResponse(saved);
    }

    public List<MemberResponse> search(String text) {
        return memberRepository
                .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(text, text)
                .stream()
                .map(this::toResponse)
                .toList();

    }

    private MemberResponse toResponse(Member member) {
        int age = Period.between(member.getBirthDate(), LocalDate.now()).getYears();

        return new MemberResponse(
                member.getId(),
                member.getMemberNumber(),
                member.getFirstName(),
                member.getMiddleName(),
                member.getLastName(),
                member.getSecondLastName(),
                member.getBirthDate(),
                age,
                member.getPhone(),
                member.getAddress(),
                member.getEmergencyContactName(),
                member.getEmergencyContactPhone(),
                member.getPhotoPath(),
                member.getStatus());
    }
}
