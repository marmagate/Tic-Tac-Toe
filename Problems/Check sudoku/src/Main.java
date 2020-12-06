import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int fullSize = size * size;
        Boolean[][][] matrix = new Boolean[fullSize][fullSize][3];

        for (int i = 0; i < fullSize; i++) {
            for (int j = 0; j < fullSize; j++) {
                int num = scanner.nextInt();
                if (num > fullSize || num < 1) {
                    System.out.println("NO");
                    return;
                }
                num--;
                int square = i / size + j / size * size;

                if (matrix[i][num][0] != null || matrix[j][num][1] != null || matrix[square][num][2] != null) {

                    System.out.println("NO");
                    return;
                }
                matrix[i][num][0] = true;
                matrix[j][num][1] = true;
                matrix[square][num][2] = true;
            }
        }
        System.out.println("YES");
    }
}