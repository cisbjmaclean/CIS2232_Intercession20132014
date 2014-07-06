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
    <body>

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


    <html:form action="/Menu">
        <center>      
            <table>
                <tr>
                    <td>            
                        <h3><bean:message key="label.about"/></h3><br/>
                    </td>
                </tr>
                <tr>
                    <td>            
This application is created using the stylesheet for the 2014 intercession.  It provides links to <br/>
the student created projects for the various offering of this course.  It also provides examples of<br/>
projects that are done using the styles for the given course offering.  <br/>
<br/>
Each project should follow the class CLF (unless discussed).  Each should also have an about which<br/>
provides background details of the project (author, date, purpose).

                    </td>
                </tr>

            </table>


        </center>
    </html:form>
</body>
</html:html>
