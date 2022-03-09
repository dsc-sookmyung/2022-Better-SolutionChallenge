package com.better.forme.domain.character;

import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class TomatoCharacter {

    @Id
    private Long userId;

    @MapsId("userId")  //TomatoCharacter.userId 매핑
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Integer level;

    @Column(nullable = false)
    private Integer exp;
}
