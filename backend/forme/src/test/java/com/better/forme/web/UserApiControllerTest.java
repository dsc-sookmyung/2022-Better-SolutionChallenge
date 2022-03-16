package com.better.forme.web;

import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.web.dto.UserDto.UserInfoSaveRequestDto;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Time;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @After
    public void tearDown() throws Exception {
//        userRepository.deleteAll();
    }

    @Test
    public void User_정보등록() throws Exception {

        //given
        String idEmail =  "idEmail";
        String email =  "email";
        Boolean sex =  Boolean.TRUE;
        Integer age =  23;
        Integer currentType =  3;
        Integer goalType =  1;
        Integer day1 =  1;
        Integer day2 =  2;
        Integer day3 =  3;
        Integer day4 =  4;
        Integer day5 =  5;
        Integer day6 =  6;
        Integer day7 =  7;
        Time mealtime1 =   Time.valueOf("07:30:00");
        Time mealtime2 =  Time.valueOf("12:30:00");
        Time mealtime3 =  Time.valueOf("17:30:00");
        Boolean onAlarm =  Boolean.FALSE;
        String nickname = "i am test";

        UserInfoSaveRequestDto requestDto = UserInfoSaveRequestDto.builder()
                .idEmail(idEmail)
                .email(email)
                .sex(sex)
                .age(age)
                .currentType(currentType)
                .goalType(goalType)
                .day1(day1).day2(day2).day3(day3).day4(day4).day5(day5).day6(day6).day7(day7)
                .mealtime1(mealtime1).mealtime2(mealtime2).mealtime3(mealtime3)
                .onAlarm(onAlarm)
                .nickname(nickname)
                .build();

        String url = "http://localhost:" + port + "/api/user/sign-up";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<User> all = userRepository.findAll();
        assertThat(all.get(1).getIdEmail()).isEqualTo(idEmail);
        assertThat(all.get(1).getOnAlarm()).isEqualTo(onAlarm);
    }
}
