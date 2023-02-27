import java.util.Arrays;

public class DiceRolls {
    public static void print2Ddouble(double arr[][]){
        for (double[] row : arr){
            System.out.println(Arrays.toString(row));
      }
    }

    public static int diceRoll(){
                
        return (int) (Math.random() * 6) +1;

    }

    public static double twoD6Probabilities(){
        double[][] nums = new double[2][13];

        int trialCount = 0;
        for (int num = 0; num <= 1000000; num++){
            int roll1 = diceRoll();
            int roll2 = diceRoll();
            int solution = roll1 + roll2;
            trialCount ++;
            nums[0][solution]++;
        }
        for (int num = 0; num < nums[0].length; num++){
            nums[1][num] = (double) (nums[0][num] / trialCount);
        }
        print2Ddouble(nums);

        return 0.0;
    }
    public static void main(String[] args) {
        twoD6Probabilities();

        int[] frequencies = new int[13];
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                frequencies[i+j]++;
            }
        }
        
        double[] probabilities = new double[13];
        for (int k = 1; k <= 12; k++) {
            probabilities[k] = frequencies[k] / 36.0;
        }

        System.out.println("frequencies: " + Arrays.toString(frequencies));
        System.out.println("probabilities: " + Arrays.toString(probabilities));



    }
}
