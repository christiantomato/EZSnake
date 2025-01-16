import java.util.Scanner;

public class Main {

    public static int applEaten = 0;

    public static void main(String[] args) {
        //initialize all the game stuffs

        //init board
        Bitboard myBoard = new Bitboard(9);
        //init snake
        SnakeParts mySnake = new SnakeParts(4, 4, myBoard.getSize());
        //put on board
        myBoard.setSnake(mySnake.getHead());
        //init appl
        myBoard.setApple();

        //make the scanner to read in input
        Scanner scanner = new Scanner(System.in);

        //game loop and logic
        boolean running = true;

        while (running) {
            //print new state of board
            System.out.println("Appls eaten: " + Main.applEaten);
			System.out.print(myBoard);

            try {
                //get input from player to move and record it
                char input = scanner.nextLine().charAt(0);

                switch(input) {
            
                    case 'w':
                        //move up
                        mySnake.getHead().moveUp(myBoard);
                        break;
                    case 'a':
                        mySnake.getHead().moveLeft(myBoard);
                        break;
                    case 's':
                        mySnake.getHead().moveDown(myBoard);
                        break;
                    case 'd':
                        mySnake.getHead().moveRight(myBoard);
                        break;
                    case 't':
                        //end game
                        running = false;
                        System.out.println("\nTerminated\n");
                        break;
                    default:
                        //for misinputs
                        System.out.println("\npress w, a, s, or d");
                }

                //check interactions

                //is the snake now on a wall tile
                if(myBoard.getTiles()[mySnake.getHead().getRow()][mySnake.getHead().getCol()].isWall()) {
                    //bro you died
                    System.out.println("\nHOLD IT RIGHT THERE BUDDY!!!\n");
                    //end
                    break;
                }

                //if snake is on snake tile (not good)
                else if(myBoard.getTiles()[mySnake.getHead().getRow()][mySnake.getHead().getCol()].isSnake()) {
                    //bro you died
                    System.out.println("HOLD IT RIGHT THERE BUDDY!!!\n");
                    //end
                    break;
                }

                //appl interaction
                else if(myBoard.getTiles()[mySnake.getHead().getRow()][mySnake.getHead().getCol()].isApple()) {
                    //hey you ate an appl
                    Main.applEaten++;
                    //new appl
                    myBoard.setApple();
                    //new part
                    myBoard.addSnake(mySnake.getHead(), input);
                }

                //set the board with the new position of the snake head now
                myBoard.getTiles()[mySnake.getHead().getRow()][mySnake.getHead().getCol()].setObject(mySnake.getHead());
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
