import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //initialize all the game stuffs

        //init board
        Bitboard myBoard = new Bitboard(11);
        //init snake
        Snake mySnake = new Snake(5, 5);
        //spawn it
        myBoard.setSnake(mySnake);

        //make the scanner
        Scanner scanner = new Scanner(System.in);

        //game loop and logic
        boolean running = true;

        while (running) {
            //spawn an apple
            myBoard.setApple();

            //print new state of board
			System.out.print(myBoard);
			// Get input from player and do something
			switch (scanner.nextLine().charAt(0)) {
            
            case 'a':
				mySnake.moveLeft(myBoard);
				break;
			case 'd':
				mySnake.moveRight(myBoard);
				break;
			case 'w':
				mySnake.moveUp(myBoard);
				break;
			case 's':
				mySnake.moveDown(myBoard);
				break;
            case 'o':
                //end game
                running = false;
                System.out.println("\nTerminated");
                break;
            default:
                //misclick
                System.out.println("press w, a, s, or d");
                break;
			}
		}
        scanner.close();
    }

    //clears the screen in terminal - could be useful?
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
}
