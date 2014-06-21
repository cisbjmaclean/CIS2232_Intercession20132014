<%-- 
    Document   : createUser
    Created on : Jun 3, 2014, 3:17:42 PM
    Author     : Michael Fesser
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body>

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>

        <div style="color:red"><html:errors/></div>    
        <table>
            <html:form action="/mainMenu">   
                <tr>
                    <td>
                        <html:submit property="action"><bean:message key="label.main.menu.login"/></html:submit>
                    </td>    
                </tr>         
                <tr>
                    <td>
                        <html:submit property="action"><bean:message key="label.main.menu.create"/></html:submit>
                    </td>    
                </tr>         
                 <tr>
                    <td>
                        <html:submit property="action"><bean:message key="label.main.menu.view.all.storage.units"/></html:submit>
                    </td>    
                </tr>
            </html:form>
        </table>
    </body>
</html:html>


