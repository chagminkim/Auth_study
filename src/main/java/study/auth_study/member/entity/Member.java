package study.auth_study.member.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(length = 1024)
    private String password;

    public Member() {
    }
    public Member(String name, String email, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }
    public void update(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
