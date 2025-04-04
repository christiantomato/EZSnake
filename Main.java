import java.util.Scanner;

public class Main {

    public static int applEaten = 0;

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
            //for debugging
            System.out.println(mySnake + "\n");
            //print new state of board
            System.out.println("Appls eaten: " + Main.applEaten);
			System.out.print(myBoard);

            //before moving keep track of where head was before 
            //int prevHeadRow = mySnake.getHead().getRow();
            //int prevHeadCol = mySnake.getHead().getCol();

            try {
                //get input from player to move and record it
                char input = scanner.nextLine().charAt(0);

                switch(input) {
            
                    case 'w':
                        //move up
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
                if(myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()].isWall()) {
                    //bro you died
                    System.out.println("\ncollided wall\n");
                    //end
                    break;
                }

                //if snake is on snake tile (not good)
                else if(myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()].isSnake()) {
                    //bro you died
                    System.out.println("collided with self");
                    //end
                    break;
                }

                //appl interaction
                else if(myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()].isApple()) {
                    //hey you ate an appl
                    Main.applEaten++;

                    /*
                    switch(input) {
                        
                        case 'w':
                            //if last direction was up, create and spawn new part directly below
                            Snake belowSnake = new Snake(mySnake.getHead().getRow()+1, mySnake.getHead().getCol());
                            //add to our arraylist
                            mySnake.add(belowSnake);
                            //this.tiles[belowSnake.getRow()][belowSnake.getCol()].setObject(belowSnake);
                            break;
                        case 'a':
                            Snake rightSnake = new Snake(mySnake.getHead().getRow(), mySnake.getHead().getCol()+1);
                            mySnake.add(rightSnake);
                            //this.tiles[rightSnake.getRow()][rightSnake.getCol()].setObject(rightSnake);
                            break;
                        case 's':
                            Snake aboveSnake = new Snake(mySnake.getHead().getRow()-1, mySnake.getHead().getCol());
                            mySnake.add(aboveSnake);
                            //this.tiles[aboveSnake.getRow()][aboveSnake.getCol()].setObject(aboveSnake);
                            break;
                        case 'd':
                            Snake leftSnake = new Snake(mySnake.getHead().getRow(), mySnake.getHead().getCol()-1);
                            mySnake.add(leftSnake);
                            //this.tiles[leftSnake.getRow()][leftSnake.getCol()].setObject(leftSnake);
                            break;
                        default:
                            //fo
                            break;
                    } */

                    //new appl
                    myBoard.setApple();
                }

                //set the board with the updated positions of snake
                myBoard.getTiles()[mySnake.getRow()][mySnake.getCol()].setObject(mySnake);
      

                //clear screen to make look cleeaan :D
                clearScreen();
            }

            //catch any blank inputs
            catch (java.lang.StringIndexOutOfBoundsException e) {
                System.out.println("mooooveeee");
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
