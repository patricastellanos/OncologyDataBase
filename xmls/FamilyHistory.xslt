<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:template match="/">
  <html>
   <p><b>Type of cancer: </b><xsl:value-of select="//type_cancerFam" /></p>
   <p><b>Member of the family: </b><xsl:value-of select="//member" /></p>
   
 </html>
 
</xsl:template>

</xsl:stylesheet>
