package com.better.forme.web;

import com.better.forme.domain.alarm.Alarm;
import com.better.forme.domain.alarm.AlarmRepository;
import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.web.dto.AlarmDto.AlarmSaveRequestDto;
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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AlarmApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;
    
    @Autowired
    private AlarmRepository alarmRepository;

    @Autowired
    private UserRepository userRepository;
    
    @After
    public void tearDown() throws Exception {
//        alarmRepository.deleteAll();
    }
    
    @Test
    public void 알람설정_저장() throws Exception {
        
        // given
        User user = userRepository.findById(Long.valueOf(1)).get();
        Long user_id = user.getUserId();

        Boolean day_alarm = Boolean.TRUE;
        Boolean like_alarm = Boolean.FALSE;
        Boolean recommend_alarm = Boolean.TRUE;
        Boolean cheerup_alarm = Boolean.FALSE;
        Integer mealtime_alarm = 2;

        AlarmSaveRequestDto requestDto = AlarmSaveRequestDto.builder()
                .user_id(user_id)
                .day_alarm(day_alarm)
                .like_alarm(like_alarm)
                .recommend_alarm(recommend_alarm)
                .cheerup_alarm(cheerup_alarm)
                .mealtime_alarm(mealtime_alarm)
                .build();

        String url = "http://localhost:" + port + "/api/setting/alarm";

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Alarm> all = alarmRepository.findAll();
        assertThat(all.get(0).getDay_alarm()).isEqualTo(day_alarm);
        assertThat(all.get(0).getCheerup_alarm()).isEqualTo(cheerup_alarm);
    }
}
