import java.util.Arrays;

public class SelfAvoidingWalk {

    private static int[] walk(int xlen, int ylen){
        //positive == made it out, negative == did not make it out

        //setting the position to the middle of the board
        int positionX = xlen/2;
        int positionY = ylen/2;
        boolean[][] grid = new boolean[xlen][ylen];
        int length = 0;
        int[] solution = new int[3];
        int maxX = 0;
        int maxY = 0;
        //gameloop
        while(positionX >= 0 && positionX < xlen && positionY >= 0 && positionY < ylen && grid[positionX][positionY] == false){
            //moving the character
            grid[positionX][positionY] = true;
            double randNum = Math.random();
            if(randNum <= 0.25){
                positionX += 1;
                length++;
            } else if(randNum <= 0.5){
                positionX -= 1;
                length++;
            } else if(randNum <= 0.75){
                positionY -= 1;
                length++;
            } else {
                positionY += 1;
                length++;
            }

            if(positionX > maxX){
                maxX = positionX;
            }

            if(positionY > maxY){
                maxY = positionY;
            }

        }
        
        //finding weither it escaped or not
        if(positionX < 0 || positionX >= xlen || positionX < 0 || positionY >= ylen){
                solution[0] = length;
            } else{
        solution[0] = -length;
            }
        solution[1] = maxX;

        solution[2] = maxY;

        return solution;
    }

    public static void printPathLengths(int size, int nTrials) {
        int numEscaped = 0;
        int lengthTotal = 0;

        for(int i = 0; i <= nTrials; i++){
            int[] arr = walk(size, size);
            int solution = arr[0];
            int length = Math.abs(solution);
            lengthTotal += length;
            if (solution > 0){
                numEscaped++;
            }
        }
        System.out.println("Average length: " + lengthTotal / nTrials);
        System.out.println("Probability of escaping: " + (double) numEscaped / nTrials);
    }

    public static double deadEndRectangleArea(int size, int nTrials){
        double total = 0;
        for (int i = 0; i < nTrials +1; i++){
            int[] arr = walk(size, size);
            total += (double) arr[1] * arr[2];
        }
        return total / nTrials;
    }

    public static void main(String[] args) {
        printPathLengths(8, 1000);
        System.out.println( deadEndRectangleArea(8, 1000));
    }
}