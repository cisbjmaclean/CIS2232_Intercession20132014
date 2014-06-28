<%-- 
    Document   : viewLifeguards
    Created on : 4-Jun-2014, 9:11:04 PM
    Author     : Andrew
    Purpose    : This page displays a list of lifeguards that are currently in the system.
--%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@page import="util.DbUtils"%>
<%@page import="util.Util"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="util.ConnectionUtils"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="menu.message.viewLifeguards"/></title>
    </head>
    <body>
        <h3><bean:message key="menu.message.viewLifeguards"/></h3>
        
        <table class="largerTableStuff" border="1">
            <tr>
                <th><bean:message key="lifeguard.firstName"/></th>
                <th><bean:message key="lifeguard.lastName"/></th>
                <th><bean:message key="lifeguard.phoneNumber"/></th>
                <th><bean:message key="lifeguard.NLS"/></th>
                <th><bean:message key="lifeguard.CPR"/></th>
            </tr>
            <%
                PreparedStatement ps = null;
                String sql = null;
                Connection conn = null;
                boolean valid = false;

                try {
                    conn = ConnectionUtils.getConnection();

                    sql = "SELECT * FROM lifeguard";

                    ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {  %>
                        <tr>
                            <td><%out.println(rs.getString(2));%></td>
                            <td><%out.println(rs.getString(3));%></td>
                            <td><%out.println(rs.getString(4));%></td>
                            <td><%out.println(rs.getString(5));%></td>
                            <td><%out.println(rs.getString(6));%></td>
                        </tr>
                    <% }
                } catch (Exception e) {
                    String errorMessage = e.getMessage();
                    e.printStackTrace();
                } finally {
                    DbUtils.close(ps, conn);
                }
            %>
            
        </table>
    </body>
</html>
