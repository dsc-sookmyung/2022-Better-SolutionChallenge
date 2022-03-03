package com.better.forme.domain.dashboard;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@Entity
@Data
public class Dashboard {

    @Id
    private Long id;

    private String user;

    private String password;

    private String title;


}
