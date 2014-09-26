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
		//Chance when next to the same elevation of tile 
		double chanceSame = 0.75;
		//Chance when next to a different elevation of tile
		double chanceDifferent = 0.25;
		
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
				
				if(random.nextInt(10) == (chance * 10)) grid[a][b].setElevation(-10);
				//add heights (10) with a higher chance of generating next to this height and a lower chance of generating next to 
				//heights of the lesser height
				//add heights(20)
				//add heights (30)
				//add heights (40)
				//add heights (50)
				System.out.println(grid[a][b].getElevation());
			}
		}
	}
}
