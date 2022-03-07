package com.better.forme.domain.badge;

import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class Badge {

//    @EmbeddedId
//    private BadgeId badge_id;

//    @Id
//    //@MapsId("userKey")  //badge_id.userKey 매핑
//    @OneToOne
//    @JoinColumn(name = "user_key", nullable = false)
//    private User user;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean badge1;

    @Column(nullable = false)
    private Boolean badge2;

    @Column(nullable = false)
    private Boolean badge3;

    @Column(nullable = false)
    private Boolean badge4;

    @Column(nullable = false)
    private Boolean badge5;

    @Column(nullable = false)
    private Boolean badge6;

    @Column(nullable = false)
    private Boolean badge7;

    @Column(nullable = false)
    private Boolean badge8;

    @Column(nullable = false)
    private Boolean badge9;

    //대표 뱃지
    private Integer main_badge1;

    private Integer main_badge2;

    private Integer main_badge3;

}
