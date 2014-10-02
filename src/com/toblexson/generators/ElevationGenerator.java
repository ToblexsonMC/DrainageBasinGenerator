package com.toblexson.generators;

import java.util.Random;

import com.toblexson.reference.Values;
import com.toblexson.tiles.ElevationTile;

public class ElevationGenerator 
{
	private ElevationTile[][] grid;
	private Random random = new Random();

	//Basic chance 
	private double chance = 0.15;

	public ElevationGenerator(ElevationTile[][] grid)
	{
		this.grid = grid;
		addElevation();
	}

	private void addElevation()
	{
		int[] tileAbove = new int[2];
		int[] tileBelow = new int[2];
		int[] tileLeft = new int[2];
		int[] tileRight = new int[2];

		for(int x = 0; x < Values.maxX; x++)
		{
			for(int y = 0; y < Values.maxY; y++)
			{
				tileAbove[0] = x;
				tileAbove[1] = y - 1;

				tileBelow[0] = x;
				tileBelow[1] = y + 1;

				tileLeft[0] = x - 1;
				tileLeft[1] = y;

				tileRight[0] = x + 1;
				tileRight[1] = y;
				
				GenTerrain(tileAbove, tileBelow, tileLeft, tileRight, -10, x, y, 1);
				GenTerrain(tileAbove, tileBelow, tileLeft, tileRight, 10, x, y, 4);
				GenTerrain(tileAbove, tileBelow, tileLeft, tileRight, 20, x, y, 3);
			}
		}
	}
	private void GenTerrain(int[] tileAbove, int[] tileBelow, int[] tileLeft, int[] tileRight, int height, int x, int y, int iterations)
	{
		for(int a = 0; a < iterations; a++)
		{
			System.out.println(a);
			//check if tile is within array
			if(tileAbove[1] < Values.maxY && tileAbove[1] >= 0
					&& tileBelow[1] < Values.maxX && tileBelow[1] >= 0
					&& tileLeft[0] < Values.maxY && tileLeft[0] >= 0
					&& tileRight[0] < Values.maxY && tileRight[0] >= 0)
			{
				//if so check to see if next to tile of height 20+ lower
				if(grid[tileAbove[0]] [tileAbove[1]].getElevation() == height - 20
						|| grid[tileBelow[0]] [tileBelow[1]].getElevation() == height - 20
						|| grid[tileLeft[0]] [tileLeft[1]].getElevation() == height - 20
						|| grid[tileRight[0]] [tileRight[1]].getElevation() == height - 20) 
				{
					//generate tile with low change
					if(random.nextInt(100) < (chance / 4) * 100)
					{
						grid[x][y].setElevation(height);
					}
					//else if tile is next to same height tile 
				} else if(grid[tileAbove[0]] [tileAbove[1]].getElevation() == height
						|| grid[tileBelow[0]] [tileBelow[1]].getElevation() == height
						|| grid[tileLeft[0]] [tileLeft[1]].getElevation() == height 
						|| grid[tileRight[0]] [tileRight[1]].getElevation() == height)
				{
					//generate tile with high chance
					if(random.nextInt(100) < (chance / 0.8) * 100)
					{
						grid[x][y].setElevation(height);
					}
					//else generate tile with normal chance
				} else
				{
					if(random.nextInt(100) < chance * 100)
					{
						grid[x][y].setElevation(height);
					}
				}
			} 
		}
	}
}