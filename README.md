# pathfinder-library
A pathfinding library in java, using A* algorithm

# What is the library supposed to do currently ?
Pathfinder Library search a path from one point to an other point on a grid, avoiding obstacles like walls in a maze.
The library use A* algorithm to search the best path from a position to an other position

# How to use it ?
There is only one things that you'll have to configure before using it in your own code : You will have to define obstacles on your map.
For this, you have to use the class `Matrix` and the enum `State` defined by the library

## State use
State can take only two values : `Void` or `Obstacle` 
The first one is used to define a point as free, you can walk on it, and the second is used to define an obstacle such as a wall.

## Matrix use
Matrix is a 2D vector array made for an easier use and representation of a grid. You can use it also for other purposes instead of using pathfinding.
Here is an example of creating and use a matrix :

```java
int width = 10;
int height = 10;
Matrix<State> grid = new Matrix<State>(width, height); //create a matrix wich will contain State object

width = grid.getWidth(); //return width of the grid
height = grid.getHeight(); //return height of the grid
int[] size = grid.size(); //return the size of the grid in an array like that : {width, height}

int x = 8, y = 4;
State test = grid.get(x, y); //return the State of the position (x;y)

grid.set(x,y,State.Obstacle); //set the value of the position (x;y) with the value State.Obstacle

width = 5;
height = 5;
Matrix<State> sub = grid.submatrix(width, height); //get a submatrix with a width and height of 5
```

## Reading loop of Matrix
This is how to read or set all position in a matrix easily
```java
Matrix<State> grid = new Matrix<State>(10, 10);
for (int i=0;i<grid.getWidth();i++) {
  for (int k=0;k<grid.getHeight();k++) {
    grid.set(i, k, State.Void);
  }
}
```

## How to use pathfinding now 
To use pathfinding, just define a matrix of state object representing your own maze or map
then proceed as following :
```java
import java.awt.Point;
import java.util.Vector;

Point start = new Point(8,8);
Point destination = new Point(1,1);
PathFinder pf = new PathFinder(grid, start, destination);
Vector<Moves> moves;
try {
	moves = pf.searchPath();
} catch (PathfindingException e) {
	e.printStackTrace();
}
```
First, create the object pathfinder with the map, the start position and the final position
Then use `searchPath` to get a vector of moves that you'll have to do from start point to reach the final position
PathfindingException can be raised, mainly if there is no path leading from the start point to the end point

## How moves work ?
Moves is an enum wich take only four values between : Right, Left, Up, Down.
Each value represents a move on the grid
You can use also some methods from Moves to transform them
```java
Moves mv = Moves.Left; //just an example
int dx = mv.getDx(); //return the real move following x coordinate
int dy = mv.getDy(); //return the real move following y coordinate
/***********************
Moves object are just a simple vector wich have the following value (dx;dy)
***********************/
