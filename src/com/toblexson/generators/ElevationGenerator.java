package com.toblexson.generators;

import java.util.Random;

import com.toblexson.reference.Values;
import com.toblexson.tiles.ElevationTile;

public class ElevationGenerator 
{
	ElevationTile[][] grid;
	Random random = new Random();

	public ElevationGenerator(ElevationTile[][] grid)
	{
		this.grid = grid;
		addElevation();
	}

	private void addElevation()
	{
		//Basic chance 
		double chance = 0.5;

		//0 = x, 1 = y
		int[] tileAbove = new int[2];
		int[] tileBelow = new int[2];
		int[] tileLeft = new int[2];
		int[] tileRight = new int[2];

		for(int a = 0; a < Values.maxX; a++)
		{
			for(int b = 0; b < Values.maxY; b++)
			{
				//add depressions (-10) in sections with a higher chance of them generating next to other depressions
				tileAbove[0] = a;
				tileAbove[1] = b - 1;

				tileBelow[0] = a;
				tileBelow[1] = b + 1;

				tileLeft[0] = a - 1;
				tileLeft[1] = b;

				tileRight[0] = a + 1;
				tileRight[1] = b;

				//check if tile* is inside the range of the array
				if(random.nextInt(100) < (chance / 10) * 100)
				{
					grid[a][b].setElevation(-10);
				}
				GenSame(tileAbove, tileBelow, tileLeft, tileRight, chance, a, b, 1, -10);
				
				//add heights (10) with a higher chance of generating next to this height and a lower chance of generating next to 
				//heights of the lesser height
				
				//need to add GenSame and GenDiff
				if(random.nextInt(100) < (chance / 3) * 100)
				{
					grid[a][b].setElevation(10);
				}
				GenDiff(tileAbove, tileBelow, tileLeft, tileRight, chance, a, b, 1, 10);
				GenSame(tileAbove, tileBelow, tileLeft, tileRight, chance, a, b, 3, 10);
				
				//add heights(20)
				//add heights (30)
				//add heights (40)
				//add heights (50)
				//System.out.println(grid[a][b].getElevation());
			}
		}
	}
	private void GenSame(int[] tileAbove, int[] tileBelow, int[] tileLeft, int[] tileRight, double chance, int a, int b, int iterations, int height) 
	{
		for(int x = 0; x <= iterations; x++)
		{
			if(tileAbove[1] < Values.maxY && tileAbove[1] >= 0
					&& tileBelow[1] < Values.maxX && tileBelow[1] >= 0
					&& tileLeft[0] < Values.maxY && tileLeft[0] >= 0
					&& tileRight[0] < Values.maxY && tileRight[0] >= 0)
			{
				//checks to see if neighbouring tiles are the same elevation
				if(grid[tileAbove[0]] [tileAbove[1]].getElevation() == height
						|| grid[tileBelow[0]] [tileBelow[1]].getElevation() == height
						|| grid[tileLeft[0]] [tileLeft[1]].getElevation() == height
						|| grid[tileRight[0]] [tileRight[1]].getElevation() == height)
				{
					//System.out.println("Tile has -10 elevation near");
					if(random.nextInt(100) < (chance / 2.5) * 100)
					{
						grid[a][b].setElevation(height);
					}
				} 
			}	
		}
	}
	
	private void GenDiff(int[] tileAbove, int[] tileBelow, int[] tileLeft, int[] tileRight, double chance, int a, int b, int iterations, int height)
	{
		for(int x = 0; x < iterations; x++)
		{
			if(tileAbove[1] < Values.maxY && tileAbove[1] >= 0
					&& tileBelow[1] < Values.maxX && tileBelow[1] >= 0
					&& tileLeft[0] < Values.maxY && tileLeft[0] >= 0
					&& tileRight[0] < Values.maxY && tileRight[0] >= 0)
			{
				//checks to see if neighbouring tiles are 20 less
				if(grid[tileAbove[0]] [tileAbove[1]].getElevation() == height - 20
						|| grid[tileBelow[0]] [tileBelow[1]].getElevation() == height - 20
						|| grid[tileLeft[0]] [tileLeft[1]].getElevation() == height - 20
						|| grid[tileRight[0]] [tileRight[1]].getElevation() == height - 20)
				{
					if(random.nextInt(100) < (chance) * 100)
					{
						grid[a][b].setElevation(height);
					}
				}
			}
		}
	}
}
