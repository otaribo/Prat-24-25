<!-- llibres.xsl -->
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:template match="/">
    <html>
      <head><title>Llistat de Llibres</title></head>
      <body>
        <h1>Llibres disponibles</h1>
        <ul>
          <xsl:for-each select="llibres/llibre">
            <li>
              <strong><xsl:value-of select="titol"/></strong>
              — <xsl:value-of select="autor"/>
            </li>
          </xsl:for-each>
        </ul>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
