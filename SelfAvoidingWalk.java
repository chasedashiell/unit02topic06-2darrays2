public class SelfAvoidingWalk {

    private static boolean walk(int xlen, int ylen){
        //true == made it out, false == did not make it out

        //setting the position to the middle of the board
        int positionX = xlen/2;
        int positionY = ylen/2;
        boolean[][] grid = new boolean[xlen][ylen];
        

        //gameloop
        while(positionX >= 0 && positionX < xlen && positionY >= 0 && positionY < ylen && grid[positionX][positionY] == false){
            
            //moving the character
            grid[positionX][positionY] = true;
            double randNum = Math.random();
            if(randNum <= 0.25){
                positionX += 1;
            } else if(randNum <= 0.5){
                positionX -= 1;
            } else if(randNum <= 0.75){
                positionY -= 1;
            } else {
                positionY += 1;
            }
        }
        
        //finding weither he escaped or not
        if(positionX < 0 || positionX >= xlen || positionX < 0 || positionY >= ylen){
                return true;
            }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(walk(6,6));
    }
}