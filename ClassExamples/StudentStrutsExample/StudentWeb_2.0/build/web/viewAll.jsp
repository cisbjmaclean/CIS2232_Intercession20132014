<%-- 
    Document   : addStudent
    Created on : May 21, 2014, 10:55:37 AM
    Author     : areid31891
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/>xx</title>
        <html:base/>
    </head>
    <body style="background-color: yellow">
        <html:form action="/Main">
        <center>

            <table>
                <logic:iterate name="AllStudents2" id="TheStudent" scope ="session">
                    <tr>
                        <td>
                            <a href="Menu.do?option=edit&studentId=<bean:write name="TheStudent" property="studentId"/>"><bean:write name="TheStudent" property="studentId"/></a> 
                        </td>
                        <td>
                            <bean:write name="TheStudent" property="firstName"/> 
                        </td>
                        <td>
                            <bean:write name="TheStudent" property="lastName"/> 
                        </td>
                        <td>
                            <bean:write name="TheStudent" property="dob"/> 
                        </td>
                    </tr>


                </logic:iterate>
            </table>




            <html:submit><bean:message key="label.return"/></html:submit>
            </center>
    </html:form>
</body>
</html:html>