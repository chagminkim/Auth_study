package study.auth_study.member.dto;

public class ResponseDto {

    private Long id;
    private String name;
    private String email;

    public ResponseDto(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
