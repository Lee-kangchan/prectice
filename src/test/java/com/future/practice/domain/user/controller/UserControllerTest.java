package com.future.practice.domain.user.controller;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.service.UserService;
import com.future.practice.global.exception.ControllerExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Slf4j
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService service;

    protected MockHttpSession session;

    private UserDto.Login loginDto;
    private UserDto.Inform informDto;
    @BeforeEach
    public void setUp() throws Exception{
        UserController userController = new UserController(service);
        session = new MockHttpSession();
        mockMvc = MockMvcBuilders.standaloneSetup(userController).
                setControllerAdvice(new ControllerExceptionHandler()).
                build();

        informDto = UserDto.Inform.builder().email("test3").password("aaaa1234").name("test").phone("010-2152-6111").build();
        loginDto = UserDto.Login.builder().email("test3").password("aaaa1234").build();
        session.setAttribute("user", informDto.toEntity());
    }

    @Test
    @Order(1)
    @DisplayName("회원가입 API 테스트")
    void 회원가입_API_테스트() throws Exception {
        mockMvc.perform(post("/v1/user/sign")
                .content(informDto.toString())
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print());
    }
    @Test
    @Order(2)
    @DisplayName("로그인 API 테스트")
    void 로그인_API_테스트() throws Exception {
        log.info(loginDto.toString());
        session.invalidate();
        mockMvc.perform(post("/v1/user/login")
                        .session(session)
                        .content(loginDto.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }


    @Test
    @Order(3)
    @Transactional
    @DisplayName("유저 수정 API 테스트")
    void 유저수정_API_테스트() throws Exception {
        informDto.setName("dcba");
        informDto.setPassword("abcd1111");
        mockMvc.perform(put("/v1/user/")
                        .session(session)
                        .content(informDto.toString())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Order(4)
    @DisplayName("유저 조회 API 테스트")
    void 유저조회_API_테스트() throws Exception {
        mockMvc.perform(get("/v1/user")
                        .session(session)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @Order(5)
    @DisplayName("유저 삭제 API 테스트")
    void 유저삭제_API_테스트() throws Exception {
        mockMvc.perform(delete("/v1/user")
                        .session(session))
                .andExpect(status().isOk())
                .andDo(print());
    }
}