<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<!DOCTYPE html>
<html>
    <head>
        <!--Author: Ian Mori
                Date: Dec 6, 2013
                Purpose: Designing a website with bootstrap, content page 3.
                Last Revision: Dec 17, 2013
                Dependencies: This file requires several JPG images, 4 separate html files for page links, several url links, a CSS style sheet, a JS style sheet, Bootstrap file, and a JQuery file.
        -->
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