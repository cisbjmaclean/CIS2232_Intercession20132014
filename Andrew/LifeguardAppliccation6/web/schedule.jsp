<%-- 
    Document   : schedule
    Created on : 4-Jun-2014, 8:27:22 PM
    Author     : Andrew
    Purpose    : This page is where the user choses a day to view for the schedule
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="schedule.title"/></title>
    </head>
    <body>
        <html:form action="/ViewSchedule">
            <h3><bean:message key="schedule.title"/></h3>
            <table class="tableStuff">
                <tr>
                    <td><bean:message key="schedule.date"/></td>
                    <td><input type="date" name="date" value="2014-06-01"></td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: center"><input type="submit" name="submit" value="<bean:message key="schedule.view"/>"></td>
                </tr>
            </table>
        </html:form>
    </body>
</html>
