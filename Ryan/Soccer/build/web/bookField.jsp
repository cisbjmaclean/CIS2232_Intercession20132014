<%-- 
    Document   : bookField
    Created on : Jun 15, 2014, 11:44:55 PM
    Author     : Ryan
    Purpose : This is the page that is loaded if the person logged in wants to 
    book a field. If the field is already booked the field can not be booked again.
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="title.book"/></title>
    <html:base/>
    </head>
    <body>
    <div class="main">  
    <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
    </logic:notPresent>
        
        <h3><bean:message key="label.viewFields"/></h3>
        
        <html:form action="/BookingAction.do">
            <bean:message key="book.coach"/>
            <bean:write name="loginForm" property="userName" />

            <br>
            <bean:message key="book.field"/>
            <html:select property="fieldNum">
                <logic:iterate name="fields" id="TheField" scope ="request">
                    <option value="<bean:write name="TheField" property="fieldNum"/>">
                        <bean:write name="TheField" property="fieldNum"/>
                        <bean:write name="TheField" property="fieldName" />    
                    </option>
                </logic:iterate>
            </html:select>
            <br>
            
            <bean:message key="book.day"/>
            <html:select property="date">
                <logic:iterate name="dates" id="TheDate" scope ="request">
                <option value="<bean:write name="TheDate" property="date" />">
                        <bean:write name="TheDate" property="date" />
                </option>
                </logic:iterate>
            </html:select>
            <br>
            <bean:message key="book.time"/>
            <html:select property="timeNum">
                <logic:iterate name="times" id="TheTime" scope ="request">
                <option value="<bean:write name="TheTime" property="timeNum" />">
                        <bean:write name="TheTime" property="timeDef" />
                </option>
                </logic:iterate>
            <br>

            </html:select>
            <html:submit><bean:message key="label.submit"/></html:submit>
        </html:form>
    </div>
    </body>
</html:html>

