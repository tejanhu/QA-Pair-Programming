package task;

public class SpiralGrid {
    public void makeSpiral(int input)
    {
        int[][] grid = new int[input][input];
        int row =0;
        int col=0;
        String direction ="right";
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                grid[i][j] = 0;
            }
        }
        for (int i = 1; i <= (input*input); i++) {
            switch(direction) {
                case "right":
                    {
                        if(col<input)
                        {
                            grid[row][col] = i;
                            col++;
                            if(col<input&&grid[row][col]!=0) {
                                col--;
                                row++;
                                direction = "down";
                            }
                            break;
                        }
                        else
                        {
                            col--;
                            row++;
                            direction ="down";
                        }
                    }
                case "down":
                    {
                        if(row<input)
                        {
                            grid[row][col] = i;
                            row++;
                            if(row<input&&grid[row][col]!=0) {
                                col--;
                                row--;
                                direction = "left";
                            }
                            break;
                        }
                        else
                        {
                            row--;
                            col--;
                            direction ="left";
                        }
                    }
                case "left":
                    {
                        if(col>=0)
                        {
                            grid[row][col] = i;
                            col--;
                            if(col>=0&&grid[row][col]!=0) {
                                col++;
                                row--;
                                direction = "up";
                            }
                            break;
                        }
                        else
                        {
                            col++;
                            row--;
                            direction ="up";
                        }
                    }
                case "up":
                    {
                        if(row>=0)
                        {
                            grid[row][col] = i;
                            row--;
                            if(row>=0&&grid[row][col]!=0) {
                                col++;
                                row++;
                                direction = "right";
                            }
                            break;
                        }
                    }
                default:{break;}
            }
        }
        printArray(input,grid);
    }

    private void printArray(int input,int[][] grid)
    {
        for (int i = 0; i < input; i++) {
            System.out.println();
            for (int j = 0; j < input; j++) {
                System.out.print(" "+ grid[i][j]);

                if(grid[i][j]<10&&input>3) {
                    System.out.print(" ");
                }
                if(grid[i][j]<100&&input>9) {
                    System.out.print(" ");
                }
                if(grid[i][j]<1000&&input>31) {
                    System.out.print(" ");
                }

            }
        }
    }
}
