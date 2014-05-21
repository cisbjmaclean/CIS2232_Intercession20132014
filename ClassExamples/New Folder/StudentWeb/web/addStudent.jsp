<%-- 
    Document   : addStudent
    Created on : May 21, 2014, 10:55:37 AM
    Author     : areid31891
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: yellowgreen">
        <html:form action="/Menu">
            <center>
                
                <label class="alignCenter" for="studentId"><bean:message key="label.student.id"/></label><html:text property="studentId" /><br>
                <label class="alignCenter" for="firstName"><bean:message key="label.first.name"/></label><html:text property="firstName" /><br>
                        <label class="alignCenter" for="lastName"><bean:message key="label.last.name"/></label><html:text property="lastName" /><br>
                            <label class="alignCenter" for="dateofBirth"><bean:message key="label.dateOfBirth"/></label><html:text property="dateOfBirth" /><br>
                

                <html:submit><bean:message key="label.submit"/></html:submit>
            </center>
        </html:form>
    </body>
</html:html>