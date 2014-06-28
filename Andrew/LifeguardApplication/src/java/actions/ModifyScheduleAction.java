/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package actions;

import forms.ModifyScheduleForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import util.ScheduleUtility;

/**
 *
 * @author Andrew
 */
public class ModifyScheduleAction extends org.apache.struts.action.Action {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        ModifyScheduleForm newEntry = (ModifyScheduleForm) form;
        
        
        if(ScheduleUtility.modifySchedule(newEntry.getDate(), newEntry.getSimmonsLifeguard1(), newEntry.getSimmonsLifeguard2(), newEntry.getSimmonsLifeguard3(), newEntry.getSplitLifeguard1(), newEntry.getSplitLifeguard2(), newEntry.getVpLifeguard1(), newEntry.getVpLifeguard2(), newEntry.getVpLifeguard3())){
            return mapping.findForward("modifySchedule");
        }
        return mapping.findForward("modifySchedule");
    }
}
