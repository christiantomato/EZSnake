import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //initialize all the game stuffs

        //init board
        Bitboard myBoard = new Bitboard(9);
        //init snake
        Snake mySnake = new Snake(4, 4);
        //put on board
        myBoard.setSnake(mySnake);
        //init appl
        myBoard.setApple();

        //make the scanner to read in input
        Scanner scanner = new Scanner(System.in);

        //game loop and logic
        boolean running = true;

        while (running) {
            //print new state of board
			System.out.print(myBoard);

            try {
                //get input from player to move and record it
                char input = scanner.nextLine().charAt(0);

                switch (input) {
            
                    case 'w':
                        mySnake.moveUp(myBoard);
                        break;
                    case 'a':
                        mySnake.moveLeft(myBoard);
                        break;
                    case 's':
                        mySnake.moveDown(myBoard);
                        break;
                    case 'd':
                        mySnake.moveRight(myBoard);
                        break;
                    case 'o':
                        //end game
                        running = false;
                        System.out.println("\nTerminated\n");
                        break;
                    default:
                        //for misinputs
                        System.out.println("\npress w, a, s, or d");
                        break;
                }

                //check interactions

                //is the snake now on a wall tile
                if(myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()].isWall()) {
                    //bro you died
                    System.out.println("\nHOLD IT RIGHT THERE BUDDY!!!\n");
                    //end
                    break;
                }

                //appl interaction
                else if(myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()].isApple()) {
                    //new appl
                    myBoard.setApple();
                }

                //move snake

                //make the tile the previous snake was on empty
                if(input == 'w') {
                    //clear prev tile
                    myBoard.getTiles()[mySnake.getRow()+1][mySnake.getCol()].setEmpty();
                }
                else if(input == 'a') {
                    myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()+1].setEmpty();
                }
                else if(input == 's') {
                    myBoard.getTiles()[mySnake.getRow()-1][mySnake.getCol()].setEmpty();
                }
                else if(input == 'd') {
                    myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()-1].setEmpty();
                }
            
                //set the board with the new position of the snake
                myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()].setObject(mySnake);
            }

            //catch any blank inputs
            catch (java.lang.StringIndexOutOfBoundsException e) {
                System.out.println("move bruv");
                continue;
            }
		}
        scanner.close();
    }

    //clears the screen in terminal
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
