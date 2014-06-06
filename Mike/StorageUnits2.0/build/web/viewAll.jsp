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
                <s:iterator value="viewUnits">
                    <tr>
                        <td>
                            <s:property value="unitId"/>
                        </td>
                        <td>
                            <s:property value="unitType"/>
                        </td>
                        <td>
                            <s:property value="unitDimensions"/>
                        </td>
                        <td>
                            <s:property value="unitAvalibility"/>
                        </td>
                        <td>
                            <s:property value="unitDateFrom"/>                  
                        </td> 
                        <td>
                            <s:property value="unitDateTo"/>                  
                        </td>
                        <td>
                            test       
                        </td>
                    </tr>
                </s:iterator>
            </table>
            <div id =""></div>
    </body>
</html>
