package com.aspose.font.WorkingWithCFFFonts;

import com.aspose.font.CffFont;
import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.utilities.Utils;

public class LoadCffFont {

	public static void main(String[] args) {
		
		//ExStart: 1
		String fileName = Utils.getDataDir() + "OpenSans-Regular.cff"; //Font file name with full path

        FontDefinition fd = new FontDefinition(FontType.CFF, new FontFileDefinition("cff", new FileSystemStreamSource(fileName)));
        CffFont ttfFont = (CffFont) Font.open(fd);
        
        System.out.println("Font has been loaded");
        //ExEnd: 1
	}
}
