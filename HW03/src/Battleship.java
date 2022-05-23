
import java.util.Scanner;

public class Battleship {

public static void main(String[] args) {

    //VARIABLES
    char [][] boardP1 = new char [5][5];
    char [][] boardP2 = new char [5][5];
    char [][] gboardP1 = new char [5][5];
    char [][] gboardP2 = new char [5][5];
    int p1Hits = 0;
    int p2Hits = 0;
    boolean flag;
    boolean stillplaying;



    //fill board with dashes
    for (int i=0; i<5; i++){
        for(int j=0; j<5; j++){
            boardP1[i][j]='-';
            boardP2[i][j]='-';
            gboardP1[i][j]='-';
            gboardP2[i][j]='-';
        }
    }
    Scanner input = new Scanner(System.in);
    int firstNumber = 0;
    int secondNumber = 0;
    System.out.println("Welcome to Battleship!");


    //PLAYER 1 Board
    System.out.println("PLAYER 1, ENTER YOUR SHIPS¡¯ COORDINATES.");
    for (int i=1; i<=5;i++){
        System.out.println("Enter ship "+i+" location:");
        flag=true;
        while(flag){
            if (input.hasNextInt())
                firstNumber = input.nextInt();
            if (input.hasNextInt())
                secondNumber = input.nextInt();
            if((firstNumber >=5) ||( secondNumber >=5) ){
                System.out.println("Invalid coordinates. Choose different coordinates.");
                System.out.println("Enter ship "+i+" location:");
            }else if(boardP1[firstNumber][secondNumber]=='@'){
                System.out.println("You already have a ship there. Choose different coordinates.");
                System.out.println("Enter ship "+i+" location:");
            }else{
                flag=false;
            }
        }
        boardP1[firstNumber][secondNumber]='@';
    }
    printBattleShip(boardP1);
    int x = 0;
    do{System.out.println(); x ++;} while (x<100);


    //PLAYER 2 Board
    System.out.println("PLAYER 2, ENTER YOUR SHIPS¡¯ COORDINATES.");
    for (int i=1; i<=5;i++){
        System.out.println("Enter ship "+i+" location:");
        flag=true;
        while(flag){
            if (input.hasNextInt())
                firstNumber = input.nextInt();
            if (input.hasNextInt())
                secondNumber = input.nextInt();
            if((firstNumber >=5) ||( secondNumber >=5) ){
                System.out.println("Invalid coordinates. Choose different coordinates.");
                System.out.println("Enter ship "+i+" location:");
            }else if(boardP2[firstNumber][secondNumber]=='@'){
                System.out.println("You already have a ship there. Choose different coordinates.");
                System.out.println("Enter ship "+i+" location:");
            }else{
                flag=false;
            }
        }
        boardP2[firstNumber][secondNumber]='@';
    }
    printBattleShip(boardP2);
    int x2 = 0;
    do{System.out.println(); x2 ++;} while (x2<100);

    //Game time
    stillplaying=true;
    while (stillplaying) {
        System.out.println("Player 1, enter hit row/column:");
        flag=true;
        while(flag) {
            if (input.hasNextInt()) {
                firstNumber = input.nextInt();
            }
            if (input.hasNextInt()) {
                secondNumber = input.nextInt();
                if ((firstNumber >= 5) || (secondNumber >= 5)) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.println("Player 1, enter hit row/column:");
                    flag = true;
                } else if (gboardP1[firstNumber][secondNumber] == 'X' || gboardP1[firstNumber][secondNumber] == '0') {
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                    System.out.println("Player 1, enter hit row/column:");
                    flag = true;
                } else {
                    if (boardP2[firstNumber][secondNumber] == '@') {
                        System.out.println("PLAYER 1 HIT PLAYER 2¡¯s SHIP!");
                        gboardP1[firstNumber][secondNumber] = 'X';
                        p1Hits++;
                        flag = false;
                    } else {
                        System.out.println("PLAYER 1 MISSED!");
                        gboardP1[firstNumber][secondNumber] = 'O';
                        flag = false;

                    }
                }
            }
        }
        if (p1Hits==5){
            flag=false;
            stillplaying = false;
            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT¡¯S SHIPS!");
            System.out.println("Final boards:");
            System.out.println();
            
            for (int row = 0; row < 5; row++) {
                 for (int column = 0; column < 5; column++) {
                     if ((boardP1[row][column] =='@')&&(gboardP2[row][column]=='-')){
                         gboardP2[row][column] ='@';
                     }
                 }
            }
            
            printBattleShip(gboardP2);
            System.out.println();
            printBattleShip(gboardP1);
        } else if ((p1Hits<5) && (p2Hits<5)){
            printBattleShip(gboardP1);
            System.out.println();
            System.out.println("Player 2, enter hit row/column:");
            flag = true;
        }
        while(flag) {
            if (input.hasNextInt())
                firstNumber = input.nextInt();
            if (input.hasNextInt()) {
                secondNumber = input.nextInt();
                if ((firstNumber >= 5) || (secondNumber >= 5)) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                    System.out.println("Player 2, enter hit row/column:");
                    flag = true;
                } else if (gboardP2[firstNumber][secondNumber] == 'X' || gboardP2[firstNumber][secondNumber] == '0') {
                    System.out.println("You already fired on this spot. Choose different coordinates.");
                    System.out.println("Player 2, enter hit row/column:");
                    flag = true;
                } else if (boardP1[firstNumber][secondNumber] == '@') {
                    System.out.println("PLAYER 2 HIT PLAYER 1¡¯s SHIP!");
                    gboardP2[firstNumber][secondNumber] = 'X';
                    p2Hits++;
                    flag = false;
                } else {
                    System.out.println("PLAYER 2 MISSED!");
                    gboardP2[firstNumber][secondNumber] = 'O';
                    flag = false;
                }
            }
        }
        if (p2Hits==5){
            flag=false;
            stillplaying = false;
            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT¡¯S SHIPS!");
            System.out.println("Final boards:");
            System.out.println();
            printBattleShip(gboardP2);
            System.out.println();
            /////
            for (int row = 0; row < 5; row++) {
                for (int column = 0; column < 5; column++) {
                    if ((boardP2[row][column] =='@')&&(gboardP1[row][column]=='-')){
                        gboardP1[row][column] ='@';
                    }
                }
            }
           
            printBattleShip(gboardP1);
        } else if ((p1Hits<5) && (p2Hits<5)){
            printBattleShip(gboardP2);
            System.out.println();
            //System.out.println("Player 1, enter hit row/column:");
            flag = true;
        }
    }
    input.close();
}




// Use this method to print game boards to the console.
private static void printBattleShip(char[][] player) {
    System.out.print("  ");
    for (int row = -1; row < 5; row++) {
        if (row > -1) {
            System.out.print(row + " ");
        }
        for (int column = 0; column < 5; column++) {
            if (row == -1) {
                System.out.print(column + " ");
            } else {
                System.out.print(player[row][column] + " ");
            }
        }
        System.out.println("");
    }
}
}