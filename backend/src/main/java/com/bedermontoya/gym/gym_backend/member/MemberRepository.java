package com.bedermontoya.gym.gym_backend.member;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberNumber(Integer memberNumber);

    List<Member> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    boolean existsByMemberNumber(Integer memberNumber);

}
