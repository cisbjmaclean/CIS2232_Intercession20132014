package actions;

import business.LoadStorageUnits;
import com.opensymphony.xwork2.ActionSupport;
import java.util.ArrayList;
import models.StorageUnitModel;

/**
 *
 * @author Michael Fesser
 * @since 6/6/2014
 *
 *
 */
public class ViewStorageUnitsAction extends ActionSupport {

    private static final long serialVersionUID = 1L;
    private ArrayList<StorageUnitModel> viewUnits = new ArrayList();
    
    /**
     * @return @throws Exception
     */
    public String execute() throws Exception {
        LoadStorageUnits loadUnits = new LoadStorageUnits();
        viewUnits = loadUnits.loadStorageUnits();
        return SUCCESS;
    }

    public ArrayList<StorageUnitModel> getViewUnits() {
        return viewUnits;
    }

    public void setViewUnits(ArrayList<StorageUnitModel> viewUnits) {
        this.viewUnits = viewUnits;
    }
}
