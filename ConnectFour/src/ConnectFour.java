import java.util.Scanner;

public class ConnectFour {

    private char[][] gameBoard = new char[6][7];
    private String player1 = "";
    private String player2 = "";
    private char play1 =' ';
    private char play2 =' ';
    private boolean isGameRunning = true;
    private boolean laneIsFull = true;
    private Scanner sc = new Scanner(System.in);
    private String userInput;
    private boolean hasDecided=false;
    private int gameTurn=0;
    private int column = -1;
    private int row = 0;
    private int playerTurn = 1;

    public void startGame() {
        while (hasDecided==false) {
            System.out.println("Player 1, please select a colour. [red] or [yellow]");
            userInput = sc.nextLine().toLowerCase();
            if(userInput.equals("red") || userInput.equals("yellow"))
            {
                hasDecided=true;
            }
        }
        if (player1.equals("red")) {
            player2 = "yellow";
            play1 = 'r';
            play2 ='y';
        } else {
            player2 = "red";
            play1 ='y';
            play2 ='r';
        }

        System.out.println("Player 2, has the colour "+player2);
        populateTable();

        while (isGameRunning)
        {
            playerTurn = (playerTurn+1)%2;
            drawGrid();
            while (column>6||column<0) {
                System.out.println("\nPlayer " + (playerTurn+1) + " please select a column.");
                userInput = sc.nextLine();
                try {
                    column = (Integer.parseInt(userInput))-1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //for the whole column
            for (int i = 5; i >= 0 ; i--) {
                //check for empty space
                if(gameBoard[i][column]=='.')
                {
                    row=i;
                    //if player 1
                    if (playerTurn == 0)
                    {
                        laneIsFull = false;
                        setTable(play2, i, column);
                        break;
                    }
                    else {
                        //else player 2
                        laneIsFull = false;
                        setTable(play1, i, column);
                        break;
                    }
                }
            }
            if (laneIsFull)
            {
                playerTurn--;
                System.out.println("That lane is full try again.");
            }
            else
            {
                gameTurn++;
                laneIsFull = true;
                if (playerTurn ==0) {
                    if (wonGame(row,column,play2)) {
                        isGameRunning = false;
                    }
                }else {
                    if (wonGame(row,column,play1)) {
                        isGameRunning = false;
                    }
                }
            }
            column =-1;
        }
    }

    private boolean wonGame(int row,int column, char playerChar)
    {
        //<editor-fold desc="vertical win">
        //while still on board and current chip is players
        int count = 0;
        int i = row;
        while (i<=5 && gameBoard[i][column]==playerChar)
        {
            //increase count
            count++;
            //check next chip
            i++;
            if (count ==4)
            {
                drawGrid();
                System.out.println("Player "+(playerTurn+1)+" has won on " +gameTurn);
                return true;
            }
        }
        //</editor-fold>

        //<editor-fold desc="Horizontal win">
        count =0;
        i=0;
        //while still on board
        while (i<7)
        {
            //if current chip = player colour
            if (gameBoard[row][i]==playerChar)
            {
                //increase count
                count++;
                //check next chip
                if(count==4)
                {
                    drawGrid();
                    System.out.println("Player "+(playerTurn+1)+" has won on " +gameTurn);
                    return true;
                }
            }
            i++;
        }
        //</editor-fold>


        //<editor-fold desc="Diagonal up/right">
        count=0;
        i=row;
        int j = column;
        while (i<5 &&j>0)
        {
            i++;
            j--;
        }
        while (i>0 && j<7)
        {
            if(gameBoard[i][j]==playerChar)
            {
                count++;
                if(count==4)
                {
                    drawGrid();
                    System.out.println("\nPlayer "+(playerTurn+1)+" has won on " +gameTurn);
                    return true;
                }
            }else
            {
                count =0;
            }
            i--;
            j++;
        }
        //</editor-fold>


        //<editor-fold desc="Diagonal up/left">
        count=0;
        i=row;
        j = column;
        while (i<5 &&j<7)
        {
            i++;
            j++;
        }
        while (i>0 && j>0)
        {
            if(gameBoard[i][j]==playerChar)
            {
                count++;
                if(count==4)
                {
                    drawGrid();
                    System.out.println("\nPlayer "+(playerTurn+1)+" has won on " +gameTurn);
                    return true;
                }
            }else
            {
                count =0;
            }
            i--;
            j--;
        }
        //</editor-fold>


        return false;
    }

    private void populateTable()
    {
        for (int i =0;i<6;i++)
        {
            for(int j = 0; j<7 ; j++)
            {
                gameBoard[i][j] = '.';
            }
        }
    }

    private void setTable(char character, int r, int c)
    {
        gameBoard[r][c] = character;
    }

    private void drawGrid()
    {
        System.out.print(" abcdefg");
        for (int i =0;i<6;i++)
        {
            System.out.print("\n"+(i+1));
            for(int j = 0; j<7 ; j++)
            {
                System.out.print(gameBoard[i][j]);
            }
        }
    }
}
