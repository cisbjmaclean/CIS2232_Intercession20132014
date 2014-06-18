<%-- 
    Document   : adminAddCustomer
    Created on : Jun 18, 2014, 12:45:22 AM
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
        <html:form action="/adminAddCustomer">
            <table> 
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.user.name"/></label><html:text property="username" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.password"/></label><html:text property="password" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.password2"/></label><html:text property="password" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.email"/></label><html:text property="email" />
                    </td>
                </tr>    
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.email2"/></label><html:text property="email" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.first.name"/></label><html:text property="firstName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.middle.initial"/></label><html:text property="middleInitial" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.last.name"/></label><html:text property="lastName" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.address"/></label><html:text property="address" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.city"/></label><html:text property="city" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.province"/></label><html:text property="province" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.postal.code"/></label><html:text property="postalCode" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.customer.phone.number"/></label><html:text property="phoneNumber" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <html:submit><bean:message key="label.admin.add.customer.submit"/></html:submit>
                        </td>
                    </tr>
                </table>
        </html:form>
    </body>
</html:html>