package com.study.basicboard.domain.entity;

import com.study.basicboard.domain.enum_class.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String loginId;     // 로그인할 때 사용하는 아이디
    private String password;    // 비밀번호
    private String nickname;    // 닉네임
    private LocalDateTime createdAt;    // 가입 시간

    @Enumerated(EnumType.STRING)
    private UserRole userRole;      // 권한

    @OneToMany(mappedBy = "user")
    private List<Board> boards;     // 작성글
}
