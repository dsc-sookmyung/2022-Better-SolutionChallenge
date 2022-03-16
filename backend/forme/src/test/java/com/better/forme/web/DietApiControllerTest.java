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
//        dietRecordRepository.deleteAll();
    }

    @Test
    public void 식단기록_저장() throws Exception {
        
        //given
        User user = userRepository.findById(Long.valueOf(1)).get();
        Long user_id = user.getUserId();
        Date date = new Date();

        Integer meal_category = 1;
        String food_img = "img_sandwich";
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
                .food_img(food_img)
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

        // when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<DietRecord> all = dietRecordRepository.findAll();
        assertThat(all.get(2).getUser().getUserId()).isEqualTo(user_id);
        assertThat(all.get(2).getMeal_category()).isEqualTo(meal_category);
        assertThat(all.get(2).getPork_check()).isEqualTo(pork_check);
    }

    // desc 2까지만 넣고 3부턴 안 넣었을 때도 되는지 테스트해보기
}
