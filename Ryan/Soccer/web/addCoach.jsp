<%-- 
    Document   : addCoach
    Created on : Jun 24, 2014, 10:34:06 AM
    Author     : Ryan

    This page presents a form that when filled out will create a user able to 
    book fields.
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="title.book"/></title>
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
        
    <html:form action="/CoachAction.do">
        
        <bean:message key="coach.name"/><html:text property="userName"/><br>
        <bean:message key="coach.password"/><html:password property="password"/><br>
        <html:submit><bean:message key="label.submit"/></html:submit>

    </html:form>
    </div>
    </body>
</html:html>
