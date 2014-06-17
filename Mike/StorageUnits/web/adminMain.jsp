<%-- 
    Document   : adminMain
    Created on : Jun 16, 2014, 3:41:04 PM
    Author     : Michael
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <script src="/StorageUnits/scripts/generalUse.js"></script>	
        <noscript>
        "You don't have Javascript turned on! In order for this page to function properly you must turn on Javascript."
        </noscript>
        <html:base/>
        
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

        <html:form action="/adminSearch">           
            <label><bean:message key="label.admin.main.unit.id"/></label><input type="text" id ="unitId" onblur="adminOptionUnitId();"/>
            <label><bean:message key="label.admin.main.customer.username"/></label><input type="text" id ="customerUsername"  onblur="adminOptionCustomerUsername();"/>
            <label><bean:message key="label.admin.customer.last.name"/></label><input type="text" id ="customerLastName"  onblur="adminOptionCustomerLastName();"/>
            <html:submit><bean:message key="label.admin.submit"/></html:submit>
            <html:submit onclick="setIdZero"><bean:message key="label.admin.list.all"/></html:submit>
        </html:form>
    </body>
</html:html>
