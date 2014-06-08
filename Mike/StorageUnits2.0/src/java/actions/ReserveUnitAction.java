package actions;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author Michael
 * @since 6/7/2014
 */
public class ReserveUnitAction extends ActionSupport{
   private int unitId;
   
   public String execute() throws Exception {
        //pass to db
       return SUCCESS;
    }

    public int getUnitId() {
        return unitId;
    }

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
   
}
