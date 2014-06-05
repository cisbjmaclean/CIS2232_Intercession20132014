<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>


<script type="text/javascript">
//<![CDATA[
    function formFocus() {
        document.forms[0].elements["userName"].focus();
    }

    window.onload = formFocus;
//]]>
</script>

<html:form action="/Initialize">
    <body onload="formFocus()" 
          <%--
          
          This form displays the text fields to get the username and password.  This form will submit to the
          authenticate action.
          
          --%>

          <div style="height: 100px; text-align: center; background-color: #efefef; padding: 10px; -webkit-border-radius: 12px; -moz-border-radius: 12px; margin-right: 10px">
            <table align="center" >
                <tr>
                    <td>
                        <%--  These messages can be used to display either messages, warnings, or errors from your
    actions.  You'll notice that once a court is booked a message is put out as an 
    information message.  --%>


                        <logic:messagesPresent message="true">
                            <html:messages id="msg2" message="true" property="message1"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>				  		
                            <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
                            <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
                        </logic:messagesPresent>
                        <div style="color:red">
                            <html:errors />
                        </div>
                    </td>
                </tr>

                <tr>
                    <td>        
                        <h1><bean:message key="welcome.title"/></h1>
                    </td>
                </tr>

                <tr align="center">
                    <td colspan="2">
                        <input type="submit" value="Enter"/>
                    </td>
                </tr>
            </table>
        </div>        

    </body>
</html:form>
