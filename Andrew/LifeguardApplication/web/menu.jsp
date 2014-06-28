<%-- 
    Document   : menu
    Created on : 4-Jun-2014, 8:03:01 PM
    Author     : Andrew
    Purpose    : This page makes up the menu bar visible on all pages of the project on the left hand side. Depending on the user's credentials, some options may not be available
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <body>
        <html:form action="/Menu">
            <table>
                <tr>
                    <td><input type="submit" name="action" value="<bean:message key="menu.message.viewSchedule" />"/></td>
                </tr>
                <logic:equal property="memberType" name="member" scope="session" value="1">
                <tr>
                    <td><input type="submit" name="action" value="<bean:message key="menu.message.modifySchedule" />"/></td>
                </tr>
                </logic:equal>
                <tr>
                    <td><input type="submit" name="action" value="<bean:message key="menu.message.viewLifeguards" />"/></td>
                </tr>
                <logic:equal property="memberType" name="member" scope="session" value="1">
                <tr>
                    <td><input type="submit" name="action" value="<bean:message key="menu.message.addLifeguard" />"/></td>
                </tr>
                </logic:equal>
                <tr>
                    <td><input type="submit" name="action" value="<bean:message key="menu.message.logout" />"/></td>
                </tr>
            </table>
        </html:form>
        
    </body>
</html>
