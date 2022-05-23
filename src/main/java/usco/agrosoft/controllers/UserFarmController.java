package usco.agrosoft.controllers;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.minidev.json.JSONObject;
import usco.agrosoft.dao.FarmDao;
import usco.agrosoft.dao.UserFarmDao;
import usco.agrosoft.models.Farm;
import usco.agrosoft.models.UserFarm;

@RestController
public class UserFarmController {

    UserFarm userFarm = new UserFarm();

    @Autowired
    private FarmDao farmDao;

    @Autowired
    private UserFarmDao userFarmDao;

    @RequestMapping(value = "api/saveuserfarm", method = RequestMethod.POST)
    public JSONObject saveUserFarm(@RequestBody JSONObject userFarmObject) {
        JSONObject response = new JSONObject();
        response.put("error", true);
        

        /*

        //Validate data
        if(userFarmObject.get("idUser") == null || userFarmObject.get("idUser").equals("")){
            response.put("response", "Falta el campo idUser");
            return response;
        }
        if(userFarmObject.get("idRole") == null || userFarmObject.get("idRole").equals("")){
            response.put("response", "Falta el campo idRole");
            return response;
        }

        //Create an object of type Farm
        Farm farm = new Farm();
        farm.setIdCountry(userFarmObject.get("idCountry").toString());
        farm.setNameFarm(userFarmObject.get("nameFarm").toString());
        farm.setDescriptionFarm(userFarmObject.get("descriptionFarm").toString());
        farm.setCreatedDate(LocalDateTime.now());

        JSONObject farmResponse = farmDao.saveFarm(farm);

        if(farmResponse.get("error").equals(true)){
            response.put("response", farmResponse.get("response"));
            return response;
        }

        //create an object of type UserFarm
        userFarm.setIdUser(userFarmObject.get("idUser").toString());
        userFarm.setIdRole(userFarmObject.get("idRole").toString());
        userFarm.setIdFarm(farmResponse.get("response").toString());

        UserFarm userFarmDaoResponse = userFarmDao.saveUserFarm(userFarm);

        if(userFarmDaoResponse == null){
            response.put("response", "Error al guardar la finca");
            return response;
        }

        response.put("error", false);
        response.put("response", "Finca guardada correctamente");
        */
        return response;
    }

    @CrossOrigin
    @RequestMapping(value = "api/userfarms/{idUser}", method = RequestMethod.GET)
    public JSONObject userFarms(@PathVariable String idUser) {
        
        JSONObject response = new JSONObject();
        response.put("error", true);
        
        if(idUser == null || idUser.equals("")){
            response.put("response", "Falta el campo idUser");
            return response;
        }
        
        List<UserFarm> userFarms = userFarmDao.getUserFarms(idUser);

        if(userFarms == null){
            response.put("response", "Error al obtener las fincas");
            return response;
        }
        //create list from userFarms of id_farm
        String listIdFarms = "";
        for(int i = 0; i < userFarms.size(); i++){
            listIdFarms += "'" + userFarms.get(i).getIdFarm() + "'";
            if(i != userFarms.size() - 1){
                listIdFarms += ",";
            }
        }
        
        //System.out.println(listIdFarms);

        //consult farms by listIdFarms
        //String query = "id_farm in (" + listIdFarms + ")";

        List<Farm> farms = farmDao.getFarms(listIdFarms);

        if(farms == null){
            response.put("response", "Error al obtener las fincas");
            return response;
        }

        response.put("error", false);
        response.put("response", farms);

        return response;
    }
    
}
