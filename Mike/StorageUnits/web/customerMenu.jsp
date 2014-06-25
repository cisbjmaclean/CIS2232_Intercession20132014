<%-- 
    Document   : menu
    Created on : Jun 10, 2014, 3:49:56 PM
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
        <title><bean:message key="admin.main.title"/></title>     
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
       
<html:html lang="true">
    <!DOCTYPE html>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Menu Page</title>
        </head>
        <body>
            <html:form action="/customerMenu">
                <table>
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
                            <html:submit property="action"><bean:message key="label.customer.menu.logout"/></html:submit>
                            </td>
                        </tr>
                    </table>
            </html:form>
        </body>
    </html>
</html:html>