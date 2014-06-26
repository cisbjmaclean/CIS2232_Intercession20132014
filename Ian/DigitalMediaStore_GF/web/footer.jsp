<%-- 
    Document   : footer.jsp
    Created on : June 9,2014
    Author     : Ian Mori
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Home Page</title>
        <meta http-equiv="Content-Type" content="text/html/css; charset=UTF-8">
        <meta charset="utf-8">
        <!--Resizes screen and links style sheets.-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Ian Mori">
    </head>
    <body>
        <!--Bottom fixed navbar that displays the time and a link to youtube.-->
        <div class ="navbar navbar-default navbar-fixed-bottom">
            <div class = "container">
                <div id="displayTime" class="navbar-text pull-left"></div>
                <a href = "http://www.youtube.com/" class = "navbar-btn btn-danger btn pull-right">Subscribe on YouTube!</a>
            </div>
        </div>
        <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>