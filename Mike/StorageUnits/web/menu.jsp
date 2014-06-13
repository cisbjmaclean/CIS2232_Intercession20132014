<%-- 
    Document   : menu
    Created on : Jun 10, 2014, 3:49:56 PM
    Author     : Michael
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Menu Page</title>
        </head>
        <body>
            <html:form action="/menu">
                <table>
                    <tr>
                        <td>
                            <html:submit property="action"><bean:message key="label.menu.view.my.units"/></html:submit>                   
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.menu.view.all.units"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.menu.view.calander"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.menu.profile"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.menu.logout"/></html:submit>
                            </td>
                        </tr>
                    </table>
            </html:form>
        </body>
    </html>
</html:html>