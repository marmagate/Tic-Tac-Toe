package tictactoe;

import java.util.Scanner;

public class Main {
    final static char[][] field = new char[3][3];
    final static Scanner scanner = new Scanner(System.in);
    static boolean isWinner = false;
    static char winner;
    static boolean isDraw = false;
    static boolean winnerX = false;
    static boolean winnerO = false;
    static boolean isGameFinished;
    static boolean isPossible = true;

    public static void main(String[] args) {

        // filling the field
        for (int i = 0; i < 3; i++) {
            for (int k = 0; k < 3; k++) {
                field[i][k] = '_';
            }
        }

        showField();
        outerloop:
        while (!isWinner && !isDraw) {
            userInputX();
            showField();
            checkWinner();
            checkGameFinishedOrDraw();
            checkDraw();
            showResult();
            if (isWinner || isDraw) {
                break outerloop;
            }
            userInputO();
            showField();
            checkWinner();
            checkGameFinishedOrDraw();
            checkDraw();
            showResult();
            if (isWinner || isDraw) {
                break outerloop;
            }
        }
    }

    static void userInputX() {
        String userInputStr;
        String userInputReplaced;
        String userByXStr;
        String userByYStr;
        boolean isNumbers = true;
        System.out.print("Enter the coordinates: ");
        userInputStr = scanner.nextLine();
        // check for isDigit
        userInputReplaced = userInputStr.replace(" ", "");
        for (int i = 0; i < userInputReplaced.length(); i++) {
            if (!Character.isDigit(userInputReplaced.charAt(i))) {
                isNumbers = false;
            }
        }

        while (!isNumbers) {
            isNumbers = true;
            System.out.println("You should enter numbers!");
            System.out.print("Enter the coordinates: ");
            userInputStr = scanner.nextLine();
            userInputReplaced = userInputStr.replace(" ", "");
            for (int i = 0; i < userInputReplaced.length(); i++) {
                if (!Character.isDigit(userInputReplaced.charAt(i))) {
                    isNumbers = false;
                }
            }
        }

        String[] userInputStrArr = userInputStr.split(" ");
        userByXStr = userInputStrArr[0];
        userByYStr = userInputStrArr[1];

        // continue if digits
        // turn coordinates to Int
        int userByX = Integer.parseInt(userByXStr);
        int userByY = Integer.parseInt(userByYStr);
        // check for 1-3 range
        if (userByX < 1 || userByX > 3 || userByY < 1 || userByY > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            userInputX();
            return;
        }
        // fucked up objective logic
        userByX--;
        switch (userByY) {
            case 1:
                userByY = 2;
                break;
            case 2:
                userByY = 1;
                break;
            case 3:
                userByY = 0;
                break;
        }

        if (field[userByY][userByX] != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            userInputX();
            return;
        } else {
            field[userByY][userByX] = 'X';
        }
    }

    static void userInputO() {
        String userInputStr;
        String userInputReplaced;
        String userByXStr;
        String userByYStr;
        boolean isNumbers = true;
        System.out.print("Enter the coordinates: ");
        userInputStr = scanner.nextLine();
        // check for isDigit
        userInputReplaced = userInputStr.replace(" ", "");
        for (int i = 0; i < userInputReplaced.length(); i++) {
            if (!Character.isDigit(userInputReplaced.charAt(i))) {
                isNumbers = false;
            }
        }

        while (!isNumbers) {
            isNumbers = true;
            System.out.println("You should enter numbers!");
            System.out.print("Enter the coordinates: ");
            userInputStr = scanner.nextLine();
            userInputReplaced = userInputStr.replace(" ", "");
            for (int i = 0; i < userInputReplaced.length(); i++) {
                if (!Character.isDigit(userInputReplaced.charAt(i))) {
                    isNumbers = false;
                }
            }
        }

        String[] userInputStrArr = userInputStr.split(" ");
        userByXStr = userInputStrArr[0];
        userByYStr = userInputStrArr[1];

        // continue if digits
        // turn coordinates to Int
        int userByX = Integer.parseInt(userByXStr);
        int userByY = Integer.parseInt(userByYStr);
        // check for 1-3 range
        if (userByX < 1 || userByX > 3 || userByY < 1 || userByY > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            userInputO();
            return;
        }
        // fucked up objective logic
        userByX--;
        switch (userByY) {
            case 1:
                userByY = 2;
                break;
            case 2:
                userByY = 1;
                break;
            case 3:
                userByY = 0;
                break;
        }

        if (field[userByY][userByX] != '_') {
            System.out.println("This cell is occupied! Choose another one!");
            userInputO();
            return;
        } else {
            field[userByY][userByX] = 'O';
        }
    }

    static void showField() {
        System.out.print("---------");
        for (int i = 0; i < field.length; i++) {
            System.out.println();
            System.out.print("|");
            for (int k = 0; k < field[i].length; k++) {
                System.out.print(" " + field[i][k]);
                if (k == 2) {
                    System.out.print(" |");
                }
            }
        }
        System.out.println();
        System.out.println("---------");
    }

    static void checkWinner() {
        // horizontal check
        outerloop:
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < 1; k++) {
                if (field[i][k] == field[i][k + 1] && field[i][k] == field[i][k+2] && field[i][k] != '_') {
                    isWinner = true;
                    winner = field[i][k];
                    if (field[i][k] == 'X') {
                        winnerX = true;
                    } else {
                        winnerO = true;
                    }
                }
            }
        }
        // vertical check
        outerloop:
        for (int i = 0; i < 1; i++) {
            for (int k = 0; k < field.length; k++) {
                if (field[i][k] == field[i+1][k] && field[i][k] == field[i+2][k] && field[i][k] != '_') {
                    isWinner = true;
                    winner = field[i][k];
                    if (field[i][k] == 'X') {
                        winnerX = true;
                    } else {
                        winnerO = true;
                    }
                }
            }
        }
        // diagonal check
        char middleChar = field[1][1];
        if (middleChar != '_') {
            middleChar = field[1][1];
            if (middleChar == field[0][0] && middleChar == field[2][2] ||
            middleChar == field[0][2] && middleChar == field[2][0]) {
                isWinner = true;
                winner = middleChar;
            }
        }
    }

    static void checkGameFinishedOrDraw() {
        isGameFinished = true;
        outerloop:
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field[i].length; k++) {
                if (field[i][k] == '_') {
                    isGameFinished = false;
                    break outerloop;
                }
            }
        }
    }

    static void checkDraw() {
        if (isGameFinished && !isWinner) {
            isDraw = true;
        }
    }

    static void checkImpossible() {
        if (winnerX && winnerO) {
            isPossible = false;
        }
        int counterX = 0;
        int counterO = 0;
        for (int i = 0; i < field.length; i++) {
            for (int k = 0; k < field[i].length; k++) {
                if (field[i][k] == 'X') {
                    counterX++;
                } else if (field[i][k] == 'O') {
                    counterO++;
                }
            }
        }
        if (counterX - counterO > 1 || counterX - counterO < -1) {
            isPossible = false;
        }
    }

    static void showResult() {
        if (!isPossible) {
            System.out.println("Impossible"); // break;
        } else if (isWinner) {
            System.out.println(winner + " wins");
        } else if (isDraw) {
            System.out.println("Draw");
        }
    }
}