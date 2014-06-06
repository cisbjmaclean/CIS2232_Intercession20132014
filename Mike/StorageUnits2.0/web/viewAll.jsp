<%-- 
    Document   : viewAll
    Created on : Jun 6, 2014, 12:27:39 AM
    Author     : Michael
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style ="display:inline">
            <table>
                <s:iterator name="storageUnits" id="StorageUnit" scope="session">
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
                    <html:submit><bean:message key="main.label.view"/></html:submit>              
                    </td>
                    </tr>
                </s:iterator>>
            </table>
            <div id =""></div>
    </body>
</html>
