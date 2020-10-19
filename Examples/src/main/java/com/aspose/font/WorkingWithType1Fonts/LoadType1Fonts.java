package com.aspose.font.WorkingWithType1Fonts;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.Type1Font;
import com.aspose.font.utilities.Utils;

public class LoadType1Fonts {
	
	public static void main(String[] args) {
		//ExStart: 1
		String fileName = Utils.getDataDir() + "courier.pfb"; //Font file name with full path

		FontDefinition fd = new FontDefinition(FontType.Type1, new FontFileDefinition("pfb", new FileSystemStreamSource(fileName)));
        Type1Font font = (Type1Font) Font.open(fd);
        //ExEnd: 1
	}
}
