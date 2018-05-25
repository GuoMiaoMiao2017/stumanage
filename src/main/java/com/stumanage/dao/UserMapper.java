package com.stumanage.dao;

import com.stumanage.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUsername(String username);

    int checkEmail(String email);

    int checkEmailByUserId(@Param("id") Integer id, @Param("email") String email);

    int checkPassword(@Param("id") Integer id, @Param("password") String password);

    User selectLogin(@Param("username") String username, @Param("password") String password);

    String selectQuestionByUsername(String username);

    int updatePasswordByUsername(@Param("username") String username, @Param("passwordNew") String passwordNew);

    int checkAnswer(@Param("username") String username, @Param("question") String question, @Param("answer") String answer);
}