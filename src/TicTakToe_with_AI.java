//Andrew Bae
//Programmed as part of high school computer science final project in 10th grade

import java.util.Scanner;

public class TicTakToe_with_AI
{
    public static void main(String args[])
            throws java.lang.InterruptedException{

        System.out.println("Welcome to the tic tac toe game!");
        System.out.println("Below are the coordinates you can choose 1-9.");
        System.out.println("For example, if you type in 4, you will take the space in the 2nd row, 1st column");
        System.out.println("You are X's and the computer is O's");
        System.out.println("Good luck!");

        Scanner sc = new Scanner(System.in);
        int[][] instruction = new int[3][3];
        String[][] board = new String[3][3];
        char[][] response = new char[3][3];
        boolean[] spotChoose = new boolean [10];
        boolean play = true, noQuit = true, initializeBoard = true, initializeBoard2 = true, initializeSpot = true;
        boolean userWin = false, compWin = false, noWin = false, userChoose = true;;
        int win;
        int turnNum = 1;

        int row[] = {0,0,0};
        int column[]= {0,0,0};
        int diagonal[] = {0,0};
        int rowC[] = {0,0,0};
        int columnC[]= {0,0,0};
        int diagonalC[] = {0,0};
        int instructionValue = 1, spot = 0;
        int turnLast = 0;

        while(noQuit){
            while(play){ //will keep running while the user wants to keep playing
                for(int x = 0; x < 3; x++){ //initializes the instruction board
                    for(int y = 0; y < 3; y++){
                        instruction[x][y] = instructionValue;
                        instructionValue++;
                    }
                }
                for(int i = 0; i < 3; i++){ //prints out the instuction board
                    for(int j = 0; j < 3; j++){
                        System.out.print(instruction[i][j]);
                        System.out.print("\t");
                    }
                    System.out.println("\n");
                    instructionValue = 1;
                }

                while(initializeBoard){
                    for(int x = 0; x < 3; x++){ //initializes the real board
                        for(int y = 0; y < 3; y++)
                            board[x][y] = "*\t\t";
                    }
                    initializeBoard = false; //does not initialize again until called
                }
                while(initializeBoard2){
                    for(int x = 0; x < 3; x++){ //initializes the board that sees if there is something there
                        for(int y = 0; y < 3; y++)
                            response[x][y] = 'E';
                    }
                    /*
                    C = computer holds that spot
                    U = user holds that sppt
                    E = the spot is empty
                     */
                    initializeBoard2 = false; //does not initialize again until called
                }
                while(initializeSpot){
                    for(int x = 0; x < 10; x++){
                        spotChoose[x] = false;
                    }
                    initializeSpot = false;
                }

                for(int i = 0; i < 3; i++){ //prints out the real board
                    for(int j = 0; j < 3; j++)
                        System.out.print(board[i][j]);
                    System.out.println("\n\n\n\n\n");
                }

                while(userChoose){ //checks to see if the spot is already taken
                    System.out.print("Your move!(Press 0 to see instructions again) ");
                    spot = sc.nextInt(); //user makes move
                    switch(spot){
                        case 0:
                            System.out.println("Above the game board are the coordinates you can choose 1-9.");
                            System.out.println("For example, if you type in 4, you will take the space in the 2nd row, 1st column");
                            System.out.println("You are X's and the computer is O's");
                            break;
                        case 1:
                            if(response[0][0] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                        case 2:
                            if(response[0][1] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                        case 3:
                            if(response[0][2] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                        case 4:
                            if(response[1][0] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                        case 5:
                            if(response[1][1] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                        case 6:
                            if(response[1][2] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                        case 7:
                            if(response[2][0] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                        case 8:
                            if(response[2][1] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                        case 9:
                            if(response[2][2] != 'E')
                                System.out.println("That spot is not available");
                            else
                                userChoose = false;
                            break;
                    }
                }
                switch(spot){ //converts what the user inputs to a spot on the board
                    case 1: board[0][0] = "X\t\t"; response[0][0] = 'U'; row[0]++; column[0]++; diagonal[0]++; turnLast = 1; break;
                    case 2: board[0][1] = "X\t\t"; response[0][1] = 'U'; row[0]++; column[1]++; turnLast = 2; break;
                    case 3: board[0][2] = "X\t\t"; response[0][2] = 'U'; row[0]++; column[2]++; diagonal[1]++; turnLast = 3; break;
                    case 4: board[1][0] = "X\t\t"; response[1][0] = 'U'; row[1]++; column[0]++; turnLast = 4; break;
                    case 5: board[1][1] = "X\t\t"; response[1][1] = 'U'; row[1]++; column[1]++; diagonal[0]++; diagonal[1]++; turnLast = 5; break;
                    case 6: board[1][2] = "X\t\t"; response[1][2] = 'U'; row[1]++; column[2]++; turnLast = 6; break;
                    case 7: board[2][0] = "X\t\t"; response[2][0] = 'U'; row[2]++; column[0]++; diagonal[1]++; turnLast = 7; break;
                    case 8: board[2][1] = "X\t\t"; response[2][1] = 'U'; row[2]++; column[1]++; turnLast = 8; break;
                    case 9: board[2][2] = "X\t\t"; response[2][2] = 'U'; row[2]++; column[2]++; diagonal[0]++; turnLast = 9; break;
                }
                System.out.println("\f");
                for(int i = 0; i < 3; i++){ //prints out the instuction board
                    for(int j = 0; j < 3; j++){
                        System.out.print(instruction[i][j]);
                        System.out.print("\t");
                    }
                    System.out.println("\n");
                }
                for(int i = 0; i < 3; i++){ //prints out the real board
                    for(int j = 0; j < 3; j++)
                        System.out.print(board[i][j]);
                    System.out.println("\n\n\n\n\n");
                }
                win = winOrLose(response); //sends the board to winOrLose to see if somebody has won
                /*
                0 = nobody has won yet
                1 = user has won
                2 = computer has won
                3 = the entire board is full and the game is over
                 */
                if(win == 1){ //if the user has won
                    play = false; //ends the game
                    userWin = true;
                    System.out.print("\f"); //form feeds
                    for(int i = 0; i < 3; i++){ //prints out the instuction board
                        for(int j = 0; j < 3; j++){
                            System.out.print(instruction[i][j]);
                            System.out.print("\t");
                        }
                        System.out.println("\n");
                    }
                    for(int i = 0; i < 3; i++){ //prints out the real board
                        for(int j = 0; j < 3; j++)
                            System.out.print(board[i][j]);
                        System.out.println("\n\n\n\n\n");
                    }
                    Thread.sleep(2000); //freezes for 2 seconds
                    break;
                }
                if(win == 2){ //if the computer has won
                    play = false; //ends the game
                    compWin = true;
                    System.out.print("\f"); //form feeds
                    for(int i = 0; i < 3; i++){ //prints out the instuction board
                        for(int j = 0; j < 3; j++){
                            System.out.print(instruction[i][j]);
                            System.out.print("\t");
                        }
                        System.out.println("\n");
                    }
                    for(int i = 0; i < 3; i++){ //prints out the real board
                        for(int j = 0; j < 3; j++)
                            System.out.print(board[i][j]);
                        System.out.println("\n\n\n\n\n");
                    }
                    Thread.sleep(2000); //freezes for 2 seconds
                    break;
                }
                if(win == 3){ //if the entire board is full
                    play = false; //ends the gamne
                    noWin = true;
                    System.out.print("\f"); //form feeds
                    for(int i = 0; i < 3; i++){ //prints out the instuction board
                        for(int j = 0; j < 3; j++){
                            System.out.print(instruction[i][j]);
                            System.out.print("\t");
                        }
                        System.out.println("\n");
                    }
                    for(int i = 0; i < 3; i++){ //prints out the real board
                        for(int j = 0; j < 3; j++)
                            System.out.print(board[i][j]);
                        System.out.println("\n\n\n\n\n");
                    }
                    Thread.sleep(2000); //freezes for 2 seconds
                    break;
                }

                compMove(response, board, turnNum, row, column, diagonal, rowC, columnC, diagonalC, turnLast); //sends information so the computer can make move

                Thread.sleep(1000); //freezes for 1 second
                System.out.print("\f"); //form feeds
                for(int i = 0; i < 3; i++){ //prints out the instuction board
                    for(int j = 0; j < 3; j++){
                        System.out.print(instruction[i][j]);
                        System.out.print("\t");
                    }
                    System.out.println("\n");
                }
                for(int i = 0; i < 3; i++){ //prints out the real board
                    for(int j = 0; j < 3; j++)
                        System.out.print(board[i][j]);
                    System.out.println("\n\n\n\n\n");
                }
                win = winOrLose(response); //sends the board to winOrLose to see if somebody has won
                /*
                0 = nobody has won yet
                1 = user has won
                2 = computer has won
                3 = the entire board is full and the game is over
                 */
                if(win == 1){ //if the user has won
                    play = false; //ends the game
                    userWin = true;
                    System.out.print("\f"); //form feeds
                    for(int i = 0; i < 3; i++){ //prints out the instuction board
                        for(int j = 0; j < 3; j++){
                            System.out.print(instruction[i][j]);
                            System.out.print("\t");
                        }
                        System.out.println("\n");
                    }
                    for(int i = 0; i < 3; i++){ //prints out the real board
                        for(int j = 0; j < 3; j++)
                            System.out.print(board[i][j]);
                        System.out.println("\n\n\n\n\n");
                    }
                    Thread.sleep(2000); //freezes for 2 seconds
                    break;
                }
                if(win == 2){ //if the computer has won
                    play = false; //ends the game
                    compWin = true;
                    System.out.print("\f"); //form feeds
                    for(int i = 0; i < 3; i++){ //prints out the instuction board
                        for(int j = 0; j < 3; j++){
                            System.out.print(instruction[i][j]);
                            System.out.print("\t");
                        }
                        System.out.println("\n");
                    }
                    for(int i = 0; i < 3; i++){ //prints out the real board
                        for(int j = 0; j < 3; j++)
                            System.out.print(board[i][j]);
                        System.out.println("\n\n\n\n\n");
                    }
                    Thread.sleep(2000); //freezes for 2 seconds
                    break;
                }
                if(win == 3){ //if the entire board is full
                    play = false; //ends the gamne
                    noWin = true;
                    System.out.print("\f"); //form feeds
                    for(int i = 0; i < 3; i++){ //prints out the instuction board
                        for(int j = 0; j < 3; j++){
                            System.out.print(instruction[i][j]);
                            System.out.print("\t");
                        }
                        System.out.println("\n");
                    }
                    for(int i = 0; i < 3; i++){ //prints out the real board
                        for(int j = 0; j < 3; j++)
                            System.out.print(board[i][j]);
                        System.out.println("\n\n\n\n\n");
                    }
                    Thread.sleep(2000); //freezes for 2 seconds
                    break;
                }

                userChoose = true;
                turnNum++; //counts up the turn number
                System.out.print("\f"); //form feeds
            }

            if(compWin){
                System.out.println("The computer wins!");
                System.out.println("Do you want to play again(y/n)?");
                String yesno=sc.next();
                if(yesno.equals("n")){
                    play=false;
                    noQuit = false;
                    System.out.println("You suck. Good bye!");
                }
                if(yesno.equals("y")){
                    play = true;
                    Thread.sleep(500); //freezes for half a second
                    System.out.println("Welcome to the tic tac toe game!");
                    System.out.println("Below are the coordinates you can choose 1-9.");
                    System.out.println("Good luck!");
                    System.out.println("USER- 'X'\tPROGRAM-'O'");

                    instruction = new int[3][3];
                    board = new String[3][3];
                    response = new char[3][3];
                    spotChoose = new boolean [10];
                    initializeBoard = true;
                    initializeBoard2 = true;
                    initializeSpot = true;
                    userWin = false;
                    compWin = false;
                    noWin = false;
                    userChoose = true;

                    turnNum = 1;
                    row[0] =0;
                    row[1] =0;
                    row[2] =0;
                    column[0]= 0;
                    column[1]= 0;
                    column[2]= 0;
                    diagonal[0] = 0;
                    diagonal[1] = 0;
                    rowC[0] = 0;
                    rowC[1] = 0;
                    rowC[2] = 0;
                    columnC[0]= 0;
                    columnC[1]= 0;
                    columnC[2]= 0;
                    diagonalC[0] = 0;
                    diagonalC[1] = 0;
                    instructionValue = 1;
                    spot = 0;
                    turnLast = 0;
                    System.out.print("\f"); //form feeds
                }
            }
            if(noWin){
                System.out.println("It is a tie. Nobody wins.");
                System.out.println("Do you want to play again(y/n)?");
                String yesno=sc.next();
                if(yesno.equals("n")){
                    play=false;
                    noQuit = false;
                    System.out.println("You suck. Good bye!");
                }
                if(yesno.equals("y")){
                    Thread.sleep(500); //freezes for half a second
                    System.out.println("Welcome to the tic tac toe game!");
                    System.out.println("Below are the coordinates you can choose 1-9.");
                    System.out.println("Good luck!");
                    System.out.println("USER- 'X'\tPROGRAM-'O'");

                    instruction = new int[3][3];
                    board = new String[3][3];
                    response = new char[3][3];
                    spotChoose = new boolean [10];
                    play = true;
                    initializeBoard = true;
                    initializeBoard2 = true;
                    initializeSpot = true;
                    userWin = false;
                    compWin = false;
                    noWin = false;
                    userChoose = true;

                    turnNum = 1;

                    row[0] =0;
                    row[1] =0;
                    row[2] =0;
                    column[0]= 0;
                    column[1]= 0;
                    column[2]= 0;
                    diagonal[0] = 0;
                    diagonal[1] = 0;
                    rowC[0] = 0;
                    rowC[1] = 0;
                    rowC[2] = 0;
                    columnC[0]= 0;
                    columnC[1]= 0;
                    columnC[2]= 0;
                    diagonalC[0] = 0;
                    diagonalC[1] = 0;
                    instructionValue = 1;
                    spot = 0;
                    turnLast = 0;
                    System.out.print("\f"); //form feeds
                }
            }
            if(userWin){
                System.out.println("You win!");
                System.out.println("Do you want to play again(y/n)?");
                String yesno=sc.next();
                if(yesno.equals("n")){
                    play=false;
                    noQuit = false;
                    System.out.println("That was fun. Good bye!");
                }
                if(yesno.equals("y")){
                    Thread.sleep(500); //freezes for half a second
                    System.out.println("Welcome to the tic tac toe game!");
                    System.out.println("Below are the coordinates you can choose 1-9.");
                    System.out.println("Good luck!");
                    System.out.println("USER- 'X'\tPROGRAM-'O'");

                    instruction = new int[3][3];
                    board = new String[3][3];
                    response = new char[3][3];
                    spotChoose = new boolean [10];
                    play = true;
                    initializeBoard = true;
                    initializeBoard2 = true;
                    initializeSpot = true;
                    userWin = false;
                    compWin = false;
                    noWin = false;
                    userChoose = true;

                    turnNum = 1;

                    row[0] =0;
                    row[1] =0;
                    row[2] =0;
                    column[0]= 0;
                    column[1]= 0;
                    column[2]= 0;
                    diagonal[0] = 0;
                    diagonal[1] = 0;
                    rowC[0] = 0;
                    rowC[1] = 0;
                    rowC[2] = 0;
                    columnC[0]= 0;
                    columnC[1]= 0;
                    columnC[2]= 0;
                    diagonalC[0] = 0;
                    diagonalC[1] = 0;
                    instructionValue = 1;
                    spot = 0;
                    turnLast = 0;
                    System.out.print("\f"); //form feeds
                }
            }
        }
    }

    public static char winOrLose(char response1[][]){ //checks to see if somebody as won
        if(response1[0][0] == 'U' &&  response1[0][1] == 'U' && response1[0][2] == 'U'){
            return 1;
        }
        else if(response1[1][0] == 'U' &&  response1[1][1] == 'U' && response1[1][2] == 'U'){
            return 1;
        }
        else if(response1[2][0] == 'U' &&  response1[2][1] == 'U' && response1[2][2] == 'U'){
            return 1;
        }
        else if(response1[0][0] == 'U' &&  response1[1][0] == 'U' && response1[2][0] == 'U'){
            return 1;
        }
        else if(response1[0][1] == 'U' &&  response1[1][1] == 'U' && response1[2][1] == 'U'){
            return 1;
        }
        else if(response1[0][2] == 'U' &&  response1[1][2] == 'U' && response1[2][2] == 'U'){
            return 1;
        }
        else if(response1[0][0] == 'U' &&  response1[1][1] == 'U' && response1[2][2] == 'U'){
            return 1;
        }
        else if(response1[0][2] == 'U' &&  response1[1][1] == 'U' && response1[2][0] == 'U'){
            return 1;
        }
        else if(response1[0][0] == 'C' &&  response1[0][1] == 'C' && response1[0][2] == 'C'){
            return 2;
        }
        else if(response1[1][0] == 'C' &&  response1[1][1] == 'C' && response1[1][2] == 'C'){
            return 2;
        }
        else if(response1[2][0] == 'C' &&  response1[2][1] == 'C' && response1[2][2] == 'C'){
            return 2;
        }
        else if(response1[0][0] == 'C' &&  response1[1][0] == 'C' && response1[2][0] == 'C'){
            return 2;
        }
        else if(response1[0][1] == 'C' &&  response1[1][1] == 'C' && response1[2][1] == 'C'){
            return 2;
        }
        else if(response1[0][2] == 'C' &&  response1[1][2] == 'C' && response1[2][2] == 'C'){
            return 2;
        }
        else if(response1[0][0] == 'C' &&  response1[1][1] == 'C' && response1[2][2] == 'C'){
            return 2;
        }
        else if(response1[0][2] == 'C' &&  response1[1][1] == 'C' && response1[2][0] == 'C'){
            return 2;
        }
        else if(response1[0][0] != 'E' && response1[0][1] != 'E' && response1[0][2] != 'E' && response1[1][0] != 'E' &&
                response1[1][1] != 'E' && response1[1][2] != 'E' && response1[2][0] != 'E' && response1[2][1] != 'E' && response1[2][2] != 'E'){ //if the entire board is full
            return 3;
        }
        else
            return 0;
    }

    public static void compMove(char response1[][], String board1[][], int turnNum1, int rowCount[], int columnCount[], int diagonalCount[], int rowCompCount[], int columnCompCount[], int diagonalCompCount[], int moveLast){
        int num, counter=0;
        boolean calculate = true;
        boolean compWin = false;
        boolean nothingElse = true;
        while(calculate){
            for(int i = 0; i < 3; i++){ //if the computer is about to win by having 3 in a row
                if(rowCompCount[i] == 2){ // work on this
                    for(int j = 0; j < 3; j++){
                        if(response1[i][j] == 'E'){
                            response1[i][j] = 'C';
                            board1[i][j] = "O\t\t";
                            compWin = true;
                            counter++;
                            break;
                        }
                    }
                }
            }
            if(counter==1)
                break;
            for(int i = 0; i < 3; i++){ //if the computer is about to win by having 3 in a column
                if(columnCompCount[i] == 2){ // work on this
                    for(int j = 0; j < 3; j++){
                        if(response1[j][i] == 'E'){
                            response1[j][i] = 'C';
                            board1[j][i] = "O\t\t";
                            counter++;
                            compWin = true;
                            break;
                        }
                    }
                }
            }
            if(counter==1)
                break;
            if(diagonalCompCount[0] == 2){ //if the computer is about to win by having 3 in a diagonal
                if(response1[0][0]=='E'){
                    response1[0][0]= 'C';
                    board1[0][0] = "O\t\t";
                    counter++;
                    compWin=true;
                    break;
                }
                else if(response1[1][1]=='E'){
                    response1[1][1]='C';
                    board1[1][1] = "O\t\t";
                    counter++;
                    compWin=true;
                    break;
                }
                else if(response1[2][2]=='E'){
                    response1[2][2] = 'C';
                    board1[2][2] = "O\t\t";
                    counter++;
                    compWin=true;
                    break;
                }
            }
            if(diagonalCompCount[1] == 2){ //if the computer is about to win by having 3 in a diagonal
                if(response1[0][2]=='E'){
                    response1[0][2]= 'C';
                    board1[0][2] = "O\t\t";
                    counter++;
                    compWin=true;
                    break;
                }
                else if(response1[1][1]=='E'){
                    response1[1][1]='C';
                    board1[1][1] = "O\t\t";
                    counter++;
                    compWin=true;
                    break;
                }
                else if(response1[2][0]=='E'){
                    response1[2][0] = 'C';
                    board1[2][0] = "O\t\t";
                    counter++;
                    compWin=true;
                    break;
                }
            }
            if(counter==1)
                break;
            for(int i = 0; i < 3; i++){ //if the user is about to win by having 3 in a row, the computer blocks it
                if(rowCount[i] == 2){
                    for(int j = 0; j < 3; j++){
                        if(response1[i][j] == 'E' && compWin == false){
                            response1[i][j] = 'C';
                            board1[i][j] = "O\t\t";
                            switch(i){ //lets computer know there is another thing in that row/column/diagonal
                                case 0:
                                    switch(j){
                                        case 0: rowCompCount[0]++; columnCompCount[0]++; diagonalCompCount[0]++; counter++; break;
                                        case 1: rowCompCount[0]++; columnCompCount[1]++; counter++; break;
                                        case 2: rowCompCount[0]++; columnCompCount[2]++; diagonalCompCount[1]++; counter++; break;
                                    }
                                    break;
                                case 1:
                                    switch(j){
                                        case 0: rowCompCount[1]++; columnCompCount[0]++; counter++; break;
                                        case 1: rowCompCount[1]++; columnCompCount[1]++; diagonalCompCount[0]++; diagonalCompCount[1]++; counter++; break;
                                        case 2: rowCompCount[1]++; columnCompCount[2]++; counter++; break;
                                    }
                                    break;
                                case 2:
                                    switch(j){
                                        case 0: rowCompCount[2]++; columnCompCount[0]++; diagonalCompCount[1]++; counter++; break;
                                        case 1: rowCompCount[2]++; columnCompCount[1]++; counter++; break;
                                        case 2: rowCompCount[2]++; columnCompCount[2]++; diagonalCompCount[0]++; counter++; break;
                                    }
                            }
                            break;
                        }
                    }
                }
            }
            if(counter == 1) //if the conputer has already taken a turn
                break;
            for(int i = 0; i < 3; i++){ //if the user is about to win by having 3 in a column the computer blocks it
                if(columnCount[i] == 2){
                    for(int j = 0; j < 3; j++){
                        if(response1[j][i] == 'E' && compWin == false){
                            response1[j][i] = 'C';
                            board1[j][i] = "O\t\t";
                            switch(i){ //lets computer know there is another thing in that row/column/diagonal
                                case 0:
                                    switch(j){
                                        case 0: rowCompCount[0]++; columnCompCount[0]++; diagonalCompCount[0]++; counter++; break;
                                        case 1: rowCompCount[0]++; columnCompCount[1]++; counter++; break;
                                        case 2: rowCompCount[0]++; columnCompCount[2]++; diagonalCompCount[1]++; counter++; break;
                                    }
                                    break;
                                case 1:
                                    switch(j){
                                        case 0: rowCompCount[1]++; columnCompCount[0]++; counter++; break;
                                        case 1: rowCompCount[1]++; columnCompCount[1]++; diagonalCompCount[0]++; diagonalCompCount[1]++; counter++; break;
                                        case 2: rowCompCount[1]++; columnCompCount[2]++; counter++; break;
                                    }
                                    break;
                                case 2:
                                    switch(j){
                                        case 0: rowCompCount[2]++; columnCompCount[0]++; diagonalCompCount[1]++; counter++; break;
                                        case 1: rowCompCount[2]++; columnCompCount[1]++; counter++; break;
                                        case 2: rowCompCount[2]++; columnCompCount[2]++; diagonalCompCount[0]++; counter++; break;
                                    }
                            }
                            break;
                        }
                    }
                }
            }
            if(counter == 1) //if the conputer has already taken a turn
                break;
            if(diagonalCount[0] == 2 && compWin == false){ //if the user is about to win by having 3 in a diagonal the computer blocks it
                if(response1[0][0] == 'E'){
                    response1[0][0] = 'C';
                    board1[0][0] = "O\t\t";
                    rowCompCount[0]++;
                    columnCompCount[0]++;
                    diagonalCompCount[0]++;
                    counter++;
                    break;
                }
                else if (response1[2][2] == 'E'){
                    response1[2][2] = 'C';
                    board1[2][2] = "O\t\t";
                    rowCompCount[2]++;
                    columnCompCount[2]++;
                    diagonalCompCount[0]++;
                    counter++;
                    break;
                }
            }
            if(counter == 1) //if the conputer has already taken a turn
                break;
            if(diagonalCount[1] == 2 && compWin == false){ //if the user is about to win by having 3 in a diagonal the computer blocks it
                if(response1[0][2] == 'E' ){
                    response1[0][2] = 'C';
                    board1[0][2] = "O\t\t";
                    rowCompCount[0]++;
                    columnCompCount[2]++;
                    diagonalCompCount[1]++;
                    counter++;
                    break;
                }
                else if (response1[2][0] == 'E'){
                    response1[2][0] = 'C';
                    board1[2][0] = "O\t\t";
                    rowCompCount[2]++;
                    columnCompCount[2]++;
                    diagonalCompCount[0]++;
                    counter++;
                    break;
                }
            }
            if(counter == 1) //if the conputer has already taken a turn
                break;
            if(response1[1][1] == 'E'){ //if the middle spot is not taken then the computer takes the middle spot
                response1[1][1] = 'C';
                board1[1][1] = "O\t\t";
                rowCompCount[1]++;
                columnCompCount[1]++;
                diagonalCompCount[0]++;
                diagonalCompCount[1]++;
                break;
            }
            if(counter == 1)
                break;
            if(moveLast == 2 || moveLast == 4 || moveLast == 6 || moveLast == 8){ //if it is the first turn and the user has taken an edge
                if(turnNum1 == 1){
                    switch(moveLast){
                        case 2: response1[0][2] = 'C'; board1[0][2] = "O\t\t"; rowCompCount[0]++; columnCompCount[2]++; diagonalCompCount[1]++; counter++; break;
                        case 4: response1[2][0] = 'C'; board1[2][0] = "O\t\t"; rowCompCount[2]++; columnCompCount[0]++; diagonalCompCount[1]++; counter++; break;
                        case 6: response1[2][2] = 'C'; board1[2][2] = "O\t\t"; rowCompCount[2]++; columnCompCount[2]++; diagonalCompCount[0]++; counter++; break;
                        case 8: response1[2][2] = 'C'; board1[2][2] = "O\t\t"; rowCompCount[2]++; columnCompCount[2]++; diagonalCompCount[0]++; counter++; break;
                    }
                }
            }
            if(counter == 1)
                break;

            if(response1[1][1] == 'U' && turnNum1 == 1){ //if this is the first turn and the user has taken the middle spot the computer takes a random corner
                num = 1 + (int)(Math.random() * 4);
                switch(num){
                    case 1: response1[0][0] = 'C'; board1[0][0] = "O\t\t"; rowCompCount[0]++; columnCompCount[0]++; diagonalCompCount[0]++; break;
                    case 2: response1[0][2] = 'C'; board1[0][2] = "O\t\t"; rowCompCount[0]++; columnCompCount[2]++; diagonalCompCount[1]++; break;
                    case 3: response1[2][0] = 'C'; board1[2][0] = "O\t\t"; rowCompCount[2]++; columnCompCount[0]++; diagonalCompCount[1]++; break;
                    case 4: response1[2][2] = 'C'; board1[2][2] = "O\t\t"; rowCompCount[2]++; columnCompCount[2]++; diagonalCompCount[0]++; break;
                }
                break;
            }
            if(counter == 1)
                break;
            while(nothingElse){ //work on this
                num = 1 + (int)(Math.random() * 9);
                switch(num){
                    case 1:
                        if(response1[0][0] == 'E'){
                            response1[0][0] = 'C'; board1[0][0] = "O\t\t"; rowCompCount[0]++; columnCompCount[0]++; diagonalCompCount[0]++; nothingElse = false;
                        }
                        break;
                    case 2:
                        if(response1[0][1] == 'E'){
                            response1[0][1] = 'C'; board1[0][1] = "O\t\t"; rowCompCount[0]++; columnCompCount[1]++; nothingElse = false;
                        }
                        break;
                    case 3:
                        if(response1[0][2] == 'E'){
                            response1[0][2] = 'C'; board1[0][2] = "O\t\t"; rowCompCount[0]++; columnCompCount[2]++; diagonalCompCount[1]++; nothingElse = false;
                        }
                        break;
                    case 4:
                        if(response1[1][0] == 'E'){
                            board1[1][0] = "O\t\t"; response1[1][0] = 'C'; rowCompCount[1]++; columnCompCount[0]++; nothingElse = false;
                        }
                        break;
                    case 5:
                        if(response1[1][1] == 'E'){
                            board1[1][1] = "O\t\t"; response1[1][1] = 'C'; rowCompCount[1]++; columnCompCount[1]++; diagonalCompCount[0]++; diagonalCompCount[1]++; nothingElse = false;
                        }
                        break;
                    case 6:
                        if(response1[1][2] == 'E'){
                            board1[1][2] = "O\t\t"; response1[1][2] = 'C'; rowCompCount[1]++; columnCompCount[2]++; nothingElse = false;
                        }
                        break;
                    case 7:
                        if(response1[2][0] == 'E') {
                            board1[2][0] = "O\t\t"; response1[2][0] = 'C'; rowCompCount[2]++; columnCompCount[0]++; diagonalCompCount[1]++; nothingElse = false;
                        }
                        break;
                    case 8:
                        if(response1[2][1] == 'E'){
                            board1[2][1] = "O\t\t"; response1[2][1] = 'C'; rowCompCount[2]++; columnCompCount[1]++; nothingElse = false;
                        }
                        break;
                    case 9:
                        if(response1[2][2] == 'E') {
                            board1[2][2] = "O\t\t"; response1[2][2] = 'C'; rowCompCount[2]++; columnCompCount[2]++; diagonalCompCount[0]++; nothingElse = false;
                        }
                        break;
                }
            }
            if(counter == 1)
                break;
            else
                break;
        }
    }
}


