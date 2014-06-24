/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package field;

/**
 *
 * @author rforrester
 * 
 * Purpose: This class stores a field object that is needed to view the booked field.
 */
public class Field {
    private String fieldName; 
    private String userName;
    private int fieldNum;
    private String fieldDate; 
    private String fieldTime; 

    public Field() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(int fieldNum) {
        this.fieldNum = fieldNum;
    }
    
    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldDate() {
        return fieldDate;
    }

    public void setFieldDate(String fieldDate) {
        this.fieldDate = fieldDate;
    }

    public String getFieldTime() {
        return fieldTime;
    }

    public void setFieldTime(String fieldTime) {
        this.fieldTime = fieldTime;
    }
    
}
