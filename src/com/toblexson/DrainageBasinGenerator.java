package com.toblexson;

import com.toblexson.frames.InitialFrame;
import com.toblexson.frames.MainFrame;
import com.toblexson.reference.Values;

public class DrainageBasinGenerator 
{	
	public static void main(String[] args) 
	{		
		new InitialFrame();
		
		while(Values.maxX == 0 && Values.maxY == 0 && Values.scale == 0)
		{
			//placeholder until I find a better solution
			System.out.println(".");
		}
		
		//System.out.println(Values.maxX);
		//System.out.println(Values.maxY);
		//System.out.println(Values.scale);
		
		new MainFrame();
	}
}
