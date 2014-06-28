<%-- 
    Document   : layout
    Created on : 4-Jun-2014, 8:17:52 PM
    Author     : Andrew
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<html:html>
    <head><link rel="stylesheet" type="text/css" href="http://localhost:8080/LifeguardApplication/styles/styles.css"></head>
    <body>
        <table>
            <tr>
                <td></td>
                <td align="center"><tiles:insert attribute="header"/></td>
            </tr>
            <tr>
                <td width="10%" valign="top"><tiles:insert attribute="menu"/></td>
                <td width="90%" valign="top"  align="center"><tiles:insert attribute="body"/></td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><tiles:insert attribute="footer"/></td>
            </tr>
        </table>
    </body>
</html:html>