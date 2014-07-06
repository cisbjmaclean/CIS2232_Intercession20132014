<%-- 
    Document   : modifySchedule
    Created on : 16-Jun-2014, 12:27:38 AM
    Author     : Andrew
    Purpose    : This page accepts a date and the names of lifeguards so that a certain day of the schedule can be modified
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="schedule.modify"/></title>
    </head>
    <body>
        <html:form action="/ModifySchedule">
            <h3><bean:message key="schedule.modify"/></h3>
            <table class="tableStuff">
                <tr>
                    <td><bean:message key="schedule.day"/></td>
                    <td><input type="date" name="date"</td>
                </tr>
            </table>
                    <h3><bean:message key="schedule.simmons"/></h3>
            <table class="tableStuff">
                <tr>
                    <th></th>
                    <th><bean:message key="schedule.name"/></th>
                </tr>
                <tr>
                    <td><bean:message key="schedule.lifeguard1"/></td>
                    <td><input type="text" name="simmonsLifeguard1" required/></td>
                </tr>
                <tr>
                    <td><bean:message key="schedule.lifeguard2"/></td>
                    <td><input type="text" name="simmonsLifeguard2" required/></td>
                </tr>
                <tr>
                    <td><bean:message key="schedule.lifeguard3"/></td>
                    <td><input type="text" name="simmonsLifeguard3" required/></td>
                </tr>
            </table>
            <h3><bean:message key="schedule.split"/></h3>        
            <table class="tableStuff">
                <tr>
                    <th></th>
                    <th><bean:message key="schedule.name"/></th>
                </tr>
                <tr>
                    <td><bean:message key="schedule.lifeguard1"/></td>
                    <td><input type="text" name="splitLifeguard1" required/></td>
                </tr>
                <tr>
                    <td><bean:message key="schedule.lifeguard2"/></td>
                    <td><input type="text" name="splitLifeguard2" required/></td>
                </tr>
            </table>
            <h3><bean:message key="schedule.vp"/></h3>        
            <table class="tableStuff">
                <tr>
                    <th></th>
                    <th><bean:message key="schedule.name"/></th>
                </tr>
                <tr>
                    <td><bean:message key="schedule.lifeguard1"/></td>
                    <td><input type="text" name="vpLifeguard1" required/></td>
                </tr>
                <tr>
                    <td><bean:message key="schedule.lifeguard2"/></td>
                    <td><input type="text" name="vpLifeguard2" required/></td>
                </tr>
                <tr>
                    <td><bean:message key="schedule.lifeguard3"/></td>
                    <td><input type="text" name="vpLifeguard3" required/></td>
                </tr>
            </table>
                    <br>
            <input type="submit" name="submit" value="<bean:message key="schedule.modify"/>"/>
        </html:form>
    </body>
</html>
