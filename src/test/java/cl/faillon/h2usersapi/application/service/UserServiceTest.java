package cl.faillon.h2usersapi.application.service;

import cl.faillon.h2usersapi.application.port.out.*;
import cl.faillon.h2usersapi.common.dto.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;


class UserServiceTest {

    @Mock
    private CreateUserPort createUserPort;

    @Mock
    private DeleteUserPort deleteUserPort;

    @Mock
    private GetAllUsersPort getAllUsersPort;

    @Mock
    private GetUserPort getUserPort;

    @Mock
    private UpdateUserPort updateUserPort;
    private CreateUserRequest createUserRequest;
    private UserResponse userResponse;
    private UUID userId;

    private DeleteUserResponse deleteUserResponse;

    private List<UserResponse> userList;

    private UpdateUserRequest updateUserRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        //MOCK CREATE USER REQUEST
        createUserRequest = new CreateUserRequest();
        createUserRequest.setName("testUser");
        createUserRequest.setEmail("test@testmail.cl");
        createUserRequest.setPassword("testPass");

        List<PhoneDTO> phonesList = List.of(PhoneDTO.builder()
                .number("99999999")
                .cityCode("9")
                .contryCode("56").build());

        createUserRequest.setPhones(phonesList);

        //MOCK USER RESPONSE
        userResponse = new UserResponse();
        userResponse.setEmail("test@testmail.cl");
        userResponse.setName("testUser");
        userResponse.setPhones(phonesList);
        userResponse.setPassword("testPass");

        userId = UUID.fromString("e7d8d653-8838-4868-8e57-4ef9fde3d781");

        //MOCK DELETE USER RESPONSE
        deleteUserResponse = new DeleteUserResponse();
        deleteUserResponse.setUserId(userId);
        deleteUserResponse.setMessage("Usuario Elimininado con exito");

        //MOCK LIST USERS
        userList = List.of(UserResponse.builder()
                .name("testUser")
                .email("test@testmail.cl")
                .password("testPass")
                .phones(phonesList).build());

        //MOCK UPDATE USER
        updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setName("testUser");
        updateUserRequest.setEmail("test@testmail.cl");
        updateUserRequest.setPhones(phonesList);
        updateUserRequest.setPassword("testPass");

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createUser() {
        when(createUserPort.createUser(createUserRequest)).thenReturn(userResponse);
        assertNotNull(userResponse);
        assertEquals(userResponse.getName(), "testUser");
    }

    @Test
    void deleteUser() {
        when(deleteUserPort.deleteUser(userId))
                .thenReturn(deleteUserResponse);
        assertNotNull(deleteUserResponse);
        assertEquals(deleteUserResponse.getUserId(), userId);
    }

    @Test
    void getAllUsers() {
        when(getAllUsersPort.listAllUsers()).thenReturn(userList);
        assertNotNull(userList);
        assertEquals(userList.size(), 1);
    }

    @Test
    void getUser() {
        when(getUserPort.getUser(userId))
                .thenReturn(userResponse);

        assertNotNull(userResponse);
        assertEquals(userResponse.getName(), "testUser");
    }

    @Test
    void updateUser() {
        when(updateUserPort.updateUser(userId, updateUserRequest))
                .thenReturn(userResponse);

        assertNotNull(userResponse);
        assertEquals(userResponse.getName(), "testUser");
    }
}