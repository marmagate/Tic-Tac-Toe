import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] array = new int[len];

        for (int i = 0; i < len; i++) {
            array[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        boolean isNext = true;
        int prevElem = 0;

        for (int elem : array) {
            if (elem == n && prevElem == m) {
                isNext = false;
                break;
            } else if (elem == m && prevElem == n) {
                isNext = false;
                break;
            } else {
                isNext = true;
            }
            prevElem = elem;
        }
        System.out.println(isNext);

    }
}