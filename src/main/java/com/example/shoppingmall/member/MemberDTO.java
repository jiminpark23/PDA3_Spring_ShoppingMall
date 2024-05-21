package com.example.shoppingmall.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
//     MemberRequestDto, MemberResponseDto
//     SignUpReqDto, SignUpResDto
//     LoginReqDto, LoginResDto
    private int id;

    @JsonProperty("user_id")
    @NotBlank(message = "아이디는 필수 입력입니다.")
    @Pattern(regexp = "^[a-z0-9_-]{3,10}", message = "아이디는 영문과 숫자가 포함된 3~10자의 아이디여야 합니다.")
    private String userId;
    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Size(min=8, message="최소 8자리 이상 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,15}", message = "비밀번호는 영문과 숫자, 특수기호가 적어도 1개 이상씩 포함된 8~15자의 비밀번호여야 합니다.")
    private String pw;
    @NotBlank(message = "이름은 필수 입력입니다.")
    private String name;
//    @Email
    @Pattern(regexp = "^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$", message = "올바른 이메일 형식이 아닙니다.")
    @NotBlank(message = "이메일은 필수 입력입니다.")
    private String email;
    @NotBlank(message = "연락처는 필수 입력입니다.")
    @Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "올바른 연락처 형식이 아닙니다.")
    private String contact;

    public Member convertToEntity() {
        return new Member(
                id,
                userId,
                pw,
                name,
                email,
                contact
        );
    }
}
