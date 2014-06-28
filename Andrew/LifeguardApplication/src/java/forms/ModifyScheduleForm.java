/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package forms;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author Andrew
 */
public class ModifyScheduleForm extends ActionForm {
    private String date, simmonsLifeguard1, simmonsLifeguard2, simmonsLifeguard3, splitLifeguard1, 
            splitLifeguard2, vpLifeguard1, vpLifeguard2, vpLifeguard3;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSimmonsLifeguard1() {
        return simmonsLifeguard1;
    }

    public void setSimmonsLifeguard1(String simmonsLifeguard1) {
        this.simmonsLifeguard1 = simmonsLifeguard1;
    }

    public String getSimmonsLifeguard2() {
        return simmonsLifeguard2;
    }

    public void setSimmonsLifeguard2(String simmonsLifeguard2) {
        this.simmonsLifeguard2 = simmonsLifeguard2;
    }

    public String getSimmonsLifeguard3() {
        return simmonsLifeguard3;
    }

    public void setSimmonsLifeguard3(String simmonsLifeguard3) {
        this.simmonsLifeguard3 = simmonsLifeguard3;
    }

    public String getSplitLifeguard1() {
        return splitLifeguard1;
    }

    public void setSplitLifeguard1(String splitLifeguard1) {
        this.splitLifeguard1 = splitLifeguard1;
    }

    public String getSplitLifeguard2() {
        return splitLifeguard2;
    }

    public void setSplitLifeguard2(String splitLifeguard2) {
        this.splitLifeguard2 = splitLifeguard2;
    }

    public String getVpLifeguard1() {
        return vpLifeguard1;
    }

    public void setVpLifeguard1(String vpLifeguard1) {
        this.vpLifeguard1 = vpLifeguard1;
    }

    public String getVpLifeguard2() {
        return vpLifeguard2;
    }

    public void setVpLifeguard2(String vpLifeguard2) {
        this.vpLifeguard2 = vpLifeguard2;
    }

    public String getVpLifeguard3() {
        return vpLifeguard3;
    }

    public void setVpLifeguard3(String vpLifeguard3) {
        this.vpLifeguard3 = vpLifeguard3;
    }
    
    
}
