<%-- 
    Document   : main
    Created on : May 26, 2014
    Author     : bjmaclean
--%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<html>
<html:form action="/mainMenu">

<table>
<tr style="text-align: center;">
    <td>
    Menu
  </td>
</tr>
<tr>
  <td width="120" valign="top">
    <font size="-1"> <input type="submit" name="action" value="<bean:message key='label.main.options'/>" /></font>
  </td>
</tr>

</table>
</html:form>
</html>