/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import business.Member;
import forms.LoginForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import util.Validation;

/**
 *
 * @author Andrew
 */
public class LoginAction extends org.apache.struts.action.Action {

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

        LoginForm loginForm = (LoginForm) request.getAttribute("loginForm");
        Member member =  Validation.authenticateUser(loginForm.getUsername(), loginForm.getPassword());

        request.getSession().setAttribute("member", member);
        ActionMessages messages = new ActionMessages();
        ActionForward forward = new ActionForward();
        
        if (member.getMemberType() > 0) {
            messages.add("success", (new ActionMessage("label.login.success")));
            Member.userLoginLog(member.getUsername());
            forward = mapping.findForward("schedule");
        } else {
            messages.add("failure", (new ActionMessage("label.login.failure")));
            forward = mapping.findForward("login");
        }
        saveMessages(request, messages);
        return forward;

    }
}
