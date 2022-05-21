package usco.agrosoft.dao;

import usco.agrosoft.models.User;

import java.io.UnsupportedEncodingException;
import java.util.*;

import net.minidev.json.JSONObject;

public interface UserDao {
    List<User> getUsers();

    String register(User user) throws UnsupportedEncodingException;

    User getUser(String idUser);
    // String oneRegister(User user) throws UnsupportedEncodingException;

    User login(User user) throws UnsupportedEncodingException;

    String activate(String token);

    String generateToken(JSONObject data) throws UnsupportedEncodingException;

    String changePassword(JSONObject data);

    String newPassword(JSONObject data);

    String changeState(User user);

    JSONObject changePhoneNumber(String idUser, int idIdentifier, String phoneNumber);
}
