<%-- 
    Document   : adminStorageUnitSearchResults
    Created on : Jun 19, 2014, 9:49:55 PM
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
        <title><bean:message key="admin.storage.unit.search.results.title"/></title>     
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><bean:message key="admin.storage.unit.search.results.message"/></h3>
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
        <div style="padding-bottom: 300px">
            <table class="searchResults">
                <c:forEach var="unit" items="${unitList}">
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
                            ${unit.unitAvailability}
                        </td> 
                        <td>
                            ${unit.unitDateFrom}
                        </td> 
                        <td>
                            ${unit.unitDateTo}
                        </td>   
                        <c:if test="${unit.customerId == 1}">
                            <c:if test="${admin.adminCode == 378}">
                                <td>
                                    <html:form action="/releaseStorageUnit">
                                        <html:hidden property="unitId" value="${unit.unitId}"/>
                                        <html:submit property="Submit"><bean:message key="label.storage.unit.search.results.release.storage.unit"/></html:submit>
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