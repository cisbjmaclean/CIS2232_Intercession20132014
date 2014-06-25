<%-- 
    Document   : viewBookedTimes
    Created on : Jun 6, 2014, 1:30:09 PM
    Author     : Ryan
    Purpose: This page is used to display all the fields that are booked for the
    next 7 days.
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="title.view"/></title>
    <html:base/>
    </head>
    <body>
        <div class="main">
    <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
    </logic:notPresent>
        
        <h3><bean:message key="label.viewFields"/></h3>
        
         <table>
                    <tr class="tdHead">
                        <td><bean:message key="label.field"/></td>
                        <td><bean:message key="label.bookedBy"/></td>
                        <td><bean:message key="label.date"/></td>
                        <td><bean:message key="label.time"/></td>
                    </tr>    
                <logic:iterate name="fields" id="TheField" scope ="request">
                    <tr>
                        <td>
                            <bean:write name="TheField" property="fieldName" />
                        </td>
                        <td>
                            <bean:write name="TheField" property="userName" /> 
                        </td>
                        <td>
                            <bean:write name="TheField" property="fieldDate" /> 
                        </td>
                        <td>
                            <bean:write name="TheField" property="fieldTime" /> 
                        </td>
                    </tr>
                </logic:iterate>
            </table>
            <br>
        </div>
    </body>
</html:html>

