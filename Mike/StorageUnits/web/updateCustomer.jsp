<%-- 
    Document   : updateCustomer
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
        <title><bean:message key="label.update.customer.title"/></title>     
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><bean:message key="label.update.customer.message"/></h3>
        <table>
            <tr>
                <td>
                    <logic:messagesPresent message="true">
                        <html:messages id="msg2" message="true" property="success"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
                    </logic:messagesPresent>
                    <%-- the html:errors is populated if the validator is used. --%>    
                    <div style="color:red">
                        <html:errors />
                    </div>
                </td>
            </tr>
        </table>
                    
        <html:form action="/updateCustomer">
            <table class="mainTables"> 
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.id"/></label>
                    </td>
                    <td><html:text property="customerId" readonly="true" value="${customer.customerId}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <c:if test="${admin.adminCode != 378}" var="disabled" />
                        <label><bean:message key="label.update.customer.user.name"/></label>
                    </td>
                    <td>
                        <html:text property="username"  readonly="${disabled}" value="${customer.username}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.password"/></label>
                    </td>
                    <td>
                        <html:password property="password" value="${customer.password}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.password2"/></label>
                    </td>
                    <td>
                        <html:password property="password2" value="${customer.password}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.email"/></label>
                    </td>
                    <td>
                        <html:text property="email2" value="${customerDetails.email}"/>
                    </td>
                </tr>    
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.email2"/></label>
                    </td>
                    <td>
                        <html:text property="email" value="${customerDetails.email}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.first.name"/></label>
                    </td>
                    <td>
                        <html:text property="firstName" value="${customerDetails.firstName}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.middle.initial"/></label>
                    </td>
                    <td>
                        <html:text property="middleInitial" value="${customerDetails.middleInitial}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.last.name"/></label>
                    </td>
                    <td>
                        <html:text property="lastName" value="${customerDetails.lastName}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.address"/></label>
                    </td>
                    <td>
                        <html:text property="address" value="${customerDetails.address}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.city"/></label>
                    </td>
                    <td>
                        <html:text property="city" value="${customerDetails.city}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.province"/></label>
                    </td>
                    <td>
                        <html:text property="province" value="${customerDetails.province}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.postal.code"/></label>
                    </td>
                    <td>
                        <html:text property="postalCode" value="${customerDetails.postalCode}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.update.customer.phone.number"/></label>
                    </td>
                    <td>
                        <html:text property="phoneNumber" value="${customerDetails.phoneNumber}"/>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <html:reset/>
                    </td>
                </tr>
                <tr>
                    <td>
                    </td>
                    <td>
                        <html:submit><bean:message key="label.update.customer.submit"/></html:submit>
                        </td>
                    </tr>
                </table>
        </html:form>
    </body>
</html:html>
