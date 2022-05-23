package usco.agrosoft.dao;
import usco.agrosoft.models.Farm;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import java.util.*;

import net.minidev.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Repository
@Transactional
public class FarmDaoImplement implements FarmDao {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public List<Farm> getFarms(String listIdFarms) {
        try{
            String preQuery ="FROM Farm WHERE id_farm IN ("+ listIdFarms + ") AND is_active_farm = :isActiveFarm";
            List<Farm> result = (List<Farm>)entityManager.createQuery(preQuery)
                    .setParameter("isActiveFarm", true)
                    .getResultList();
            return result;
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    @Transactional
    public Farm getFarm(String idFarm) {
        String query = "FROM User WHERE id_farm = :idFarm AND is_active_farm = :isActiveFarm";
        try {
            Farm result = (Farm) entityManager.createQuery(query)
                    .setParameter("idFarm", idFarm)
                    .setParameter("isActiveFarm", true)
                    .getSingleResult();
            return result;
        } catch (NoResultException e) {
            return null;
        }
    }
    
    @Override
    @Transactional
    public String eliminateFarm(String idFarm) {
        String query = "FROM User WHERE id_farm = :idFarm";
        List<Farm> listFarms = entityManager.createQuery(query)
                .setParameter("idFarm", idFarm)
                .getResultList();
        if (!listFarms.isEmpty()) {
            Farm farmFound = listFarms.get(0);
            if (farmFound.isActiveFarm()) {
                farmFound.setActiveFarm(false);
                entityManager.merge(farmFound);
                return "0";
            } else {
                return "2";
            }
        } else {
            return "1";
        }
    }
    
    @Override
    @Transactional
    public String modifyFarm(JSONObject data){
        /*String query = "FROM Farm WHERE id_farm = :idFarm AND is_active_farm = :isActiveFarm";

        try{        
            Farm farm = (Farm) entityManager.createQuery(query)
                .setParameter("idFarm", farm.getIdFarm())
                .setParameter("isActiveFarm", true)
                .getSingleResult();
    
            farm.setNameFarm(farm.getNameFarm());
            farm.setDescriptionFarm(farm.getDescriptionFarm());
            entityManager.merge(farm);
            entityManager.close();

            return farm.getIdFarm();
        }    
        catch (Exception e){
            
        } */
        return null;
    }
}