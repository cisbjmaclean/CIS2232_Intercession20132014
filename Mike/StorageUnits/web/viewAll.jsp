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

<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>
    <body style="background-color: white">

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>

        <div style="color:red"><html:errors/></div>

        <table>
            <logic:iterate name="storageUnits" id="StorageUnit" scope="session">
                <tr>
                    <td>
                        <bean:write name="StorageUnit" property="unitId"/>
                    </td>
                    <td>
                        <bean:write name="StorageUnit" property="unitType"/>
                    </td>
                    <td>
                        <bean:write name="StorageUnit" property="unitDimensions"/>
                    </td>
                    <td>
                        <bean:write name="StorageUnit" property="unitAvalibility"/>
                    </td>
                    <td>
                        <bean:write name="StorageUnit" property="unitDateFrom"/>                  
                    </td> 
                    <td>
                        <bean:write name="StorageUnit" property="unitDateTo"/>                  
                    </td>
                    <td>
                        <html:form action="reserveUnit" method="post">
                            <html:hidden property="unitId"/>
                            <html:submit><bean:message key="create.user.label.submit"/></html:submit>
                        </html:form>             
                    </td>
                </tr>


            </logic:iterate>
        </table>

    </body>
</html:html>

