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
 * Purpose: This class stores the time in order to make the time num and time def usuable together.
 */
public class Time {
    private String timeDef;
    private int timeNum;

    public Time() {
    }

    public String getTimeDef() {
        return timeDef;
    }

    public void setTimeDef(String timeDef) {
        this.timeDef = timeDef;
    }

    public int getTimeNum() {
        return timeNum;
    }

    public void setTimeNum(int timeNum) {
        this.timeNum = timeNum;
    }
    
}
