<%-- 
    Document   : customerStorageUnitView
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
        <title><bean:message key="label.customer.storage.unit.view.title"/></title>  
        <script>
            $(function() {
                $(".datepicker").datepicker({
                    minDate: +1,
                    maxDate: "+36M"
                });
            });
        </script>
        <noscript>
        "You don't have Javascript turned on! In order for this page to function properly you must turn on Javascript."
        </noscript>
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><bean:message key="label.customer.storage.unit.view.message"/></h3>
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
        <div class="picker">
            <c:forEach var="unit" items="${storageUnits}">  
                <c:if test="${customer.customerId == unit.customerId}">
                    <table>
                        <tr>
                            <th>
                                <bean:message key="label.admin.storage.unit.search.results.id"/>
                            </th>
                            <th>
                                <bean:message key="label.admin.storage.unit.search.results.type"/>
                            </th>
                            <th>
                                <bean:message key="label.admin.storage.unit.search.results.dimensions"/>
                            </th>
                            <th>
                                <bean:message key="label.admin.storage.unit.search.results.availability"/>
                            </th>
                            <th>
                                <bean:message key="label.admin.storage.unit.search.results.date.to"/>
                            </th>
                            <th>
                                <bean:message key="label.admin.storage.unit.search.results.date.from"/>
                            </th>
                        </tr>      
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
                                ${unit.unitDateFrom}
                            </td> 
                            <td>
                                ${unit.unitDateTo}
                            </td> 
                            <td>
                                <c:choose> 
                                    <c:when test="${unit.unitInUse == 0}">
                                        <bean:message key="label.customer.storage.unit.view.storage.unit.in.use.no"/>
                                    </c:when> 
                                    <c:when test="${unit.unitInUse == 1}">
                                        <bean:message key="label.customer.storage.unit.view.storage.unit.in.use.yes"/>
                                    </c:when>  
                                </c:choose>
                            </td>                           
                        </tr>
                    </table>
                    <table id="customerStorageUnitView">
                        <tr>                           
                                <html:form action="/extendStorageUnit">
                                <td>
                                    <html:hidden property="unitId" value="${unit.unitId}"/>
                                    <label><bean:message key="label.customer.view.all.months"/></label>
                                </td>
                                <td>
                                    <input type="text" name="dateTo" class="datepicker" value="Click Here">
                                    <html:submit property="Submit"><bean:message key="label.customer.storage.unit.view.extend.storage.unit"/></html:submit>
                                </td>
                                </html:form>                                
                            <td>
                                <html:form action="/releaseStorageUnit">
                                    <html:hidden property="unitId" value="${unit.unitId}"/> 
                                    <html:submit property="Submit"><bean:message key="label.customer.storage.unit.view.release.storage.unit"/></html:submit>
                                </html:form>    
                            </td> 
                            <td>
                                <html:form action="/storageUnitInUseToggle">
                                    <html:hidden property="unitId" value="${unit.unitId}"/>
                                    <html:hidden property="storageUnitToggle" value="${unit.unitInUse}"/>  
                                    <html:submit property="Submit"><bean:message key="label.customer.storage.unit.view.storage.unit.toggle.in.use"/></html:submit>
                                </html:form>    
                            </td> 
                        </tr>
                    </table>
                </c:if>       
            </c:forEach>
        </div>
    </body>
</html:html>
