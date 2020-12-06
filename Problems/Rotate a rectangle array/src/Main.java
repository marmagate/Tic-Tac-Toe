import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int[][] twoDimArray = new int[scanner.nextInt()][scanner.nextInt()];
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int k = 0; k < twoDimArray[i].length; k++) {
                twoDimArray[i][k] = scanner.nextInt();
            }
        }

        int[][] twoDimArrayTurned = new int[twoDimArray[0].length][twoDimArray.length];
        int elem;

        for (int counter = 0; counter < twoDimArrayTurned.length; counter++) {
            elem = twoDimArrayTurned[0].length - 1;
            for (int innerCounter = 0; innerCounter < twoDimArrayTurned[counter].length; innerCounter++) {
                twoDimArrayTurned[counter][innerCounter] = twoDimArray[elem][counter];
                elem -= 1;
            }
        }


        for (int j = 0; j < twoDimArrayTurned.length; j++) {
            System.out.println(Arrays.toString(twoDimArrayTurned[j])
                    .replace(",", "").replace("[", "")
                            .replace("]", ""));
        }
    }
}