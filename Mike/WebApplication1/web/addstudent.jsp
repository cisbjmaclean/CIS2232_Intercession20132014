
<%-- 
    Document   : addstudent
    Created on : Nov 23, 2012, 8:26:08 AM
    Author     : sjampani
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
<s:form action="addStudent" method="POST">

<tr>
<td colspan="2">
Please enter Student Information:
</td>

</tr>

<s:actionerror />
<s:fielderror />

<s:textfield name="studentObj.studentname" label="Student Name"/>
<s:textfield name="studentObj.studentdept" label="Student Dept"/>
<s:submit value="Save" align="center"/>

</s:form>
    </body>
</html>
