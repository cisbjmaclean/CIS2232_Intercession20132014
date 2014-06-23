<%-- 
    Document   : main
    Created on : Jun 6, 2014, 1:30:09 PM
    Author     : Ryan
    Purpose : This page displays all the links that are used by this site.
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
    <div class="menu">
    <div class="linkHeaderHolder">
        <a href="Main.do" class="menu"><div class="linkHeader"><bean:message key="main.home"/></div></a>
        <a href="ViewBookedFields.do" class="menu"><div class="linkHeader"><bean:message key="main.view"/></div></a>
        <a href="BookField.do" class="menu"><div class="linkHeader"><bean:message key="main.book"/></div></a>
        <a href="ViewProfile.do" class="menu"><div class="linkHeader"><bean:message key="main.profile"/></div></a>
    </div>
    </div>

