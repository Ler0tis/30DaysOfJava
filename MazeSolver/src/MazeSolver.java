import java.util.LinkedList;

public class MazeSolver {
	
	static int [][] maze = {
			{1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0},
			{0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1},
			{1, 1, 1, 2, 0, 1, 0, 1, 0, 1, 0},
			{0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0},
			{0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 1}
	};
	
	// 0 = wall
	// 1 = path
	// 2 = destination
	
	static LinkedList<Position> path = new LinkedList<Position>();
	
	// Starting position based on Y and X
	public static void main(String[] args) {
		Position p = new Position(4, 8);
		path.push(p);
	
		
		while(true) {
			int y = path.peek().y;
			int x = path.peek().x;
			// Update the maze for the path to a wall 
			maze[y][x] = 0;
			
			
			// Down
			if(isValid(y+1, x)) {
				if(maze[y+1][x] == 2) {
					System.out.println("Moved down. You won!");
					return;
				} else if(maze[y+1][x] == 1) {
					System.out.println("Moved down");
					path.push(new Position(y+1, x));
					continue;
				}
			}
			
			// Left
			if(isValid(y, x-1)) {
				if(maze[y][x-1] == 2) {
					System.out.println("Moved left. You won!");
					return;
				} else if(maze[y][x-1] == 1) {
					System.out.println("Moved left");
					path.push(new Position(y, x-1));
					continue;
				}
			}
			
			// Up
			if(isValid(y-1, x)) {
				if(maze[y-1][x] == 2) {
					System.out.println("Moved up. You won!");
					return;
				} else if(maze[y-1][x] == 1) {
					System.out.println("Moved up");
					path.push(new Position(y-1, x));
					continue;
				}
			}
			
			// Right
			if(isValid(y, x+1)) {
				if(maze[y][x+1] == 2) {
					System.out.println("Moved right. You won!");
					return;
				} else if(maze[y][x+1] == 1) {
					System.out.println("Moved right");
					path.push(new Position(y, x+1));
					continue;
				}
			}

			
			path.pop();
			System.out.println("Moved back");
			if(path.size() <= 0) {
				System.out.println("No path");
				return;
			}
			
		}
		
	}
	
	public static boolean isValid(int y, int x) {
		if(y < 0 ||
			y >= maze.length ||
			x < 0 ||
			x >= maze[y].length)
		{
			return false;
		}
		return true;
}
}
	