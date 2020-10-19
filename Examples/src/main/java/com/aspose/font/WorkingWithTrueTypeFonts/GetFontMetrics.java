package com.aspose.font.WorkingWithTrueTypeFonts;

import java.text.MessageFormat;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.Glyph;
import com.aspose.font.GlyphUInt32Id;
import com.aspose.font.TtfCMapFormatBaseTable;
import com.aspose.font.TtfFont;
import com.aspose.font.utilities.Utils;

public class GetFontMetrics {

	public static void main(String[] args) {
		//ExStart: 1
		String fileName = Utils.getDataDir() + "Montserrat-Regular.ttf"; //Font file name with full path

        FontDefinition fd = new FontDefinition(FontType.TTF, new FontFileDefinition("ttf", new FileSystemStreamSource(fileName)));
        TtfFont font = (TtfFont) Font.open(fd);

        String name = font.getFontName();
        System.out.println("Font name: " + name);
        System.out.println("Glyph count: " + font.getNumGlyphs());
        String metrics = MessageFormat.format(
            "Font metrics: ascender - {0}, descender - {1}, typo ascender = {2}, typo descender = {3}, UnitsPerEm = {4}",
            font.getMetrics().getAscender(), font.getMetrics().getDescender(),
            font.getMetrics().getTypoAscender(), font.getMetrics().getTypoDescender(), font.getMetrics().getUnitsPerEM());

        System.out.println(metrics);
        
      //Get cmap unicode encoding table from font as object TtfCMapFormatBaseTable to access information about font glyph for symbol 'A'.
        //Also check that font has object TtfGlyfTable (table 'glyf') to access glyph.
        TtfCMapFormatBaseTable cmapTable = null;
        if (font.getTtfTables().getCMapTable() != null)
        {
            cmapTable = font.getTtfTables().getCMapTable().findUnicodeTable();
        }
        if (cmapTable != null && font.getTtfTables().getGlyfTable() != null)
        {
        	System.out.println("Font cmap unicode table: PlatformID = " + cmapTable.getPlatformId() +
        			", PlatformSpecificID = " + cmapTable.getPlatformSpecificId());

            //Code for 'A' symbol
            char unicode = (char)65;

            //Glyph index for 'A'
            long glIndex = cmapTable.getGlyphIndex(unicode);

            if (glIndex != 0)
            {
                //Glyph for 'A'
                Glyph glyph = font.getGlyphById(glIndex);
                if (glyph != null)
                {
                    //Print glyph metrics
                	System.out.println("Glyph metrics for 'A' symbol:");
                    String bbox = MessageFormat.format(
                        "Glyph BBox: Xmin = {0}, Xmax = {1}" + ", Ymin = {2}, Ymax = {3}",
                        glyph.getGlyphBBox().getXMin(), glyph.getGlyphBBox().getXMax(),
                        glyph.getGlyphBBox().getYMin(), glyph.getGlyphBBox().getYMax());
                    System.out.println(bbox);
                    System.out.println("Width:" + font.getMetrics().getGlyphWidth(new GlyphUInt32Id(glIndex)));
                }
            }
        }
        //ExEnd: 1
	}
}
