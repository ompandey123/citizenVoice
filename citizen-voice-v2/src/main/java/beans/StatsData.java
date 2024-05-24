/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package beans;

import entities.Questiontb;
import java.io.Serializable;

/**
 *
 * @author root
 */
public class StatsData implements Serializable {

    Questiontb q;
    Object leveltb;
    Long option1;
    Long option2;
    Long option3;
    Long option4;
    Long totalResponses;

    String levelName;

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Questiontb getQ() {
        return q;
    }

    public void setQ(Questiontb q) {
        this.q = q;
    }

    public Object getLeveltb() {
        return leveltb;
    }

    public void setLeveltb(Object leveltb) {
        this.leveltb = leveltb;
    }

    public Long getOption1() {
        return option1;
    }

    public void setOption1(Long option1) {
        this.option1 = option1;
    }

    public Long getOption2() {
        return option2;
    }

    public void setOption2(Long option2) {
        this.option2 = option2;
    }

    public Long getOption3() {
        return option3;
    }

    public void setOption3(Long option3) {
        this.option3 = option3;
    }

    public Long getOption4() {
        return option4;
    }

    public void setOption4(Long option4) {
        this.option4 = option4;
    }

    public Long getTotalResponses() {
        return totalResponses;
    }

    public void setTotalResponses(Long totalResponses) {
        this.totalResponses = totalResponses;
    }

}
