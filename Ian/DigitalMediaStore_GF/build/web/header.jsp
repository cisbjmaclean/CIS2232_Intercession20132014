<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%--
This provides the standard header for each page in the application.
--%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html/css; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>

        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Ian Mori">
        <meta name="author" content="Ian Mori">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" type="text/css" href="css/morestyles.css">
        <html:base/>
    </head>

    <body>
        <!--This sets the top navbar and items within.-->
        <div class = "navbar navbar-inverse navbar-static-top">
            <div class = "container">		
                <div class="navbar-brand">
                    <html:link action="/Welcome" >Home</html:link>&emsp;&emsp;
                    <logic:present name="user">
                        <html:link action="/Main" >Account Home</html:link>
                    </logic:present>
                </div>
                <!--<a href="index.html"  class = "navbar-brand">Home</a>-->
                <!--When resized to smaller screen shows bars, like mobile websites.-->
                <button class ="navbar-toggle" data-toggle ="collapse" data-target =".navHeaderCollapse">
                    <span class = "icon-bar"></span>
                    <span class = "icon-bar"></span>
                    <span class = "icon-bar"></span>
                </button>
                <div class = "collapse navbar-collapse navHeaderCollapse">
                    <!--Sets the different items within the navbar.-->
                    <ul class = "nav navbar-nav navbar-right">				
                        <!--Another dropdown with active links.-->
                        <li class = "dropdown">
                            <a href = "#" class ="dropdown-toggle" data-toggle="dropdown">My Account <b class = "caret"></b></a>
                            <ul class ="dropdown-menu">
                                <logic:notPresent scope="session" name="user">
                                    <li><html:link forward="createNewAccount">Create An Account</html:link></li>
                                    <li><html:link forward="login">Login</html:link></li>  
                                    </logic:notPresent>

                                <logic:present name="user">
                                    <li><html:link action="/ViewAccountDetails">View Account Details</html:link></li>
                                    <li><html:link action="/Logout">Logout</html:link></li>  
                                    </logic:present>
                            </ul>
                        </li>

                        <logic:present name="user">
                            <!--Creates a dropdown from the navbar.-->
                            <li class = "dropdown">
                                <a href = "#" class = "dropdown-toggle" data-toggle = "dropdown">Orders <b class = "caret"></b></a>
                                <ul class = "dropdown-menu">

                                    <li><html:link forward="createNewOrder">Create New Order</html:link></li>  
                                    <li><html:link action="/ViewOrders">View Orders</html:link></li>  

                                    </ul>
                                </li>
                        </logic:present>
                        <!--Use logic present to show certain fields-->
                        <li class = "dropdown">
                            <a href = "#" class ="dropdown-toggle" data-toggle="dropdown">Support <b class = "caret"></b></a>
                            <ul class ="dropdown-menu">
                                <logic:present name="user">
                                    <li><html:link forward="bookSupportSession">Book Support Session</html:link></li>
                                    <li><html:link action="/ViewSupportSessions">View Support Sessions</html:link></li>
                                    </logic:present>
                                <li><a href = "https://support.mozilla.org/en-US/kb/how-to-write-knowledge-base-articles" data-toggle="modal">Support Articles</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>

        <!--Another pop-up modal that gathers input, will eventually take the username and password and allow a user to sign in.-->
        <div class ="modal fade" id="account" role="dialog">
            <div class = "modal-dialog">
                <div class = "modal-content">
                    <form class="form-horizontal">
                        <div class = "modal-header">
                            <h4>Welcome back!</h4>
                        </div>
                        <!--Setting the modal body and items within.-->
                        <div class="modal-body">
                            <!--Setting each item of the modal body, will add validation later when a connected to a database.-->
                            <div class="form-group">
                                <label for="username" class="col-lg-2 control-label">Username:</label>
                                <div class = "col-lg-10"> 
                                    <input type="text" class="form-control" id="username" placeholder="username">
                                </div>
                            </div>
                            <!--Setting next item of the modal body, will add validation later when a connected to a database.-->
                            <div class="form-group">
                                <label for="inputPassword" class="col-lg-2 control-label">Password:</label>
                                <div class = "col-lg-10"> 
                                    <input type="password" class="form-control" id="inputPassword" placeholder="password">
                                </div>
                            </div>
                            <!--Setting last item of the modal body, will add validation later when a connected to a database.-->
                            <div class = "modal-footer">
                                <a class = "btn btn-default" data-dismiss ="modal">Cancel</a>
                                <button class = "btn btn-primary" type = "submit">Submit</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!--Scripts used to allow modals, carousels, and most Jquery to run. Also runs the boostrap script.-->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
        <script src="js/bootstrap.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
