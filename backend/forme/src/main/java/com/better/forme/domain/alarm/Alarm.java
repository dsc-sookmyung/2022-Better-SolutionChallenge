package com.better.forme.domain.alarm;

import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Null;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@Entity
public class Alarm implements Serializable {

    @Id
    private Long alarm_id;

    // @MapsId("user_key")  //alarm_id.userKey 매핑
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private Boolean day_alarm;

    @Column(nullable = false)
    private Boolean like_alarm;

    @Column(nullable = false)
    private Boolean recommend_alarm;

    @Column(nullable = false)
    private Boolean cheerup_alarm;

    @Column(nullable = false)
    private Integer mealtime_alarm;
}
