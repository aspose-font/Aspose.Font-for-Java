package com.aspose.font.WorkingWithTrueTypeFonts;

import com.aspose.font.ByteContentStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.TtfFont;
import com.aspose.font.utilities.Utils;

public class SaveTTFToDisc {

	public static void main(String[] args) {
		//ExStart: 4
		byte[] fontMemoryData = Utils.getInputFileBytes("Montserrat-Regular.ttf"); //Font file name with full path

        FontDefinition fd = new FontDefinition(FontType.TTF, new FontFileDefinition("ttf", new ByteContentStreamSource(fontMemoryData)));
        TtfFont font = (TtfFont) Font.open(fd);
        
        //Work with data from just loaded TtfFont object

        //Save TtfFont to disk
        //Output Font file name with full path
        String outputFile = Utils.getDataDir() + "Montserrat-Regular_out.ttf";

        font.save(outputFile);
        //ExEnd: 4
	}
}
