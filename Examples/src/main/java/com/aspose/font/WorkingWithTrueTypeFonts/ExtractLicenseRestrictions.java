package com.aspose.font.WorkingWithTrueTypeFonts;

import java.text.MessageFormat;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.LicenseFlags;
import com.aspose.font.TtfFont;
import com.aspose.font.utilities.Utils;

public class ExtractLicenseRestrictions {

	public static void main(String[] args) {
		//ExStart: 1
		String fileName = Utils.getDataDir() + "Montserrat-Regular.ttf"; //Font file name with full path

        FontDefinition fd = new FontDefinition(FontType.TTF, new FontFileDefinition("ttf", new FileSystemStreamSource(fileName)));
        TtfFont font = (TtfFont) Font.open(fd);

        LicenseFlags licenseFlags = null;
        if (font.getTtfTables().getOs2Table() != null)
        {
            licenseFlags = font.getTtfTables().getOs2Table().getLicenseFlags();
        }

        if (licenseFlags == null || licenseFlags.isFSTypeAbsent())
        {
            System.out.println(MessageFormat.format("Font {0} has no embedded license restrictions", font.getFontName()));
        }
        else
        {
            if (licenseFlags.isEditableEmbedding())
            {
            	System.out.println(MessageFormat.format("Font {0} may be embedded, and may be temporarily loaded on other systems.", font.getFontName())
                    + " In addition, editing is permitted, including ability to format new text"
                    + " using the embedded font, and changes may be saved.");
            }
            else if (licenseFlags.isInstallableEmbedding())
            {
            	System.out.println(MessageFormat.format("Font {0} may be embedded, and may be permanently installed", font.getFontName())
                    + " for use on a remote systems, or for use by other users.");
            }
            else if (licenseFlags.isPreviewAndPrintEmbedding())
            {
            	System.out.println(MessageFormat.format("Font {0} may be embedded, and may be temporarily loaded", font.getFontName())
                    + "  on other systems for purposes of viewing or printing the document.");
            }
            else if (licenseFlags.isRestrictedLicenseEmbedding())
            {
            	System.out.println(MessageFormat.format("Font {0} must not be modified, embedded or exchanged in any manner", font.getFontName())
                    + " without first obtaining explicit permission of the legal owner.");
            }
        }
        //ExEnd: 1
	}
}
