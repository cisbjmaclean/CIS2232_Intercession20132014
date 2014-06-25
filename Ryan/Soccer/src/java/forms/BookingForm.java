package forms;

import org.apache.struts.validator.ValidatorForm;

public class BookingForm extends ValidatorForm {
    
    private int fieldNum;
    private int userID;
    private String date = "";
    private int timeNum;

    public BookingForm() {
    }

    public int getFieldNum() {
        return fieldNum;
    }

    public void setFieldNum(int fieldNum) {
        this.fieldNum = fieldNum;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimeNum() {
        return timeNum;
    }

    public void setTimeNum(int timeNum) {
        this.timeNum = timeNum;
    }
}

