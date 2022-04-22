package com.future.practice.domain.user.service;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.repository.UserRepository;
import com.future.practice.global.constant.Common;
import com.future.practice.global.entity.User;
import static com.future.practice.global.constant.Common.PASSWORD_PATTERN;
import com.future.practice.global.exception.ErrorCode;
import com.future.practice.global.exception.custom.LoginException;
import com.future.practice.global.exception.custom.PasswordRulesViolationException;
import com.future.practice.global.exception.custom.UserNotExistException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;


@Service("UserService")
@RequiredArgsConstructor
public class UserServiceImplVer2 implements UserService {

    private final UserRepository userRepository;
    /**
     * 로그인 서비스
     * @param loginDto
     * @return
     */
    @Override
    public User loginService(UserDto.Login loginDto) {
        return userRepository.findUserByUserEmailAndUserPassword(loginDto.getEmail(), loginDto.getPassword())
                .orElseThrow(() -> new LoginException(ErrorCode.EMAIL_NOT_EXIST));
    }

    /**
     * 유저 상세 조회
     * @param user
     * @return
     */
    @Override
    public User userInformService(User user){
        return userRepository.findUserByUserEmail(user.getUserEmail()).get();
    }

    /**
     * 회원가입 서비스
     * @param informDto
     */
    @Override
    public void signService(UserDto.Inform informDto) {
        // 이메일 중복체크
        if(userRepository.findUserByUserEmail(informDto.getEmail()).isPresent()) throw new LoginException(ErrorCode.EMAIL_ALREADY_EXIST);
        // 패스워드 패턴 체크
        if(PASSWORD_PATTERN.matcher(informDto.getPassword()).find()) throw new LoginException(ErrorCode.PASSWORD_RULES_VIOLATION);
        // 존재 유저 확인 체크
        if(userRepository.findUserByUserPhone(informDto.getPhone()).isPresent()) throw new LoginException(ErrorCode.USER_ALREADY_EXIST);
        // 유저 저장
        userRepository.save(informDto.toEntity());
    }

    /**
     * 유저 업데이트 서비스
     * @param informDto
     * @param email
     */
    @Override
    public void updateService(UserDto.Inform informDto, String email) {

        // 패스워드 패턴 체크
        if(PASSWORD_PATTERN.matcher(informDto.getPassword()).find()) throw new LoginException(ErrorCode.PASSWORD_RULES_VIOLATION);
        // 유저 존재 체크
        if(!userRepository.findUserByUserEmail(email).isPresent()) throw new LoginException(ErrorCode.USER_NOT_EXIST);
        // 유저 변경
        userRepository.save(informDto.toEntity(email));
    }

    /**
     * 유저 삭제 서비스
     * @param email
     */
    @Override
    public void deleteService(String email) {
        // 유저 존재 확인
        userRepository.findUserByUserEmail(email).orElseThrow(() ->  new LoginException(ErrorCode.USER_NOT_EXIST));
        // 유저 삭제
        userRepository.deleteUserByUserEmail(email);
    }

}
