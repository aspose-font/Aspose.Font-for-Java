package com.aspose.font.WorkingWithType1Fonts;

import java.text.MessageFormat;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.GlyphId;
import com.aspose.font.GlyphUInt32Id;
import com.aspose.font.Type1Font;
import com.aspose.font.utilities.Utils;

public class DetectLatinSymbolsSupport {
	
	public static void main(String[] args) {
		//ExStart: 1
		String fileName = Utils.getDataDir() + "courier.pfb"; //Font file name with full path

		FontDefinition fd = new FontDefinition(FontType.Type1, new FontFileDefinition("pfb", new FileSystemStreamSource(fileName)));
        Type1Font font = (Type1Font) Font.open(fd);

        boolean latinText = true;


        for (int code = 65; code < 123; code++)
        {
            GlyphId gid = font.getEncoding().decodeToGid(code);
            if (gid == null || gid == GlyphUInt32Id.getNotDef())
            {
                latinText = false;
            }
        }

        if (latinText)
        {
            System.out.println(MessageFormat.format("Font {0} supports latin symbols.", font.getFontName()));
        }
        else
        {
            System.out.println(MessageFormat.format("Latin symbols are not supported by font {0}.", font.getFontName()));
        }
        //ExEnd: 1
	}
}
