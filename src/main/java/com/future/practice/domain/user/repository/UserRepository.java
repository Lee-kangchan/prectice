package com.future.practice.domain.user.repository;

import com.future.practice.domain.user.mapper.UserMapper;
import com.future.practice.global.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private UserMapper mapper;
    private SqlSession sqlSession;

    public UserRepository(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        mapper = sqlSession.getMapper(UserMapper.class);
    }

    public User idAndPasswordCheck(User user){
        return mapper.idAndPasswordCheck(user);
    }
    public void signUp(User user){
        mapper.signUp(user);
    }
    public void updateUser(User user){
        mapper.updateUser(user);
    }
    public void deleteUser(User user){
        mapper.deleteUser(user);
    }
}
