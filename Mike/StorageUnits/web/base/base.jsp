<%@ taglib uri="http://struts.apache.org/tags-bean"  prefix="bean" %>  
<%@ taglib uri="http://struts.apache.org/tags-html"  prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %> 
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

<%--

This is the base layout.  It is used as a base tile jsp which controls 
where the header, body and footers go.  
--%>

<html:html>
      <head><link rel="stylesheet" type="text/css" href="http://localhost:8080/StorageUnits/styles/styles.css"></head>
    <body>

        <!-- Header page information -->
        <tiles:insert attribute="header" />

        <!-- Main body information -->
        <tiles:insert attribute="body" />

        <!-- Footer information -->
        <tiles:insert attribute="footer" />

    </body>

</html:html>
