<%-- 
    Document   : adminCustomerSearchResults
    Created on : Jun 17, 2014, 3:15:22 PM
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
        <title><bean:message key="admin.customer.search.results.title"/></title>
        <html:base/>
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><bean:message key="label.admin.customer.search.message"/></h3>
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
        <table class="searchResults"> 
            <c:forEach var="customer" items="${customerList}">   
                <tr>
                    <th>
                        <bean:message key="label.admin.customer.search.heading.id"/>
                    </th>
                    <th>
                        <bean:message key="label.admin.customer.search.heading.last.name"/>
                    </th>
                    <th>
                        <bean:message key="label.admin.customer.search.heading.first.name"/>
                    </th>
                    <th>
                        <bean:message key="label.admin.customer.search.heading.email"/>
                    </th>
                </tr>
                <tr>                    
                    <td>
                        ${customer.customerId}
                    </td> 
                    <td>
                        ${customer.lastName}
                    </td> 
                    <td>
                        ${customer.firstName}
                    </td> 
                    <td>
                        ${customer.email}
                    </td>
                    <html:form action="/adminModifyCustomer">
                        <td>
                            <html:hidden property="customerId" value="${customer.customerId}"/>
                            <html:submit property="action"><bean:message key="label.admin.customer.search.update"/></html:submit>
                            </td>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.customer.search.delete"/></html:submit>
                            </td> 
                    </html:form>                                                             
                </tr>               
            </c:forEach>
        </table>
    </body>
</html:html>
