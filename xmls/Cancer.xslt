<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes" />

<xsl:template match="/">
  <html>
   <p><b>Type of cancer: </b><xsl:value-of select="//Type" /></p>
   <p><b>Patients with this type of cancer:</b></p>
   <table border="1">
    <xsl:for-each select="Cancer/Patients/Patient">
      <tr>
       <td><xsl:value-of select="name" /></td>
       <td><xsl:value-of select="surname" /></td>
       <td><xsl:value-of select="sex" /></td>
       <td><xsl:value-of select="dob" /></td>
       <td><xsl:value-of select="location" /></td>
       <td><xsl:value-of select="actual_state" /></td>
      </tr>
    </xsl:for-each>
    </table>
 </html>
</xsl:template>
</xsl:stylesheet>
