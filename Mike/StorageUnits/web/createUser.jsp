<%--
    Document : createUser
    Created on : Jun 3, 2014, 3:17:42 PM
    Author : Michael Fesser
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>

        <div style="color:red"><html:errors/></div>

        <html:form action="/addUser">
            <label class="alignCenter" for="userName"><bean:message key="create.user.label.user.name"/></label><html:text property="userName"/>
            <label class="alignCenter" for="password"><bean:message key="create.user.label.password"/></label><html:text property="password"/>
            <label class="alignCenter" for="password2"><bean:message key="create.user.label.password2"/></label><html:text property="password2"/>
            <label class="alignCenter" for="email"><bean:message key="create.user.label.email"/></label><html:text property="email"/>
            <label class="alignCenter" for="email2"><bean:message key="create.user.label.email2"/></label><html:text property="email2"/>
            <label class="alignCenter" for="firstName"><bean:message key="create.user.label.first.name"/></label><html:text property="firstName"/>
            <label class="alignCenter" for="middleInitial"><bean:message key="create.user.label.middle.initial"/></label><html:text property="middleInitial"/>
            <label class="alignCenter" for="lastName"><bean:message key="create.user.label.last.name"/></label><html:text property="lastName"/>
            <label class="alignCenter" for="street"><bean:message key="create.user.label.street"/></label><html:text property="street"/>
            <label class="alignCenter" for="city"><bean:message key="create.user.label.city"/></label><html:text property="city"/>
            <label class="alignCenter" for="province"><bean:message key="create.user.label.province"/></label><html:text property="province"/>
            <label class="alignCenter" for="postalCode"><bean:message key="create.user.label.postal.code"/></label><html:text property="postalCode"/>
            <label class="alignCenter" for="phoneNumber"><bean:message key="create.user.label.phone.number"/></label><html:text property="phoneNumber"/>
            <html:submit><bean:message key="create.user.label.submit"/></html:submit>
        </html:form>
    </body>
</html:html>

