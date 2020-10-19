package com.aspose.font.WorkingWithCFFFonts;

import com.aspose.font.ByteContentStreamSource;
import com.aspose.font.CffFont;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.utilities.Utils;

public class SaveCFFToDisc {

	public static void main(String[] args) {
		
		//ExStart: 1
		byte [] fontMemoryData = Utils.getInputFileBytes("OpenSans-Regular.cff");

        FontDefinition fd = new FontDefinition(FontType.CFF, new FontFileDefinition("cff", new ByteContentStreamSource(fontMemoryData)));
        CffFont font = (CffFont) Font.open(fd);
        
        System.out.println("Font has been loaded");
        
        //Work with data from just loaded CffFont object

        //Save CffFont to disk
        //Output Font file name with full path
        String outputFile = Utils.getDataDir() + "OpenSans-Regular_out.cff";
        font.save(outputFile);
        
        System.out.println("Font has been saved");
        //ExEnd: 1
	}
}
