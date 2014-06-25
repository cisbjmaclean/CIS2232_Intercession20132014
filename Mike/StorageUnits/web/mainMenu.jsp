<%-- 
    Document   : mainMenu
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
    </head>
    <body>

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>


        <div id="paddingTop"> </div>    
        <table>
            <html:form action="/mainMenu">
                <c:if test="${customer.validated == null}">
                    <c:if test="${admin.adminCode == null}">
                        <tr>
                            <td>
                                <html:submit property="action"><bean:message key="label.main.menu.login"/></html:submit>
                                </td>    
                            </tr>         
                            <tr>
                                <td>
                                <html:submit property="action"><bean:message key="label.main.menu.create"/></html:submit>
                                </td>    
                            </tr>         
                            <tr>
                                <td>
                                <html:submit property="action"><bean:message key="label.main.menu.view.all.storage.units"/></html:submit>
                                </td>    
                            </tr>
                    </c:if>
                </c:if>
                <c:if test="${customer.validated == true}">
                    <tr>
                        <td>
                            <html:submit property="action"><bean:message key="label.customer.menu.view.my.storage.units"/></html:submit>                   
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.customer.menu.view.all.storage.units"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.customer.menu.view.search.units"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.customer.menu.profile"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.menu.logout"/></html:submit>
                            </td>
                        </tr>
                </c:if>
                <c:if test="${admin.adminCode == 378}">
                    <tr>
                        <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.search"/></html:submit>                   
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.view.all.customers"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.add.customer"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.view.all.storage.units"/></html:submit>
                            </td>
                        </tr>
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.admin.menu.add.storage.unit"/></html:submit>                   
                            </td>
                        </tr>                                          
                        <tr>
                            <td>
                            <html:submit property="action"><bean:message key="label.menu.logout"/></html:submit>
                            </td>
                        </tr>
                </c:if>
            </html:form>
        </table>
    </body>
</html:html>



