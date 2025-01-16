//the grid of the game!
public class Bitboard {
	
	//board size and tiles
	private int size;
	private Tile[][] tiles;
	
	//construct the board
	public Bitboard(int size) {
		
		//create 2D board
		this.size = size;
		this.tiles = new Tile[size][size];
		
		//set it up with empty tiles and wall tiles
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
                //the borders will be walls
                if(i == 0 || j == 0 || i == size-1 || j == size-1) {
                    //create the tile and put a wall
                    this.tiles[i][j] = new Tile(new Wall(i, j), i, j);
                }
                else {
                //add empty tile
				this.tiles[i][j] = new Tile(new GameObject(' ', i, j), i, j);
                }
			}
		}
	}

    //get board
    public Tile[][] getTiles() {
        return this.tiles;
    }

	//get size
	public int getSize() {
		return this.size;
	}

    //set the snake on the board
    public void setSnake(Snake snake) {
        //put it onto the tile
        this.tiles[snake.getRow()][snake.getCol()].setObject(snake);
    }

	public void addSnake(Snake snake, char lastDirection) {
		//add a part
		 //add a snake object behind current snake
		 switch(lastDirection) {
            
            case 'w':
                //if last direction was up, create and spawn new part directly below
                Snake belowSnake = new Snake(snake.getRow()+1, snake.getCol());
				//add to board
				this.tiles[belowSnake.getRow()][belowSnake.getCol()].setObject(belowSnake);
                break;
            case 'a':
                Snake rightSnake = new Snake(snake.getRow(), snake.getCol()+1);
				this.tiles[rightSnake.getRow()][rightSnake.getCol()].setObject(rightSnake);
                break;
            case 's':
                Snake aboveSnake = new Snake(snake.getRow()-1, snake.getCol());
				this.tiles[aboveSnake.getRow()][aboveSnake.getCol()].setObject(aboveSnake);
                break;
            case 'd':
                Snake leftSnake = new Snake(snake.getRow(), snake.getCol()-1);
				this.tiles[leftSnake.getRow()][leftSnake.getCol()].setObject(leftSnake);
                break;
            default:
                //fo
                break;
        }
	}

	//set appls on board
	public void setApple() {
		 //create an appl object and randomize its location
		 boolean okLocation = false;

		 while(!okLocation) {
			//retry
			int randRow = (int) (Math.random() * this.size);
		 	int randCol = (int) (Math.random() * this.size);

			//check if valid
			if(this.tiles[randRow][randCol].isEmpty()) {
				//yay!
				Apple appl = new Apple(randRow, randCol);
		
				//put it onto the tile
				this.tiles[appl.getRow()][appl.getCol()].setObject(appl);
				break;
			}
		}
	}
	
	//to print out board
	public String toString() {
		String s = "";
		
		for(int i=0; i<this.size; i++) {
			for(int j=0; j<this.size; j++) {
				s += " " + this.tiles[i][j].getObject().getObjectType();
			}
			//new line each row
			s += "\n";
		}
		return s;
	}    
}
