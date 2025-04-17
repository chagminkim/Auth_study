package study.auth_study.member.dto;

public class MemberListResponseDto {

    private Long id;

    private String email;

    private String name;

    public MemberListResponseDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
