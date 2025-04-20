package study.auth_study.member.dto;

public class MemberResponseDto {

    private Long id;
    private String name;

    public MemberResponseDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
