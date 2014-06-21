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

<html:html lang="true">
    <!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><bean:message key="welcome.title"/></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/StorageUnits/styles/styles.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.min.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.theme.css">
        <link rel="stylesheet" href="/StorageUnits/styles/jquery-ui.structure.css">
        <script src="/StorageUnits/scripts/jquery.js"></script>
        <script src="/StorageUnits/scripts/jquery-ui.min.js"></script>
        <link rel="stylesheet" href="/StorageUnits/styles/storageUnitTheme.css">
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
        <html:base/>

    </head>
    <body>

        <logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
            <div  style="color: red">
                ERROR:  Application resources not loaded -- check servlet container
                logs for error messages.
            </div>
        </logic:notPresent>

        <h3><bean:message key="welcome.heading"/></h3>
        <p><bean:message key="welcome.message"/></p>

        <div style="color:red"><html:errors/></div>  
        <p>Storage Unit Search</p>
        <html:form action="/customerStorageUnitSearch">   
            <table>
                <tr>
                    <td>
                        <bean:message key="label.customer.storage.unit.search.availability"/>
                        <html:select property="unitAvailability">
                            <html:option value="-1" ><bean:message key="label.customer.storage.unit.search.choose.option"/></html:option>
                            <html:option value="0"><bean:message key="label.customer.storage.unit.search.no"/></html:option>
                            <html:option value="1"><bean:message key="label.customer.storage.unit.search.yes"/></html:option>                            
                        </html:select>
                    </td>
                    <td>
                        <bean:message key="label.customer.storage.unit.search.dimensions"/>
                        <html:select property="unitDimensions">
                            <html:option value=""><bean:message key="label.customer.storage.unit.search.choose.option"/></html:option>
                            <html:option value="10x10"><bean:message key="label.customer.storage.unit.search.small"/></html:option>
                            <html:option value="15x15"><bean:message key="label.customer.storage.unit.search..medium"/></html:option>
                            <html:option value="20x20"><bean:message key="label.customer.storage.unit.search.large"/></html:option>
                        </html:select>   
                    </td>
                    <td>
                        <label><bean:message key="label.customer.storage.unit.search.datepicker"/></label><input type="text" name="dateTo" class="datepicker" value="Click Here" size="9">
                        <html:submit><bean:message key="label.customer.storage.unit.search.submit"/></html:submit>
                        </td>
                    </tr>
                </table>
        </html:form>
    </body>
</html:html>