package com.aspose.font.WorkingWithTrueTypeFonts;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.TtfFont;
import com.aspose.font.utilities.Utils;

public class LoadTrueTypeFonts {

	public static void main(String[] args) {
		//ExStart:1
		String fileName = Utils.getDataDir() + "Montserrat-Regular.ttf"; //Font file name with full path

        FontDefinition fd = new FontDefinition(FontType.TTF, new FontFileDefinition("ttf", new FileSystemStreamSource(fileName)));
        TtfFont font = (TtfFont) Font.open(fd);        
        //ExEnd: 1
	}
}
