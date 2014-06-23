    <%-- 
    Document   : adminMenu
    Created on : Jun 16, 2014, 3:35:14 PM
    Author     : Michael
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*"%>

<html:html lang="true">
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Menu Page</title>
        </head>
        <body>
            <html:form action="/adminMenu">
                <table>
                    <tr>
                        <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.search"/></html:submit>                   
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.view.all.customers"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.add.customer"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.view.all.storage.units"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.add.storage.unit"/></html:submit>                   
                            </td>
                        </tr>                                          
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.logout"/></html:submit>
                            </td>
                        </tr>
                    </table>
            </html:form>
        </body>
    </html>
</html:html>