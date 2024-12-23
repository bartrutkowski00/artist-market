package com.am.user_service.repositories;

import com.am.user_service.domain.dto.FilterDTO;
import com.am.user_service.testutil.TestUtils;
import com.am.user_service.domain.entities.UsrEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;


@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UsrRepositoryIntegrationTests {

    private UsrRepository underTest;

    @Autowired
    public UsrRepositoryIntegrationTests(UsrRepository underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatUserCRUDWorks(){
        UsrEntity usrEntity = TestUtils.createTestUser();
        underTest.save(usrEntity);
        List<UsrEntity> usrEntities = underTest.findAll();
        Optional<UsrEntity> userEntity = underTest.findById(99L);
        underTest.delete(usrEntity);

    }

    @Test
    public void testThatFindingUserWorks(){
        FilterDTO filterDTO = new FilterDTO("am","am@artist.c","Warsaw", new Date("12/12/2024"),new Date("12/12/2070"));
         var test = underTest.findUsers(filterDTO);


    }

}
