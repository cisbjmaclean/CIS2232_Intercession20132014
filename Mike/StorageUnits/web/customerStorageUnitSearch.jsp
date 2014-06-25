    <%-- 
    Document   : customerStorageUnitSearch
    Created on : Jun 20, 2014, 7:31:16 PM
    Author     : Michael
--%>

<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*"%>


<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="label.customer.storage.unit.search.title"/></title>  
        <script>
            $(function() {
                $(".datepicker").datepicker({
                    minDate: +1,
                    maxDate: "+36M"
                });
            });
        </script>
        <noscript>
        "You don't have Javascript turned on! In order for this page to function properly you must turn on Javascript."
        </noscript>
    </head>
    <body>
        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div style="color: red">
                ERROR: Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>
        <h3><bean:message key="label.customer.storage.unit.search.message"/></h3>
        <table>
            <tr>
                <td>
                    <logic:messagesPresent message="true">
                        <html:messages id="msg2" message="true" property="success"><div class="infoMessageCheck" style="color: green"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="warn"><div class="warnExclaim"  style="color: yellow"><bean:write name="msg2"/></div><br/></html:messages>
                        <html:messages id="msg2" message="true" property="error"><div class="errorX"  style="color: red"><bean:write name="msg2"/></div><br/></html:messages>				  		
                    </logic:messagesPresent>
                    <%-- the html:errors is populated if the validator is used. --%>    
                    <div style="color:red">
                        <html:errors />
                    </div>
                </td>
            </tr>
        </table>
                    
        <table id="customerUnitSearch">
            <html:form action="/customerStorageUnitSearch">   

                <tr>
                    <td>
                        <bean:message key="label.customer.storage.unit.search.availability"/>
                    </td>
                    <td>
                        <bean:message key="label.customer.storage.unit.search.dimensions"/>
                    </td>
                    <td>
                        <label><bean:message key="label.customer.storage.unit.search.datepicker"/></label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <html:select property="unitAvailability">
                            <html:option value="-1" ><bean:message key="label.customer.storage.unit.search.choose.option"/></html:option>
                            <html:option value="0"><bean:message key="label.customer.storage.unit.search.no"/></html:option>
                            <html:option value="1"><bean:message key="label.customer.storage.unit.search.yes"/></html:option>                            
                        </html:select>
                    </td>
                    <td>
                        <html:select property="unitDimensions">
                            <html:option value=""><bean:message key="label.customer.storage.unit.search.choose.option"/></html:option>
                            <html:option value="10x10"><bean:message key="label.customer.storage.unit.search.small"/></html:option>
                            <html:option value="15x15"><bean:message key="label.customer.storage.unit.search..medium"/></html:option>
                            <html:option value="20x20"><bean:message key="label.customer.storage.unit.search.large"/></html:option>
                        </html:select>   
                    </td>   
                    <td>
                        <input type="text" name="dateTo" class="datepicker" value="Click Here">
                    </td>
                     <td>
                         <html:reset/>
                        </td>
                    <td>
                        <html:submit><bean:message key="label.customer.storage.unit.search.submit"/></html:submit>
                        </td>
                    </tr>
            </html:form>
        </table>
    </body>
</html:html>