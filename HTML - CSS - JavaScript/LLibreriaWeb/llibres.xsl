<!-- llibres.xsl -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head>
      <title>Llistat de Llibres</title>
      <link rel="stylesheet" type="text/css" href="style.css"/>
      </head>
      <body>
        <h1>Llibres disponibles</h1>
        <table class="Taula">
          <tr>
            <th>Llibre</th>
            <th>Autor</th>
            <th>Pagines</th>
          </tr>
          <xsl:for-each select="llibres/llibre">
            <tr>
              <td><xsl:value-of select="titol"/></td>
              <td><xsl:value-of select="autor"/></td>
              <td><xsl:value-of select="paginas"/></td>
            </tr>
          </xsl:for-each>
         </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
