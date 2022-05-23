package usco.agrosoft.dao;

import usco.agrosoft.models.Farm;

import javax.transaction.Transactional;
import java.util.List;
import net.minidev.json.JSONObject;

public interface FarmDao {
    List<Farm> getFarms(String listIdFarms);

    Farm getFarm(String idFarm);

    String eliminateFarm(String idFarm);

    String modifyFarm(JSONObject data);
}