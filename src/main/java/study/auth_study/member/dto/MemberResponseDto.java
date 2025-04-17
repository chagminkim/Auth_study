package study.auth_study.member.dto;

public class MemberResponseDto {

    private Long id;
    private String name;
    private String email;

    public MemberResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
