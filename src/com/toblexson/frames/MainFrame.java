package com.toblexson.frames;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.toblexson.reference.Values;
import com.toblexson.tiles.Tile;
import com.toblexson.util.FrameHelper;

public class MainFrame extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private Tile[][] grid;

	public MainFrame()
	{	
		genGrid();
		genFrame();
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
		grid = new Tile[Values.maxX][Values.maxY];
		
		int midWidth = FrameHelper.scrSize.width / 2;
		int midHeight = FrameHelper.scrSize.width / 2;
		//middle index in Grid array
		int midGridIndex = (Values.maxX * Values.maxY) / 2;
		//space to be used
		int usableWidth = FrameHelper.scrSize.height - 20;
		int usableHeight = FrameHelper.scrSize.width - 20;
		//sets space to smallest of the two values above
		int space;
		if(usableHeight < usableWidth) 
		{
			space = usableHeight;
		} else
		{
			space = usableWidth;
		}
		//size of each square
		int size = space / (Values.maxX * Values.maxY);
		
		System.out.println(size);
		
		for(int a = 0; a < Values.maxX; a++)
		{
			for(int b = 0; b < Values.maxY; b++)
			{
				int x = a;
				int y = b;
								
				grid[a][b] = new Tile((x * size) + 10, (y * size) + 10, size, size, this);
				//STILL NOT WORKING
			}
		}
	}
	
	public void paint(Graphics graphics)
	{
		System.out.println("painting...");
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
