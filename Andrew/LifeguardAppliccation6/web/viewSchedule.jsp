<%-- 
    Document   : viewLifeguards
    Created on : 4-Jun-2014, 9:11:04 PM
    Author     : Andrew
    Purpose    : This page displays the schedule for a given day.
--%>

<%@page import="util.Variables"%>
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
        <title><bean:message key="schedule.title"/></title>
    </head>
    <body>
        <h3><bean:message key="schedule.header.message"/><%out.println(Variables.getScheduleDate());%></h3>
        <h4><bean:message key="schedule.simmons"/></h4>
        
        <table class="largerTableStuff" border="1">
            <tr>
                <th><bean:message key="schedule.lifeguard1"/></th>
                <th><bean:message key="schedule.lifeguard2"/></th>
                <th><bean:message key="schedule.lifeguard3"/></th>
            </tr>
            <%
                PreparedStatement ps = null;
                String sql = null;
                Connection conn = null;
                boolean valid = false;

                try {
                    conn = ConnectionUtils.getConnection();

                    sql = "SELECT lifeguard_1, lifeguard_2, lifeguard_3 FROM simmons WHERE shift_date = '"+Variables.getScheduleDate()+"'";

                    ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {  %>
                        <tr>
                            <td><%out.println(rs.getString("lifeguard_1"));%></td>
                            <td><%out.println(rs.getString("lifeguard_2"));%></td>
                            <td><%out.println(rs.getString("lifeguard_3"));%></td>
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
            
            <h4><bean:message key="schedule.split"/></h4>
        
        <table class="largerTableStuff" border="1">
            <tr>
                <th><bean:message key="schedule.lifeguard1"/></th>
                <th><bean:message key="schedule.lifeguard2"/></th>
            </tr>
            <%
                try {
                    conn = ConnectionUtils.getConnection();
                    sql = "SELECT lifeguard_1, lifeguard_2 FROM split WHERE shift_date = '"+Variables.getScheduleDate()+"'";

                    ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {  %>
                        <tr>
                            <td><%out.println(rs.getString("lifeguard_1"));%></td>
                            <td><%out.println(rs.getString("lifeguard_2"));%></td>
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
            
        <h4><bean:message key="schedule.vp"/></h4>
            
        <table class="largerTableStuff" border="1">
            <tr>
                <th><bean:message key="schedule.lifeguard1"/></th>
                <th><bean:message key="schedule.lifeguard2"/></th>
                <th><bean:message key="schedule.lifeguard3"/></th>
            </tr>
            <%
                try {
                    conn = ConnectionUtils.getConnection();
                    sql = "SELECT lifeguard_1, lifeguard_2, lifeguard_3 FROM victoria_park WHERE shift_date = '"+Variables.getScheduleDate()+"'";
                    System.out.println(sql);

                    ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {  %>
                        <tr>
                            <td><%out.println(rs.getString("lifeguard_1"));%></td>
                            <td><%out.println(rs.getString("lifeguard_2"));%></td>
                            <td><%out.println(rs.getString("lifeguard_3"));%></td>
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
