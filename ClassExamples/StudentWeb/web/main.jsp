<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <html:base/>
    </head>

    <center>
    <logic:messagesPresent message="true">
        <html:messages id="msg2" message="true" property="message1"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>				  		
        <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
        <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
    </logic:messagesPresent>
    <%-- the html:errors is populated if the validator is used!.     --%>    
    <div style="color:red">
        <html:errors />
    </div>
    </center>


    <body style="background-color: yellowgreen">
        <html:form action="/Menu">
        <center>      
            <input type="radio" name="option" value="add"><bean:message key="menu.add"/><br>
            <input type="radio" name="option" value="viewall"><bean:message key="menu.view.all"/><br>
            <input type="radio" name="option" value="edit"><bean:message key="menu.edit"/><br>
            <input type="radio" name="option" value="exit"><bean:message key="menu.exit"/><br>
            <html:submit><bean:message key="label.submit"/></html:submit>
            </center>
    </html:form>
</body>
</html:html>
