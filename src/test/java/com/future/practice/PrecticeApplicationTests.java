package com.future.practice;

import com.future.practice.global.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

@SpringBootTest
@Slf4j
class PrecticeApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void MybatisTest() throws IOException {
        Reader reader = Resources.getResourceAsReader("mapper/user.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = factory.openSession();

        List<User> list = session.selectList("UserMapper.idAndPasswordCheck");

        log.info(":: 0. all User(SELECT) ? ");

        for(int i = 0; i < list.size() ; i++){
            System.out.println("<"+ (i+1) + "> 번째 회원."+ list.get(i).toString());
        }

    }
}
