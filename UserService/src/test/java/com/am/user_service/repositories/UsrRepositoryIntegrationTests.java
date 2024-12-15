package com.am.user_service.repositories;

import com.am.user_service.testutil.TestUtils;
import domain.entities.UsrEntity;
import jakarta.transaction.Transactional;
import kafka.server.metadata.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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

}
