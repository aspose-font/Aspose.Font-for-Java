package com.aspose.font.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Utils {
    public static String getSharedDataDir(Class c) {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");

        return dir.toString() + File.separator;
    }

    public static String getDataDir() {
        File dir = new File(System.getProperty("user.dir"));
        dir = new File(dir, "src");
        dir = new File(dir, "main");
        dir = new File(dir, "resources");
        System.out.println("Using data directory: " + dir.toString());
        return dir.toString() + File.separator;
    }
    
    public static byte[] getInputFileBytes(String fileName)
	{
		try {
			FileInputStream in = new FileInputStream(getDataDir() + fileName);
			byte[] fontFileContent = new byte[in.available()];
			in.read(fontFileContent, 0, fontFileContent.length);
			
			return fontFileContent;
		} catch (IOException ex) {
			throw new RuntimeException("Exception is caught: " + ex);
		}
	}

    public static String GetOutputFilePath(String inputFilePath)
    {
        String extension = "";
        int i = inputFilePath.lastIndexOf('.');
        if (i > 0) {
            extension = inputFilePath.substring(i+1);
        }
        if (inputFilePath.contains("."))
        {
            inputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf("."));}

        return inputFilePath + "_out_." + extension;
    }
}
