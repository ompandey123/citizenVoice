/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stats;

import beans.StatsData;
import entities.Citytb;
import entities.Districttb;
import entities.Questiontb;
import entities.Statetb;
import entities.Talukatb;
import entities.Villagetb;
import entities.Wardtb;
import entities.Zonetb;
import jakarta.annotation.security.DeclareRoles;
import jakarta.annotation.security.PermitAll;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@DeclareRoles({"admin", "citizen"})
@Stateless
public class AnswerStats {

    @PersistenceContext(unitName = "citizenpu")
    EntityManager em;

    @PermitAll
    public Questiontb getQuestionById(int id) {
        return (Questiontb) em.find(Questiontb.class, id);
    }

    @PermitAll
    public Collection<StatsData> getStats(int qid, String level, Integer pid) {
        List<Object[]> data = null;
        
        String levelcolumn = "";

        if (level.equals("state")) {
            levelcolumn = "u.stateId.stateId";
        } else if (level.equals("district")) {
            levelcolumn = "u.districtId.getDistrictId()";
        } else if (level.equals("city")) {
            levelcolumn = "u.cityId.getCityId()";
        } else if (level.equals("zone")) {
            levelcolumn = "u.zoneId..getZoneId()";
        } else if (level.equals("ward")) {
            levelcolumn = "u.wardId.getWardId()";
        } else if (level.equals("taluka")) {
            levelcolumn = "u.talukaId.getTalukaId()";
        } else if (level.equals("village")) {
            levelcolumn = "u.villageId.getVillageId()";
        }

        if (pid != 0) {
            data = em.createQuery("select " + levelcolumn.substring(0, levelcolumn.lastIndexOf(".")) + ",  u.qid, count(NULLIF(u.option1,'')), count(NULLIF(u.option2,'')), count(NULLIF(u.option3,'')), count(NULLIF(u.option4,'')) from  UserAnswer u where " + levelcolumn + "=" + pid + " and u.qid.qid=" + qid).getResultList();
        } else {
            data = em.createQuery("select " + levelcolumn.substring(0, levelcolumn.lastIndexOf(".")) + ",  u.qid, count(NULLIF(u.option1,'')), count(NULLIF(u.option2,'')), count(NULLIF(u.option3,'')), count(NULLIF(u.option4,'')) from  UserAnswer u where u.qid.qid=" + qid + " group by " + levelcolumn.substring(0, levelcolumn.lastIndexOf("."))).getResultList();
        }

        //List<Object[]> results1 = em.createQuery("select u.qid, (u.option1), count(u.option2), count(u.option3), count(u.option4) from  UserAnswer u  group by u.wardId ").getResultList();
        Collection<StatsData> result = new ArrayList<>();

        //  sdata.setQ(getQuestionById(qid));
        for (Object[] obj : data) {
            StatsData sdata = new StatsData();
            if (level.equals("state")) {
                sdata.setLeveltb((Statetb) obj[0]);
                sdata.setLevelName(((Statetb) obj[0]).getStateName());
            } else if (level.equals("district")) {
                sdata.setLeveltb((Districttb) obj[0]);
                sdata.setLevelName(((Districttb) obj[0]).getDistrictName());
            } else if (level.equals("city")) {
                sdata.setLeveltb((Citytb) obj[0]);
                sdata.setLevelName(((Citytb) obj[0]).getCityName());
            } else if (level.equals("zone")) {
                sdata.setLeveltb((Zonetb) obj[0]);
                sdata.setLevelName(((Zonetb) obj[0]).getZoneName());
            } else if (level.equals("ward")) {
                sdata.setLeveltb((Wardtb) obj[0]);
                sdata.setLevelName(((Wardtb) obj[0]).getWardName());
            } else if (level.equals("taluka")) {
                sdata.setLeveltb((Talukatb) obj[0]);
                sdata.setLevelName(((Talukatb) obj[0]).getTalukaName());
            } else if (level.equals("village")) {
                sdata.setLeveltb((Villagetb) obj[0]);
                sdata.setLevelName(((Villagetb) obj[0]).getVillageName());
            }

            sdata.setQ((Questiontb) obj[1]);
            sdata.setOption1((Long) obj[2]);
            sdata.setOption2((Long) obj[3]);
            sdata.setOption3((Long) obj[4]);
            sdata.setOption4((Long) obj[5]);

            sdata.setTotalResponses(sdata.getOption1() + sdata.getOption2() + sdata.getOption3() + sdata.getOption4());

            result.add(sdata);
        }

        return result;
    }

}
