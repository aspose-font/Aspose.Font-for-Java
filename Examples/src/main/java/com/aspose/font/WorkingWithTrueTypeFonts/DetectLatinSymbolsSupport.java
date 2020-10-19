package com.aspose.font.WorkingWithTrueTypeFonts;

import java.text.MessageFormat;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.GlyphId;
import com.aspose.font.GlyphUInt32Id;
import com.aspose.font.TtfFont;
import com.aspose.font.utilities.Utils;

public class DetectLatinSymbolsSupport {

	public static void main(String[] args) {
		//ExStart: 1
		String fileName = Utils.getDataDir() + "Montserrat-Regular.ttf"; //Font file name with full path

        FontDefinition fd = new FontDefinition(FontType.TTF, new FontFileDefinition("ttf", new FileSystemStreamSource(fileName)));
        TtfFont ttfFont = (TtfFont) Font.open(fd);

        boolean latinText = true;


        for (int code = 65; code < 123; code++)
        {
            GlyphId gid = ttfFont.getEncoding().decodeToGid(code);
            if (gid == null || gid == GlyphUInt32Id.getNotDef())
            {
                latinText = false;
            }
        }

        if (latinText)
        {
            System.out.println(MessageFormat.format("Font {0} supports latin symbols.", ttfFont.getFontName()));
        }
        else
        {
        	System.out.println(MessageFormat.format("Latin symbols are not supported by font {0}.", ttfFont.getFontName()));
        }
        //ExEnd: 1
	}
}
