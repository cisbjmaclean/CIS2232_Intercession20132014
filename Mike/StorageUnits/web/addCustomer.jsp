<%--
    Document : addCustomer
    Created on : Jun 3, 2014, 3:17:42 PM
    Author : Michael Fesser
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
        <title><bean:message key="label.create.customer.title"/></title>     
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><bean:message key="label.create.customer.message"/></h3>
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

        <div>
            <html:form action="/addCustomer">
                <table class="mainTables">
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.user.name"/></label>
                        </td>           
                        <td>
                            <html:text property="username"/>
                        </td>        
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.password"/></label>
                        </td>
                        <td>
                            <html:password property="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.password2"/></label>
                        </td>
                        <td>
                            <html:password property="password2"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.email"/></label>
                        </td>
                        <td>
                            <html:text property="email"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.email2"/></label>
                        </td>
                        <td>
                            <html:text property="email2"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.first.name"/></label>
                        </td>
                        <td>
                            <html:text property="firstName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.middle.initial"/></label>
                        </td>
                        <td>
                            <html:text property="middleInitial"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.last.name"/></label>
                        </td>
                        <td>
                            <html:text property="lastName"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.address"/></label>
                        </td>
                        <td>
                            <html:text property="address"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.city"/></label>
                        </td>
                        <td>
                            <html:text property="city"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.province"/></label>
                        </td>
                        <td>
                            <html:text property="province"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.postal.code"/></label>
                        </td>
                        <td>
                            <html:text property="postalCode"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <label><bean:message key="label.create.customer.phone.number"/></label>
                        </td>
                        <td>
                            <html:text property="phoneNumber"/>
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
                            <html:submit><bean:message key="label.create.customer.submit"/></html:submit>
                            </td>
                        </tr>
                    </table>            
            </html:form>
        </div>
    </body>
</html:html>

