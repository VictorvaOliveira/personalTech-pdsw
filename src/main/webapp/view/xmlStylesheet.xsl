<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>

    <xsl:template match="/">
        <div id="uf" class="form-group">
            <label class="control-label col-sm-2" for="estado">Estado: </label>
            <div class="col-sm-10">
                <select class="form-control">
                    <option>-- Escolha uma opção --</option>
                    <xsl:for-each select="//estado">
                        <xsl:sort select="@name" order="ascending"/>
                        <option value="{@id}">
                            <xsl:value-of select="@name"/>
                        </option>
                    </xsl:for-each>
                </select>
            </div>
        </div>
    </xsl:template>

</xsl:stylesheet>
