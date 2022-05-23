package usco.agrosoft.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

import usco.agrosoft.models.UserFarm;


@Repository
@Transactional
public class UserFarmDaoImplement implements UserFarmDao {

    @PersistenceContext
    private EntityManager entityManager;

    
    UserFarm userFarm = new UserFarm();

    @Override
    @Transactional
    public UserFarm saveUserFarm(UserFarm userFarm) {
        try{
            entityManager.merge(userFarm);
            return userFarm;
        }catch(Exception e){
            return null;
        }
    }    

    @Override
    @Transactional
    public List<UserFarm> getUserFarms(String idUser) {
        try{

            String query = "FROM UserFarm WHERE id_User = :idUser";
            List<UserFarm> userFarms = entityManager.createQuery(query)
                .setParameter("idUser", idUser).getResultList();
            return userFarms;
        } catch (NoResultException e){
            return null;
        }
    }
}
