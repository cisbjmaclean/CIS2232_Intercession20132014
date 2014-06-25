<%-- 
    Document   : adminMain
    Created on : Jun 16, 2014, 3:41:04 PM
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
        <title><bean:message key="admin.main.title"/></title>     
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><bean:message key="label.admin.main.heading"/></h3>
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

        <h3>Customer search</h3>
        <table>

            <html:form action="/adminCustomerSearch"> 
                <tr>
                    <td>
                        <label><bean:message key="label.admin.main.customer.email"/></label>
                    </td>
                    <td>
                        <input type="text" name="customerEmail" id ="customerEmail" onblur="adminOptionCustomerEmail();"/>
                    </td>
                    <td>
                        <label><bean:message key="label.admin.main.customer.username"/></label>
                    </td>
                    <td>
                        <input type="text" name="customerUsername" id ="customerUsername"  onblur="adminOptionCustomerUsername();"/>
                    </td>
                    <td>
                        <label><bean:message key="label.admin.main.customer.last.name"/></label>
                    </td>
                    <td>
                        <input type="text" name="customerLastName" id ="customerLastName"  onblur="adminOptionCustomerLastName();"/>
                    </td>
                    <td>
                        <html:submit><bean:message key="label.admin.submit"/></html:submit>
                        </td>
                    </tr>
            </html:form>

        </table>

        <table>
            <tr>
            <h3>Storage Unit Search</h3>
            <html:form action="/adminStorageUnitSearch"> 
                <tr>
                    <td>
                        <label><bean:message key="label.admin.main.storage.unit.id"/></label>
                    </td>
                    <td>
                        <input type="text" name="unitId" id ="unitId" onblur="adminOptionUnitId();"/>
                    </td>
                    <td>
                        <label><bean:message key="label.admin.main.storage.unit.customer.id"/></label>
                    </td>
                    <td>
                        <input type="text" name="unitCustomerId" id ="unitCustomerId" onblur="adminOptionUnitCustomerId();" /> 
                    </td>
                    <td>
                        <label><bean:message key="label.admin.main.storage.unit.customer.last.name"/></label> 
                    </td>
                    <td><input type="text" name="unitCustomerLastName" id ="unitCustomerLastName" onblur="adminOptionUnitCustomerLastName();"/> 
                    </td>
                    <td>
                        <html:submit><bean:message key="label.admin.submit"/></html:submit> 
                        </td>
                    </tr>
            </html:form>
        </tr>
        <table>
            </body>
        </html:html>
