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
    <html:form action="/Menu">
        <body>
            <table>
                <tr>
                    <td>
                        Menu
                    </td>
                </tr>
                <tr>
                    <td>
                        <font size="-1"> <input type="submit" name="action" value="<bean:message key='label.cis2232.2014.intercession'/>" /></font>
                    </td>
                </tr>
                <tr>
                    <td>
                        <font size="-1"> <input type="submit" name="action" value="<bean:message key='label.about'/>" /></font>
                    </td>
                </tr>

            </table>
        </body>

    </html:form>
</html>