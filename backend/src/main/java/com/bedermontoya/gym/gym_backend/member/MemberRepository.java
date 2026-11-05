package com.bedermontoya.gym.gym_backend.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByMemberNumber(Integer memberNumber);

    List<Member> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);

    boolean existsByMemberNumber(Integer memberNumber);

    @Query("select coalesce(max(m.memberNumber), 0) from Member m")
    Integer findMaxMemberNumber();

}
