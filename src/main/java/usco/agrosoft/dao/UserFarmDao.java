package usco.agrosoft.dao;

import java.util.List;

import usco.agrosoft.models.UserFarm;

public interface UserFarmDao {
    UserFarm saveUserFarm(UserFarm userFarm);
    List<UserFarm> getUserFarms(String idUser);
}
