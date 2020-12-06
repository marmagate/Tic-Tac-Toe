import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[][] matrix = new char[4][];

        matrix[0] = scanner.nextLine().toCharArray();
        matrix[1] = scanner.nextLine().toCharArray();
        matrix[2] = scanner.nextLine().toCharArray();
        matrix[3] = scanner.nextLine().toCharArray();

        boolean isPretty = true;

        outerloop:
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int k = 0; k < matrix[i].length - 1; k++) {
                if (matrix[i][k] == matrix[i][k + 1] &&
                    matrix[i][k] == matrix[i + 1][k] &&
                    matrix[i][k] == matrix[i + 1][k + 1]) {
                    isPretty = false;
                    break outerloop;
                } else {
                    isPretty = true;
                }
            }
        }
        System.out.println(isPretty ? "YES" : "NO");
    }
}

