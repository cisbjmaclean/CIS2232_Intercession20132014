<%-- 
    Document   : loginLayout
    Created on : 4-Jun-2014, 9:08:57 PM
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
                <td><tiles:insert attribute="header"/></td>
            </tr>
            <tr>
                <td><tiles:insert attribute="body"/></td>
            </tr>
            <tr>
                <td><tiles:insert attribute="footer"/></td>
            </tr>
        </table>
    </body>
</html:html>
