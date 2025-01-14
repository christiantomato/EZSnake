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

	//set appls on board
	public void setApple() {
		 //create an appl object and randomize its location
		 int randRow = (int) (Math.random() * this.size);
		 int randCol = (int) (Math.random() * this.size);
		 Apple appl = new Apple(randRow, randCol);
		
		//put it into the tile
		this.tiles[appl.getRow()][appl.getCol()].setObject(appl);
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
