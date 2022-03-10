package com.better.forme.web.dto;

import com.better.forme.domain.badge.Badge;
import com.better.forme.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
public class BadgeResponseDto {
    private Long userId;

    private Boolean badge1;
    private Boolean badge2;
    private Boolean badge3;
    private Boolean badge4;
    private Boolean badge5;
    private Boolean badge6;
    private Boolean badge7;
    private Boolean badge8;
    private Boolean badge9;

//    private Integer main_badge1;
//    private Integer main_badge2;
//    private Integer main_badge3;

    public BadgeResponseDto(Badge entity){
        this.userId= entity.getUserId();

        this.badge1=entity.getBadge1();
        this.badge2=entity.getBadge2();
        this.badge3=entity.getBadge3();
        this.badge4=entity.getBadge4();
        this.badge5=entity.getBadge5();
        this.badge6=entity.getBadge6();
        this.badge7=entity.getBadge7();
        this.badge8=entity.getBadge8();
        this.badge9=entity.getBadge9();

//        this.main_badge1 = entity.getMain_badge1();
//        this.main_badge2= entity.getMain_badge2();
//        this.main_badge3= entity.getMain_badge3();
    }
}
