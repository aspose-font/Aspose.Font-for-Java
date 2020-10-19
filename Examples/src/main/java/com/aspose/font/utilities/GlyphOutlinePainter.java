package com.aspose.font.utilities;

import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import com.aspose.font.CurveTo;
import com.aspose.font.IGlyphOutlinePainter;
import com.aspose.font.LineTo;
import com.aspose.font.MoveTo;

public class GlyphOutlinePainter implements IGlyphOutlinePainter
{

	//>>>>>>>> #region  Ctors

	public GlyphOutlinePainter(GeneralPath path)
	{
		_path = path;
	}

	//<<<<<<<< #endregion 

	//>>>>>>>> #region  Fields

	private GeneralPath _path;
	private Point2D.Float _currentPoint = new Point2D.Float();

	//<<<<<<<< #endregion 


	//>>>>>>>> #region  IGlyphOutlinePainter implementation

	public void moveTo(MoveTo moveTo)
	{
		// automatically close the figure (some fonts don't close subpaths and we fix their behaviour)
		_path.moveTo((float)moveTo.getX(), (float)moveTo.getY());
	}

	public void lineTo(LineTo lineTo)
	{
		_path.lineTo((float) lineTo.getX(), (float) lineTo.getY());
	}

	public void curveTo(CurveTo curveTo)
	{
		_path.curveTo((float)curveTo.getX1(),
				(float)curveTo.getY1(),
				(float)curveTo.getX2(),
				(float)curveTo.getY2(),
				(float)curveTo.getX3(),
				(float)curveTo.getY3());
	}

	public void closePath()
	{
		_path.closePath();
	}

	//<<<<<<<< #endregion 

}
