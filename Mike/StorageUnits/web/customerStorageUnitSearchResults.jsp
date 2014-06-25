<%-- 
    Document   : customerStorageUnitSearchResults
    Created on : Jun 20, 2014, 6:59:53 PM
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
        <title><bean:message key="label.customer.storage.unit.search.results.title"/></title>  
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
        <h3><bean:message key="label.customer.storage.unit.search.results.message"/></h3>
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

        <!-- used for the calendar -->
        <div class="picker">
            <table id="customerSearchResults">
                <c:forEach var="unit" items="${customerSearchResults}">      
                    <tr>
                        <th>
                           <bean:message key="label.customer.storage.unit.search.results.id"/> 
                        </th>
                         <th>
                            <bean:message key="label.customer.storage.unit.search.results.type"/>
                        </th>
                         <th>
                            <bean:message key="label.customer.storage.unit.search.results.dimensions"/>
                        </th>
                         <th>
                            <bean:message key="label.customer.storage.unit.search.results.availability"/>
                        </th>
                         <th>
                            <bean:message key="label.customer.storage.unit.search.results.date.from"/>
                        </th>
                         <th>
                            <bean:message key="label.customer.storage.unit.search.results.date.to"/>
                        </th>
                        <c:if test="${unit.customerId == 0}"> 
                        <td>
                         <label><bean:message key="label.customer.view.all.months"/></label>
                         </td>
                          </c:if>  
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
                            ${unit.unitAvailability}
                        </td> 
                        <td>
                            ${unit.unitDateFrom}
                        </td> 
                        <td>
                            ${unit.unitDateTo}
                        </td>   
                        <c:if test="${unit.customerId == 0}"> 
                            <td>
                                <html:form action="/reserveStorageUnit">
                                    <html:hidden property="unitId" value="${unit.unitId}"/>
                                   <input type="text" name="dateTo" class="datepicker" value="Click Here" size="9">
                                    <html:submit property="Submit"><bean:message key="label.customer.view.all.reserve.storage.unit"/></html:submit>                                 
                                </html:form>
                            </td>
                        </c:if>                                         
                    </tr>              
                </c:forEach>
            </table>
        </div>
    </body>
</html:html>