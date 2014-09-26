package com.toblexson.tiles;

import javax.swing.JFrame;

public class Tile 
{
	private int xCoord;
	private int yCoord;
	private int width;
	private int height;
	public Tile(int xCoord, int yCoord, int width, int height, JFrame frame)
	{
		this.setxCoord(xCoord);
		this.setyCoord(yCoord);
		this.setWidth(width);
		this.setHeight(height);
	}

	public int getxCoord() 
	{
		return xCoord;
	}

	public void setxCoord(int xCoord) 
	{
		this.xCoord = xCoord;
	}

	public int getyCoord() 
	{
		return yCoord;
	}

	public void setyCoord(int yCoord) 
	{
		this.yCoord = yCoord;
	}

	public int getWidth() 
	{
		return width;
	}

	public void setWidth(int width) 
	{
		this.width = width;
	}

	public int getHeight() 
	{
		return height;
	}

	public void setHeight(int height) 
	{
		this.height = height;
	}
}
