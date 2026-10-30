package com.bedermontoya.gym.gym_backend.member;

import java.time.*;

import jakarta.validation.constraints.*;

public record MemberRequest(
        @Positive Integer memberNumber,
        @NotBlank @Size(max = 50) String firstName,
        @Size(max = 50) String middleName,
        @NotBlank @Size(max = 50) String lastName,
        @Size(max = 50) String secondLastName,
        @NotNull @Past LocalDate birthDate,
        @NotBlank @Size(max = 20) String phone,
        @Size(max = 255) String address,
        @NotBlank @Size(max = 100) String emergencyContactName,
        @NotBlank @Size(max = 20) String emergencyContactPhone) {
}
