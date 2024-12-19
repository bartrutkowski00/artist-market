package com.am.user_service.services;

import com.am.user_service.domain.dto.UserDTO;
import com.am.user_service.repositories.UsrRepository;
import com.am.user_service.security.Encryption;
import com.am.user_service.services.impl.UserServiceImpl;
import com.am.user_service.testutil.TestUtils;
import com.am.user_service.domain.entities.UsrEntity;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;


@Transactional
@SpringBootTest
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceImplIntegrationTests {

    private UserService underTest;

    @Autowired
    public UserServiceImplIntegrationTests(UserServiceImpl underTest){
        this.underTest = underTest;
    }

    @Test
    public void testThatAddingUserWorks(){
        UserDTO newUser = TestUtils.createTestUserDTO(null, "New User");
        UserDTO existingUser1 = TestUtils.createTestUserDTO(1L);
        UserDTO existingUser2 = TestUtils.createTestUserDTO(null, "am");

        underTest.addUser(newUser);
        assertThrows(RuntimeException.class, () -> {
            underTest.addUser(existingUser1);
        });
        assertThrows(RuntimeException.class, () -> {
            underTest.addUser(existingUser2);
        });
    }

    @Test
    public void testThatActivatingUserWorks(){
        UserDTO newUser = TestUtils.createTestUserDTO(null, "To be Activated");

        UsrEntity freshUser = new UsrEntity(underTest.addUser(newUser));

        underTest.activateUser(newUser.getUsername(), newUser.getPassword());

        assertThrows(RuntimeException.class, () -> {
            underTest.activateUser("as2dsSd346!@", "random");
        });

        assertThrows(RuntimeException.class, () -> {
            underTest.activateUser("am", "ScppK[lknegX");
        });

    }

}
