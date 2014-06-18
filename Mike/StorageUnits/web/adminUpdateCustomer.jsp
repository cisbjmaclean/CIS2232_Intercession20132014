<%-- 
    Document   : adminEditUser
    Created on : Jun 17, 2014, 5:38:17 PM
    Author     : Michael
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*"%>

<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        <table><tr><td >Welcome to the application...</td></tr>
            <tr ><td>
                    <logic:messagesPresent message="true">
                        <html:messages id="msg2" message="true" property="success"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="released"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="reserved"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
                    </logic:messagesPresent>
                    <%-- the html:errors is populated if the validator is used. --%>    
                    <div style="color:red">
                        <html:errors />
                    </div>
                </td></tr>

        </table>
        <html:form action="/adminUpdateCustomer">
            <table> 
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.id"/></label><html:text property="customerId" value="${customerLogin.customerId}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.user.name"/></label><html:text property="username" value="${customerLogin.username}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.password"/></label><html:text property="password" value="${customerLogin.password}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.password2"/></label><html:text property="password" value="${customerLogin.password}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.email"/></label><html:text property="email" value="${customerInfo.email}"/>
                    </td>
                </tr>    
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.email2"/></label><html:text property="email" value="${customerInfo.email}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.first.name"/></label><html:text property="firstName" value="${customerInfo.firstName}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.middle.initial"/></label><html:text property="middleInitial" value="${customerInfo.middleInitial}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.last.name"/></label><html:text property="lastName" value="${customerInfo.lastName}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.address"/></label><html:text property="address" value="${customerInfo.address}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.city"/></label><html:text property="city" value="${customerInfo.city}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.province"/></label><html:text property="province" value="${customerInfo.province}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.postal.code"/></label><html:text property="postalCode" value="${customerInfo.postalCode}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.update.customer.phone.number"/></label><html:text property="phoneNumber" value="${customerInfo.phoneNumber}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <html:submit><bean:message key="label.admin.update.customer.submit"/></html:submit>
                        </td>
                    </tr>
                </table>
        </html:form>
    </body>
</html:html>
