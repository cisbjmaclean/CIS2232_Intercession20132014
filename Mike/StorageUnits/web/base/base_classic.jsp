<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%-- Layout Tiles 
  This layout render a header, left menu, body and footer.
  @param title String use in page title
  @param header Header tile (jsp url or definition name)
  @param menu Menu 
  @param body Body
  @param footer Footer
--%>

<HTML>
      <head><link rel="stylesheet" type="text/css" href="http://localhost:8080/StorageUnits/styles/styles.css"></head>

    <body> 
        <table>
            <tr>
                <td></td>
                <td align="center"><tiles:insert attribute="header" /></td>
            </tr>
            <tr>
                <td width="10%" valign="top">
                    <tiles:insert attribute='menu'/>
                </td>
                <td width="90%" valign="top"  align="center">
                    <tiles:insert attribute='body' />
                </td>
            </tr>
            <tr>
                <td></td>
                <td align="center"><tiles:insert attribute="footer" /></td>
            </tr>
        </table>
    </body>
</html>