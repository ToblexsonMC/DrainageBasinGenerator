package com.toblexson.frames;

import java.awt.Graphics;

import javax.swing.JFrame;

import com.toblexson.generators.ElevationGenerator;
import com.toblexson.reference.Values;
import com.toblexson.tiles.ElevationTile;
import com.toblexson.util.FrameHelper;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private ElevationTile[][] grid;

	public MainFrame()
	{	
		genGrid();
		genFrame();
		new ElevationGenerator(grid);
	}

	private void genFrame() 
	{
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Drainage Basin Generator");
		
		setExtendedState(getExtendedState()|JFrame.MAXIMIZED_BOTH);
		FrameHelper.centreFrame(getWidth(), getHeight(), this);
		repaint();
		setVisible(true);
	}
	
	private void genGrid() 
	{
		grid = new ElevationTile[Values.maxX][Values.maxY];
		
		int midHeight = FrameHelper.scrSize.height / 2;
		int midWidth = FrameHelper.scrSize.width / 2;
		int maximumSize;
		
		if(FrameHelper.scrSize.height < FrameHelper.scrSize.width)
		{
			maximumSize = FrameHelper.scrSize.height;
		} else
		{
			maximumSize = FrameHelper.scrSize.width;
		}
		
		int smallestFrameValue;
		
		if(Values.maxX < Values.maxY)
		{
			smallestFrameValue = Values.maxX;
		} else
		{
			smallestFrameValue = Values.maxY;
		}
		
		int independentSize = (maximumSize - 90) / smallestFrameValue; 
		//System.out.println(smallestFrameValue);
		//System.out.println(independentSize);
		
		
		for(int a = 0; a < Values.maxX; a++)
		{
			for(int b = 0; b < Values.maxY; b++)
			{
								
				grid[a][b] = new ElevationTile(((a * independentSize) + midWidth) - ((independentSize * Values.maxX) / 2), ((b * independentSize) + midHeight) - ((independentSize * Values.maxY) / 2), independentSize, independentSize, this);
			}
		}
	}
	
	public void paint(Graphics graphics)
	{
		//System.out.println("painting...");
		for(int a = 0; a < Values.maxX; a++)
		{
			for(int b = 0; b < Values.maxY; b++)
			{
				//System.out.println(a + "," + b);
				int x = grid[a][b].getxCoord();
				int y = grid[a][b].getyCoord();
				int width = grid[a][b].getWidth();
				int height = grid[a][b].getHeight();
				//System.out.println(x + "," + y + "\t" + width + "," + height);	
				
				graphics.drawRect(x, y, width, height);
			}
		}
	}
}
