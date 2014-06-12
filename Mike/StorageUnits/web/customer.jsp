<%-- 
    Document   : user
    Created on : Jun 10, 2014, 5:18:47 PM
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
                        <html:messages id="msg2" message="true" property="message"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>				  		
                        <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
                    </logic:messagesPresent>
                    <%-- the html:errors is populated if the validator is used. --%>    
                    <div style="color:red">
                        <html:errors />
                    </div>
                </td></tr>

        </table>
        <table> 
            <c:forEach var="customer" items="${storageUnit}">  
                <c:if test="${sessionScope.user.customerId == customer.customerId}">
                    <tr>
                        <td>
                            ${customer.unitId}
                        </td> 
                        <td>
                            ${customer.unitType}
                        </td> 
                        <td>
                            ${customer.unitDimensions}
                        </td> 
                        <td>
                            ${customer.unitDateFrom}
                        </td> 
                        <td>
                            ${customer.unitDateTo}
                        </td> 
                        <td>
                            <html:form action="/extendRelease">
                                <html:submit property="action"><bean:message key="label.user.extendUnit"/></html:submit>
                                <html:submit property="action"><bean:message key="label.user.releaseUnit"/></html:submit>
                            </html:form>
                        </td>
                    </tr>
                </c:if>       
            </c:forEach>
    </body>
</html:html>
