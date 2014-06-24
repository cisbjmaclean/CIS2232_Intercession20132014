package actions;

import business.ReserveStorageUnit;
import forms.LoginForm;
import forms.ReserveStorageUnitForm;
import forms.StorageUnitForm;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import util.SortStorageUnits;

/**
 *
 * @author Michael
 * @since 6/7/2014
 */
public class ReserveStorageUnitAction extends Action {

    private ActionForward forwardTo;
    private LoginForm authenticated;
    private ReserveStorageUnit reserveUnit;
    private ReserveStorageUnitForm reserveUnitForm;
    private LoginForm user;
    private ArrayList<StorageUnitForm> storageUnits;

    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        authenticated = (LoginForm) request.getSession().getAttribute("customer");
        if (authenticated == null || authenticated.isValidated() == false) {
            messages.add("error", (new ActionMessage("label.session.expired")));
            saveMessages(request, messages);
            return mapping.findForward("login");
        }
        user = (LoginForm) request.getSession().getAttribute("customer");
        reserveUnitForm = (ReserveStorageUnitForm) request.getAttribute("reserveStorageUnitForm");
        storageUnits = (ArrayList<StorageUnitForm>) request.getSession().getAttribute("storageUnits");
        reserveUnit = new ReserveStorageUnit();
        reserveUnit.reserveUnit(reserveUnitForm, user, storageUnits);
        request.getSession().setAttribute("storageUnits", SortStorageUnits.sortDefault(storageUnits));
          
        messages.add("success", (new ActionMessage("label.customer.view.all.reserve.storage.unit.success")));
        saveMessages(request, messages);
        forwardTo = mapping.findForward("customerStorageUnitView");
        return forwardTo;
    }
}
