package com.codegym.games.minesweeper;
import com.codegym.engine.cell.*;


public class MinesweeperGame extends Game {
}
/*Let's write the entertaining Minesweeper game.

Rules of the game:

The playing field is divided into adjacent cells (squares), some of which contain "mines".
The objective of the game is to clear the field, i.e. reveal all cells that don't contain mines.
If a cell with a mine is revealed, the game is lost. The mines are placed randomly.
If a revealed cell doesn't have a mine, a number appears in it, indicating how many "mined" cells are adjacent to the revealed cell. You can use these numbers to calculate the location of mines.
If the adjacent cells also do not contain mines, an "unmined" region is revealed up to cells that do have numbers.
Cells that you believe to contain mines can be flagged so you don't accidentally reveal them. The number of flags is equal to the number of mines on the game board.
If "unmined" cells are revealed, then the game is won.
Now let's start implementing the game:

To begin, create a MinesweeperGame class, which will implement the logic of the game. This class must inherit the Game class, which is part of CodeGym's cool "game engine".

This and other engine classes are located in the com.codegym.engine.cell package. To use them, the MinesweeperGame class must include the following import statement: import com.codegym.engine.cell.*;

If you did everything right, you will see the playing field when you start the application.

Wymagania:
•	There must be a public MinesweeperGame class.
•	The MinesweeperGame class must inherit the Game class.
•	The MinesweeperGame class must have a statement that imports the entire contents of the com.codegym.engine.cell package
*/


package com.codegym.games.minesweeper;
import com.codegym.engine.cell.*;


public class MinesweeperGame extends Game {
    
    private static final int SIDE = 9;
    
    public void initialize()
    {
        setScreenSize(SIDE, SIDE);
    }
}

/*
Our playing field is kind of small, don't you think? It should be 9x9 cells:

1) There is a setScreenSize(int, int) method to set the size of the field
2) This method takes width and height arguments (the number of cells wide and high)
3) the dimensions of the field will be used frequently, so it's convenient to put them in a constant named SIDE
4) the result should be a call like this: initialize method()
6) this means that the initialize() method must be declared in the MinesweeperGame class

Check the results of your work — run the program.

Wymagania:
•	The SIDE variable must be declared in the MinesweeperGame class.
•	The SIDE variable must be private, static, and final, and must be an int.
•	The SIDE variable must be initialized to 9 when it is declared.
•	There should be a public void initialize() method in the MinesweeperGame class.
•	The Game class's setScreenSize(int, int) method must be called with arguments (SIDE, SIDE) in the initialize() method.
 */
