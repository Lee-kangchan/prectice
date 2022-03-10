package com.future.practice.domain.user.mapper;

import com.future.practice.global.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Mapper
@Repository
public interface UserMapper {
    public User findOneByIdAndPassword(User user);
    public List<HashMap<String, Object>> testcase();
    public void save(User user);
    public void updateByUserPasswordAndUserNameAndUserPhone(User user);
    public void deleteByUserEmail(User user);
}
