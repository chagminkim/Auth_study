package study.auth_study.member.dto;

import lombok.Getter;

@Getter
public class MemberInfoResponse {

    private Long id;
    private String name;

    public MemberInfoResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
