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

<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body>

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>

        <div style="color:red"><html:errors/></div>

        <html:form action="/adminAddStorageUnit">
            <table>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.storage.unit.unit.type"/></label><html:text property="unitType"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.storage.unit.unit.dimensions"/></label><html:text property="unitDimensions"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label><bean:message key="label.admin.add.storage.unit.unit.availability"/></label><html:text property="unitAvailability" value="1" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <html:submit><bean:message key="label.admin.add.storage.unit.submit"/></html:submit>
                    </td>
                </tr>
            </table>
        </html:form>
    </body>
</html:html>
