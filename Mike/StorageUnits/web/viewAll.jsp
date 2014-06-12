<%-- 
    Document   : createUser
    Created on : Jun 3, 2014, 3:17:42 PM
    Author     : Michael Fesser
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
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>

        <div style="color:red"><html:errors/></div>

        <table>
            <c:forEach var="customer" items="${storageUnit}">               
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
                        ${customer.unitAvalibility}
                    </td> 
                    <td>
                        ${customer.unitDateFrom}
                    </td> 
                    <td>
                        ${customer.unitDateTo}
                    </td> 
                </tr>              
            </c:forEach>
        </table>
    </body>
</html:html>

