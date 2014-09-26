package com.toblexson.util;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class FrameHelper 
{
	public static Toolkit kit = Toolkit.getDefaultToolkit(); 
	public static Dimension scrSize = kit.getScreenSize(); 
	
	public static void centreFrame(int width, int height, JFrame frame)
	{
		frame.setLocation((scrSize.width / 2) - (width / 2), (scrSize.height / 2) - (height / 2));
	}
}
