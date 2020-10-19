package com.aspose.font.WorkingWithType1Fonts;

import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.aspose.font.FileSystemStreamSource;
import com.aspose.font.Font;
import com.aspose.font.FontDefinition;
import com.aspose.font.FontFileDefinition;
import com.aspose.font.FontType;
import com.aspose.font.Glyph;
import com.aspose.font.GlyphId;
import com.aspose.font.GlyphOutlineRenderer;
import com.aspose.font.IFont;
import com.aspose.font.IGlyphRenderer;
import com.aspose.font.TransformationMatrix;
import com.aspose.font.Type1Font;
import com.aspose.font.utilities.GlyphOutlinePainter;
import com.aspose.font.utilities.Utils;

public class RenderingText {
	
	public static void main(String[] args) {
		//ExStart: 1
		String fileName = Utils.getDataDir() + "courier.pfb"; //Font file name with full path

		FontDefinition fd = new FontDefinition(FontType.Type1, new FontFileDefinition("pfb", new FileSystemStreamSource(fileName)));
        Type1Font font = (Type1Font) Font.open(fd);
        
        try {
	        drawText("Hello world", font, 14, java.awt.Color.WHITE, java.awt.Color.BLACK, Utils.getDataDir() + "hello1_type1_out.jpg");
	        drawText("Hello world", font, 14, java.awt.Color.YELLOW, java.awt.Color.RED, Utils.getDataDir() + "hello2_type1_out.jpg");
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
        //ExEnd: 1
	}
	
	//ExStart: 2
	static void drawText(String text, IFont font, double fontSize,
            Paint backgroundBrush, Paint textBrush, String outFile) throws Exception
	{
	    //Get glyph identifiers for every symbol in text line
	    GlyphId[] gids = new GlyphId[text.length()];
	    for (int i = 0; i < text.length(); i++)
	        gids[i] = font.getEncoding().decodeToGid(text.charAt(i));
	    // set common drawing settings
	    double dpi = 300;
	
	    double resolutionCorrection = dpi / 72; // 72 is font's internal dpi
	    // prepare output bitmap
	    BufferedImage outBitmap = new BufferedImage(960, 720, BufferedImage.TYPE_INT_BGR);
	    //outBitmap.getRaster().SetResolution((float)dpi, (float)dpi);
	    java.awt.Graphics2D outGraphics = (java.awt.Graphics2D) outBitmap.getGraphics();
	    outGraphics.setPaint(backgroundBrush);
	    outGraphics.fillRect(0, 0, outBitmap.getWidth(), outBitmap.getHeight());
	    outGraphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
	    //declare coordinate variables and previous gid
	    GlyphId previousGid = null;
	    double glyphXCoordinate = 0;
	    double glyphYCoordinate = fontSize * resolutionCorrection;
	    //loop which paints every glyph in gids
	    for (GlyphId gid : gids)
	    {
	        // if the font contains the gid
	        if (gid != null)
	        {
	            Glyph glyph = font.getGlyphAccessor().getGlyphById(gid);
	            if (glyph == null)
	                continue;
	
	            // path that accepts drawing instructions
	            GeneralPath path = new GeneralPath();
	
	            // Create IGlyphOutlinePainter implementation
	            GlyphOutlinePainter outlinePainter = new GlyphOutlinePainter(path);
	
	            // Create the renderer
	            IGlyphRenderer renderer = new GlyphOutlineRenderer(outlinePainter);
	
	            // get common glyph properties
	            double kerning = 0;
	
	            // get kerning value
	            if (previousGid != null)
	            {
	                kerning = (font.getMetrics().getKerningValue(previousGid, gid) /
	                           glyph.getSourceResolution()) * fontSize * resolutionCorrection;
	                kerning += fontWidthToImageWith(font.getMetrics().getGlyphWidth(previousGid),
	                        glyph.getSourceResolution(), fontSize, 300);
	            }
	
	            // glyph positioning - increase glyph X coordinate according to kerning distance
	            glyphXCoordinate += kerning;
	
	            // Glyph placement matrix
	            TransformationMatrix glyphMatrix =
	                new TransformationMatrix(
	                    new double[]
	                            {
	                                    fontSize*resolutionCorrection,
	                                    0,
	                                    0,
	                                // negative because of bitmap coordinate system begins from the top
	                                    - fontSize*resolutionCorrection,
	                                    glyphXCoordinate,
	                                    glyphYCoordinate
	                            });
	
	            // render current glyph
	            renderer.renderGlyph(font, gid, glyphMatrix);
	            // fill the path
	            path.setWindingRule(GeneralPath.WIND_NON_ZERO);
	            outGraphics.setPaint(textBrush);
	            outGraphics.fill(path);
	        }
	        //set current gid as previous to get correct kerning for next glyph
	        previousGid = gid;
	    }
	    //Save results
	    ImageIO.write(outBitmap, "jpg", new File(outFile));
	}
	//ExEnd: 2
	
	//ExStart: 3
	static double fontWidthToImageWith(double width, int fontSourceResulution, double fontSize, double dpi)
	{
	    double resolutionCorrection = dpi / 72; // 72 is font's internal dpi
	    return (width / fontSourceResulution) * fontSize * resolutionCorrection;
	}
	//ExEnd: 3
}
