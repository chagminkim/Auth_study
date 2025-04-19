package study.auth_study.member.dto;

import lombok.Getter;

@Getter
public class MemberUpdateRequest {

    private String password;
    private String name;
}
