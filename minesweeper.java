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

package com.codegym.games.minesweeper;
import com.codegym.engine.cell.*;


public class MinesweeperGame extends Game {
    
    private static final int SIDE = 9;
    private GameObject[][]gameField = new GameObject[SIDE][SIDE];
    
    public void initialize()
    {
        setScreenSize(SIDE, SIDE);
        createGame();
    }
    //gameField[x][y] = new GameObject(x, y);
    
    private void createGame()
    {
        for(int y = 0; y < SIDE; y++)
        {
            for(int x = 0; x < SIDE; x++)
            {
                gameField[y][x] = new GameObject(x, y);
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }
}

/*
Minesweeper is aptly named. The player has to deal with mines, though maybe it would be best for the player to stay far away from them :)

Let's add these mines to the game. To do this, we'll adapt the GameObject class to account for the fact that a cell can be a mine (by adding the isMine flag).

Don't create a new constructor: editing the existing constructor will suffice.

Additionally, when creating the cells, add code that generates mines with a probability of 10%. The easiest way is to use the Game class's getRandomNumber(int n) method, which returns a random number from 0 to n-1 inclusive. Therefore, the probability of generating a certain number is 1/n.

And don't forget to count the number of generated mines in the MinesweeperGame class.

Once you've done all that, run the program and check that nothing is broken :)

Requirements:
•	The GameObject class must have a public boolean isMine field.
•	The GameObject class must have one constructor with (int, int, boolean) parameters that are used to initialize the x, y, and isMine fields, in that order.
•	There must be a private int countMinesOnField variable in the MinesweeperGame class.
•	When cells are created in the createGame() method, you should randomly determine whether each cell will have a mine. Use the Game class's getRandomNumber(int) method with the argument 10.
•	After the createGame() method is executed, the countMinesOnField variable should be assigned the value of the number of mines in the field.
*/
package com.codegym.games.minesweeper;

import com.codegym.engine.cell.Color;
import com.codegym.engine.cell.Game;

public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField;

    @Override
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }

    private void createGame() {
        for (int y = 0; y < SIDE; y++) {
            for (int x = 0; x < SIDE; x++) {
                int randomNumber = getRandomNumber(10);
                boolean isMine = randomNumber < 1;
                if (isMine) {
                    countMinesOnField++;
                }
                gameField[y][x] = new GameObject(x, y, isMine);
                setCellColor(x, y, Color.ORANGE);
            }
        }
    }
}

package com.codegym.games.minesweeper;

public class GameObject {
    public int x;
    public int y;
    public boolean isMine;

    GameObject(int x, int y, boolean isMine) {
        this.x = x;
        this.y = y;
        this.isMine = isMine;
    }
}
/* 

We need to store the state of the playing field's cells somewhere. To do this, create a matrix (two-dimensional array) with the dimensions of the playing field. Populate the matrix with GameObject objects using this formula:

gameField[y][x] = new GameObject(x, y);
Now let's display all the cells on the screen.
The Game class's setCellColor(int, int, Color) method, whose parameters are the cell coordinates and color, will help us accomplish this.
Call it for each cell and pass the cell coordinates and any color (for example, Color.ORANGE) as arguments.
We suggest putting the logic to draw the matrix into a separate createGame() method, which we then call from the initialize method(). Run the program and see what happens.

Hint: use loops to call the setCellColor(int, int, Color) method for each cell of the matrix.

Requirements:
The MinesweeperGame class must have a private GameObject[][] gameField matrix (two-dimensional array) whose dimensions are SIDExSIDE.
The MinesweeperGame class must have a private void createGame() method.
In the createGame method(), you need to populate each cell of the gameField array with a new GameObject object with corresponding x and y coordinates.
In the createGame() method, for each cell in the gameField array, you need to call the setCellColor(int, int, Color) method with the following arguments: x and y coordinates, as well as any color (for example, Color.ORANGE).
The createGame() method must be called in the initialize() method.
*/
