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
            <label><bean:message key="label.create.user.user.name"/></label><html:text property="username"/>
            <label><bean:message key="label.create.user.password"/></label><html:text property="password"/>
            <label><bean:message key="label.create.user.password2"/></label><html:text property="password2"/>
            <label><bean:message key="label.create.user.email"/></label><html:text property="email"/>
            <labe><bean:message key="label.create.user.email2"/></label><html:text property="email2"/>
            <label><bean:message key="label.create.user.first.name"/></label><html:text property="firstName"/>
            <label><bean:message key="label.create.user.middle.initial"/></label><html:text property="middleInitial"/>
            <label><bean:message key="label.create.user.last.name"/></label><html:text property="lastName"/>
            <label><bean:message key="label.create.user.address"/></label><html:text property="address"/>
            <label><bean:message key="label.create.user.city"/></label><html:text property="city"/>
            <label><bean:message key="label.create.user.province"/></label><html:text property="province"/>
            <label><bean:message key="label.create.user.postal.code"/></label><html:text property="postalCode"/>
            <label><bean:message key="label.create.user.phone.number"/></label><html:text property="phoneNumber"/>
            <html:submit><bean:message key="label.create.user.submit"/></html:submit>
        </html:form>
        </body>
    </html:html>

