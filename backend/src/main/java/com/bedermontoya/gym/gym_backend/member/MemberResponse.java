package com.bedermontoya.gym.gym_backend.member;

import java.time.LocalDate;

public record MemberResponse(
        Integer id,
        Integer memberNumber,
        String firstName,
        String middleName,
        String lastName,
        String secondLastName,
        LocalDate birthDate,
        Integer age,
        String phone,
        String address,
        String emergencyContactName,
        String emergencyContactPhone,
        String photoPath,
        String status) {
}