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
        <link rel="stylesheet" href="/StorageUnits/styles/styles.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.min.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.theme.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.structure.css">
        <script src="/StorageUnits/scripts/jquery.js"></script>
        <script src="/StorageUnits/scripts/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="/StorageUnits/styles/storageUnitTheme.css">
        <script>
            $(function() {
                $(".datepicker").datepicker({
                    minDate: +1,
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
        <div class="picker">
            <table>
                <c:forEach var="unit" items="${storageUnits}">               
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
                            ${unit.unitAvailability}
                        </td> 
                        <td>
                            ${unit.unitDateFrom}
                        </td> 
                        <td>
                            ${unit.unitDateTo}
                        </td>   
                        <c:if test="${customer.validated != null}"> 
                            <c:if test="${unit.customerId == 0}"> 
                                <c:if test="${admin.adminCode != 378}">
                                    <td>
                                        <html:form action="/reserveStorageUnit">
                                            <html:hidden property="unitId" value="${unit.unitId}"/>
                                            <label><bean:message key="label.customer.view.all.months"/></label><input type="text" name="dateTo" class="datepicker" value="Click Here" size="9">
                                            <html:submit property="Submit"><bean:message key="label.customer.view.all.reserve.storage.unit"/></html:submit>                                 
                                        </html:form>
                                    </td>
                                </c:if>
                            </c:if>
                        </c:if> 
                        <c:if test="${unit.customerId == 1}">
                            <c:if test="${admin.adminCode == 378}">
                                <td>
                                    <html:form action="/releaseStorageUnit">
                                        <html:hidden property="unitId" value="${unit.unitId}"/>
                                        <html:submit property="Submit"><bean:message key="label.customer.storage.unit.view.release.storage.unit"/></html:submit>
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
