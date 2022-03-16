package com.better.forme.web;

import com.better.forme.domain.likes.LikesRepository;
import com.better.forme.domain.recipe_record.RecipeRecord;
import com.better.forme.domain.recipe_record.RecipeRecordRepository;
import com.better.forme.domain.user.User;
import com.better.forme.domain.user.UserRepository;
import com.better.forme.web.dto.RecipeDto.RecipeSaveRequestDto;
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
public class RecipeApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private RecipeRecordRepository recipeRecordRepository;
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LikesRepository likesRepository;
    
    @After
    public void tearDown() throws Exception {
        recipeRecordRepository.deleteAll();
    }
    
    @Test
    public void 레시피_저장() throws Exception {
        
        // given
        User user = userRepository.findById(Long.valueOf(1)).get();
        Long user_id = user.getUserId();
        
        String recipe_name = "spinach pasta";
        Integer type = 3;
        Integer cooking_time = 20;
        String desc1 = "boiling water";
        String desc2 = "spinach cutting";
        String desc3 = "Boil the noodles for 6 minutes.";
        String desc4 = "Stir-fry spinach in oil.";
        String desc5 = "Mix it with noodles.";

        RecipeSaveRequestDto requestDto = RecipeSaveRequestDto.builder()
                .user(user)
                .recipe_name(recipe_name)
                .type(type)
                .cooking_time(cooking_time)
                .desc1(desc1)
                .desc2(desc2)
                .desc3(desc3)
                .desc4(desc4)
                .desc5(desc5)
                .build();

        String url = "http://localhost:" + port + "/api/recipe-record";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<RecipeRecord> all = recipeRecordRepository.findAll();
        assertThat(all.get(1).getRecipe_name()).isEqualTo(recipe_name);
        assertThat(all.get(1).getDesc2()).isEqualTo(desc2);
    }
}
