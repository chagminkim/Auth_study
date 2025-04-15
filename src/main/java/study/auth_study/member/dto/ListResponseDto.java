package study.auth_study.member.dto;

public class ListResponseDto {

    private Long id;

    private String email;

    private String name;

    public ListResponseDto(Long id, String email, String name) {
        this.id = id;
        this.email = email;
        this.name = name;
    }
}
