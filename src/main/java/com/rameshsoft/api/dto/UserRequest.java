package com.rameshsoft.api.dto;


import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRequest {
    @NotNull(message = "user name shouldn't be null")
    private String name;
    @Email(message = "invalid email address")
    private String email;
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;
}
