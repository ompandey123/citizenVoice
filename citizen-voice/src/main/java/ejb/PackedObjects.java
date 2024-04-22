/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejb;

import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author ompan
 */
public class PackedObjects implements Serializable {
    
    Collection<Integer> state_ids;
    Collection<Integer> district_ids; 
    Collection<Integer> city_ids; 
    Collection<Integer> ward_ids;
    Collection<Integer> zone_ids;
    Collection<Integer> taluka_ids; 
    Collection<Integer> village_ids;

    public Collection<Integer> getState_ids() {
        return state_ids;
    }

    public void setState_ids(Collection<Integer> state_ids) {
        this.state_ids = state_ids;
    }

    public Collection<Integer> getDistrict_ids() {
        return district_ids;
    }

    public void setDistrict_ids(Collection<Integer> district_ids) {
        this.district_ids = district_ids;
    }

    public Collection<Integer> getCity_ids() {
        return city_ids;
    }

    public void setCity_ids(Collection<Integer> city_ids) {
        this.city_ids = city_ids;
    }

    public Collection<Integer> getWard_ids() {
        return ward_ids;
    }

    public void setWard_ids(Collection<Integer> ward_ids) {
        this.ward_ids = ward_ids;
    }

    public Collection<Integer> getZone_ids() {
        return zone_ids;
    }

    public void setZone_ids(Collection<Integer> zone_ids) {
        this.zone_ids = zone_ids;
    }

    public Collection<Integer> getTaluka_ids() {
        return taluka_ids;
    }

    public void setTaluka_ids(Collection<Integer> taluka_ids) {
        this.taluka_ids = taluka_ids;
    }

    public Collection<Integer> getVillage_ids() {
        return village_ids;
    }

    public void setVillage_ids(Collection<Integer> village_ids) {
        this.village_ids = village_ids;
    }
    
    
    
    
}
