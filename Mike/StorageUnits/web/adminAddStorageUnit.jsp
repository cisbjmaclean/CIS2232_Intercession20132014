<%-- 
    Document   : adminAddUnit
    Created on : Jun 16, 2014, 3:39:32 PM
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
        <title><bean:message key="admin.add.storage.unit.title"/></title>
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><bean:message key="admin.add.storage.unit.message"/></h3>
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

        <html:form action="/adminAddStorageUnit">
            <table class="mainTables">
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.storage.unit.unit.type"/></label>
                    </td>
                    <td>
                        <html:text property="unitType"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.storage.unit.unit.dimensions"/></label>
                    </td>
                    <td>
                        <html:text property="unitDimensions"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.storage.unit.unit.availability"/></label>
                    </td>
                    <td>
                        <html:text property="unitAvailability" value="1" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <html:reset/>
                    </td>
                    <td>
                        <html:submit><bean:message key="label.admin.add.storage.unit.submit"/></html:submit>
                    </td>
                </tr>
            </table>
        </html:form>
    </body>
</html:html>
