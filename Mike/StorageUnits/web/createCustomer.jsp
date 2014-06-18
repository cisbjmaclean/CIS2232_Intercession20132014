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
    <body>

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>

        <div style="color:red"><html:errors/></div>

        <html:form action="/addCustomer">
            <table>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.user.name"/></label><html:text property="username"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.password"/></label><html:text property="password"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.password2"/></label><html:text property="password2"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.email"/></label><html:text property="email"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.email2"/></label><html:text property="email2"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.first.name"/></label><html:text property="firstName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.middle.initial"/></label><html:text property="middleInitial"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.last.name"/></label><html:text property="lastName"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.address"/></label><html:text property="address"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.city"/></label><html:text property="city"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.province"/></label><html:text property="province"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.postal.code"/></label><html:text property="postalCode"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.create.customer.phone.number"/></label><html:text property="phoneNumber"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <html:submit><bean:message key="label.create.customer.submit"/></html:submit>
                    </td>
                </tr>
            </table>
        </html:form>
    </body>
</html:html>

