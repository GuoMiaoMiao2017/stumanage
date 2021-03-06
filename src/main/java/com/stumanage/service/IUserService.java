package com.stumanage.service;

import com.stumanage.common.ServerResponse;
import com.stumanage.pojo.User;

/**
 * Created by 15295 on 2018/5/10.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);
    ServerResponse<String> register(User user);
    ServerResponse<String> checkValid(String str, String type);
    ServerResponse<String> selectQuestion(String username);
    ServerResponse<User> updateInformation(User user);
    ServerResponse<User> getInformation(Integer id);
    ServerResponse<String> checkAnswer(String username, String question, String answer);
    ServerResponse<String> forgetResetPassword(String username, String passwordNew, String forgetToken);
    ServerResponse<String> resetPassword(User user, String passwordOld, String passwordNew);
}
