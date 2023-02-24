import java.util.Arrays;

import javax.xml.transform.SourceLocator;

public class Minesweeper {

    public static void print2DInt(int arr[][]){
      for (int[] row : arr){
          System.out.println(Arrays.toString(row));
    }
  }
  public static void print2DBool(boolean arr[][]){
    for (boolean[] row : arr){
        System.out.println(Arrays.toString(row));
  }
}
  
    public static boolean[][] makeMinesweeperBoard(int numRows, int numCols, double p){
        boolean[][] solution = new boolean[numRows][numCols];
        for (int row = 0; row < numRows; row++){
            for (int col = 0; col < numCols; col++){
                double rand = Math.random();
                if (p > rand){
                    solution[row][col] = true;
                } else{
                    solution[row][col] = false;
                }
            }
        }
        return solution;
    }

    public static void printMinesweeperBoard(boolean[][] board){
        for (boolean[] row : board){
            System.out.println();
            for (boolean tf : row){
                if (tf){
                    System.out.print('*');
                }else{
                    System.out.print('.');
                }
            }
        }
    }

    public static int[][] makeNeighborBoard(boolean[][] board){
        int[][] solution = new int[board.length][board[0].length];
        for(int row = 0; row < board.length; row++){
            for (int col = 0; col < board[0].length; col++){
                if (board[row][col]){
                    solution[row][col] = -1;
                    if(row != board.length-1 && solution[row+1][col] != 1){
                        solution[row+1][col]++;
                    }
                    if(row != 0 && solution[row-1][col] != 1){
                        solution[row-1][col]++;
                    }
                    if(col != board[0].length-1 && row != board.length-1 && solution[row+1][col+1] != 1 ){
                        solution[row+1][col+1]++;
                    }
                    if(row!=0 && col!=0 && solution[row-1][col-1] != 1){
                        solution[row-1][col-1]++;
                    }
                    if(row != board.length-1 && col != 0 && solution[row+1][col-1] != 1){
                        solution[row+1][col-1]++;
                    }
                    if(col != board[0].length-1 && solution[row][col+1] != 1){
                        solution[row][col+1]++;
                    }
                    if(col != 0 && solution[row][col-1] != 1){
                        solution[row][col-1]++;
                    }
                    if(row != 0 && col != board[0].length-1 && solution[row-1][col+1] != 1){
                        solution[row-1][col+1]++;
                    }

                }
            }
        }
        return solution;
    }
    public static void main(String[] args) {
        boolean[][] arr = makeMinesweeperBoard(3, 3, 0.15);
        print2DBool(arr);
        print2DInt(makeNeighborBoard(arr));

        // [false, true, false]
        // [false, false, true]
        // [false, false, true]
        // [1, 0, 1]
        // [1, 1, 0]
        // [0, 1, -1]
    }
}
