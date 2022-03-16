package com.better.forme.web;


import com.better.forme.domain.diet_record.DietRecord;
import com.better.forme.domain.diet_record.DietRecordRepository;
import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.web.dto.DietDto.DietSaveRequestDto;
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
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DietApiControllerTest {
    
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DietRecordRepository dietRecordRepository;

    @Autowired
    private UserRepository userRepository;

    @After
    public void tearDown() throws Exception {
        dietRecordRepository.deleteAll();
        userRepository.deleteAll();
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

    @Test
    public void 식단기록_저장() throws Exception {
        
        //given
        User user = userRepository.findById(Long.valueOf(1)).get();
        Long user_id = user.getUserId();
        Date date = new Date();

        Integer meal_category = 1;
        String food_name = "sandwich";
        String food_desc = "with ham and cheese";

        Boolean egg_check = Boolean.TRUE;
        Boolean dairy_check = Boolean.TRUE;
        Boolean fish_check = Boolean.FALSE;
        Boolean birds_check = Boolean.FALSE;
        Boolean pork_check = Boolean.TRUE;
        Boolean beef_check = Boolean.FALSE;

        DietSaveRequestDto requestDto = DietSaveRequestDto.builder()
                .user(user)
                .date(date)
                .meal_category(meal_category)
                .food_name(food_name)
                .food_desc(food_desc)
                .egg_check(egg_check)
                .dairy_check(dairy_check)
                .fish_check(fish_check)
                .birds_check(birds_check)
                .pork_check(pork_check)
                .beef_check(beef_check)
                .build();

        String url = "http://localhost:" + port + "/api/diet";

        //when

        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<DietRecord> all = dietRecordRepository.findAll();
        assertThat(all.get(0).getUser().getUserId()).isEqualTo(user_id);
        assertThat(all.get(0).getMeal_category()).isEqualTo(meal_category);
        assertThat(all.get(0).getPork_check()).isEqualTo(pork_check);
    }
}
