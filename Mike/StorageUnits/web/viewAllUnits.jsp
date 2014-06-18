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
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui-1.10.4.css">
        <script src="/StorageUnits/scripts/jquery-1.11.1.min.js"></script>
        <script src="/StorageUnits/scripts/jquery-ui-1.10.4.min.js"></script>
        <link rel="stylesheet" href="/styles/styles.css">
        <script>
            $(function() {
                $(".datepicker").datepicker({
                    minDate: 0,
                    maxDate: "+36M"
                });
            });
        </script>
        <title><bean:message key="welcome.title"/></title>

    </head>
    <body>

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>

        <div style="color:red"><html:errors/></div>
        <!-- used for the calendar -->
        <div style="padding-bottom: 300px">
            <table>
                <c:forEach var="unit" items="${storageUnit}">               
                    <tr>
                        <td>
                            ${unit.unitId}
                        </td> 
                        <td>
                            ${unit.unitType}
                        </td> 
                        <td>
                            ${unit.unitDimensions}
                        </td> 
                        <td>
                            ${unit.unitAvalibility}
                        </td> 
                        <td>
                            ${unit.unitDateFrom}
                        </td> 
                        <td>
                            ${unit.unitDateTo}
                        </td>                      
                        <c:if test="${customer.validated == true}">
                            <c:if test="${unit.customerId == 0}">
                                <td>
                                    <html:form action="/reserveUnit">
                                        <html:hidden property="unitId" value="${unit.unitId}"/>
                                        <label><bean:message key="label.customer.view.all.months"/></label><input type="text" name="dateTo" class="datepicker" value="Click Here" size="9">
                                        <html:submit property="Submit"><bean:message key="label.customer.view.all.reserve.unit"/></html:submit>
                                    </html:form>
                                </td>
                            </c:if>
                        </c:if>
                    </tr>              
                </c:forEach>
            </table>
        </div>
    </body>
</html:html>

