package com.toblexson.tiles;

import javax.swing.JFrame;

public class ElevationTile extends Tile
{
	private int elevation;

	public ElevationTile(int xCoord, int yCoord, int width, int height, JFrame frame) 
	{
		super(xCoord, yCoord, width, height, frame);
	}

	public int getElevation() 
	{
		return elevation;
	}

	public void setElevation(int elevation) 
	{
		this.elevation = elevation;
	}

}
