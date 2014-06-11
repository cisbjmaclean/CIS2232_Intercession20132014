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
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix="c"%>
<%@ page language="java" import="java.util.*"%>


<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer</title>
    </head>
    <body>
        <table>
            <c:forEach var="customer" items="${storage}">           
                <c:if test="${requestScope.user.customerId == customer.customerId}">
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
                </c:if>       
            </c:forEach>
    </body>
</html:html>
