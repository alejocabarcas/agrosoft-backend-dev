package usco.agrosoft.controllers;

import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;
import usco.agrosoft.dao.FarmDao;
import usco.agrosoft.models.Farm;


import java.util.List;


@RestController
@Configuration
public class FarmController {
    /*@Autowired
    private FarmDao FarmDao;

    @RequestMapping(value = "api/obtainfarms", method = RequestMethod.GET)
    public List<Farm> getFarms() {return FarmDao.getFarms()}

    @RequestMapping(value = "api/obtainfarm/{idFarm}", method = RequestMethod.GET)
    public JSONObject Farm(@RequestBody Farm farm) {
        String id_farm = farm.getIdFarm();
        JSONObject response = new JSONObject();
        if (id_farm == null || id_farm.equals("")){
            response.put("error", true);
            response.put("response", "El id de granja no puede estar vacio");
            return response;
        }
        Farm Farm = FarmDao.getFarm(id_farm);
        if (Farm == null){
            response.put("error", true);
            response.put("response", "La granja no existe");
            return response;
        }else{
            response.put("error", false);
            response.put("response", Farm);
            return response;
        }
    }



    @CrossOrigin
    @RequestMapping(value = "api/eliminatefarm", method = RequestMethod.PUT)
    public JSONObject eliminateFarm(@RequestBody Farm farm) {
        JSONObject response = new JSONObject();
        String id_farm = farm.getIdFarm();
        if (id_farm == null || id_farm.equals("")) {
            response.put("error", true);
            response.put("response", "El id de granja no puede estar vacio");
            return response;
        } else {
            String saved = FarmDao.eliminateFarm(farm);
            if (saved.equals("1")) {
                response.put("error", true);
                response.put("response", "No se ha encontrado la granja");
                return response;
            } else if (saved.equals("2")) {
                response.put("error", true);
                response.put("response", "La granja ya se encuentra inactivo");
                return response;
            } else {
                response.put("error", false);
                response.put("response", " Su granja se ha eliminado correctamente");
                return response;
            }
        }
    }

    @CrossOrigin
    @RequestMapping(value = "api/modifyfarm", method = RequestMethod.PUT)
    public JSONObject modifyFarm(@RequestBody Farm farm) {
        String id_farm = farm.getIdFarm();
        if (id_farm == null || id_farm.equals("")) {
            JSONObject response = new JSONObject();
            response.put("error", true);
            response.put("response", "El id de granja no puede estar vacio");
            return response;
        }
        return xd;
    }*/

}