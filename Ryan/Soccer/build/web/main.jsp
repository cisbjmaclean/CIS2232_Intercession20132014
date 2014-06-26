<%-- 
    Document   : main
    Created on : Jun 6, 2014, 1:30:09 PM
    Author     : Ryan
    Purpose : This is displayed if the login went successful. It is also where 
    the user is sent if they book a field.
    This is also the destination for many of the validation that is to be done 
    on other pages.
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="title.main"/></title>
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
        
        <h3><bean:message key="main.hello"/></h3>

    <logic:messagesPresent message="true">
        <div class="main">
        <html:messages id="msg2" message="true" property="success"><div><img src="css/correct.png" class="imageHolder"/><bean:write name="msg2"/></div><br/></html:messages>
        <html:messages id="msg2" message="true" property="fail"><div><img src="css/wrong.png" class="imageHolder"/><bean:write name="msg2"/></div><br/></html:messages>
        <html:messages id="msg2" message="true" property="successCoach"><div><img src="css/correct.png" class="imageHolder"/><bean:write name="msg2"/></div><br/></html:messages>
        <html:messages id="msg2" message="true" property="failCoach"><div><img src="css/wrong.png" class="imageHolder"/><bean:write name="msg2"/></div><br/></html:messages>
        </div>
    </logic:messagesPresent>
        </div>
</html:html>
