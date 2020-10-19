package com.aspose.font.WorkingWithType1Fonts;

import java.text.MessageFormat;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.Type1Font;
import com.aspose.font.utilities.Utils;

public class GetFontMetrics {
	
	public static void main(String[] args) {
		//ExStart: 1
		String fileName = Utils.getDataDir() + "courier.pfb"; //Font file name with full path

		FontDefinition fd = new FontDefinition(FontType.Type1, new FontFileDefinition("pfb", new FileSystemStreamSource(fileName)));
        Type1Font font = (Type1Font) Font.open(fd);

        String name = font.getFontName();
        System.out.println("Font name: " + name);
        System.out.println("Glyph count: " + font.getNumGlyphs());
        String metrics = MessageFormat.format(
            "Font metrics: ascender - {0}, descender - {1}, typo ascender = {2}, typo descender = {3}, UnitsPerEm = {4}",
            font.getMetrics().getAscender(), font.getMetrics().getDescender(),
            font.getMetrics().getTypoAscender(), font.getMetrics().getTypoDescender(), font.getMetrics().getUnitsPerEM());

        System.out.println(metrics);
        //ExEnd: 1
	}
}
