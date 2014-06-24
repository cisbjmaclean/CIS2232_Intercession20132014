<%-- 
    Document   : profile
    Created on : Jun 18, 2014, 3:38:47 PM
    Author     : Ryan
    purpose: 
    This page is used to view all the fields that are currently booked by the 
    user who clicks on this page.
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="title.profile"/></title>
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
        
    <h2><bean:message key="label.profile.message" /><bean:write name="loginForm" property="userName" /></h2>
    
            <table>
                    <tr class="tdHead">
                        <td><bean:message key="label.field"/></td>
                        <td><bean:message key="label.date"/></td>
                        <td><bean:message key="label.time"/></td>
                    </tr>    

                <logic:iterate name="userFields" id="TheUser" scope ="request">
                    <tr>
                        <td>
                            <bean:write name="TheUser" property="fieldName" />
                        </td>
                        <td>
                            <bean:write name="TheUser" property="fieldDate" /> 
                        </td>
                        <td>
                            <bean:write name="TheUser" property="fieldTime" /> 
                        </td>
                    </tr>
                </logic:iterate>
            </table>
            <br>
    </div>
    </body>
</html:html>
