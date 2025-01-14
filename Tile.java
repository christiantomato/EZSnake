public class Tile {

    //object on tile, row and col of tile itself
    private GameObject object;
    private int tileRow, tileCol;

    //constructor
    public Tile(GameObject object, int tileRow, int tileCol) {
        this.object = object;
        this.tileRow = tileRow;
        this.tileCol = tileCol;
    }

    //getters

    public GameObject getObject() {
        return this.object;
    }

    public int getTileRow() {
        return this.tileRow;
    }

    public int getTileCol() {
        return this.tileCol;
    }
	
    //setters 

    //set a new object to the tile
    public void setObject(GameObject object) {
        this.object = object;
    }

    //make empty
    public void setEmpty() {
        //create an empty game obj
        this.object = new GameObject(' ', this.tileRow, this.tileCol);
    }
	
    //checkers 

	public boolean isEmpty() {
		if(this.object.getObjectType() == ' ') {
            //then empty
            return true;
        }
        return false;
	}

	public boolean isSnake() {
        if(this.object instanceof Snake) {
            //then snake
            return true;
        }
        return false;
	}

	public boolean isApple() {
        if(this.object instanceof Apple) {
            //then apple
            return true;
        }
        return false;
	}

    public boolean isWall() {
        if(this.object instanceof Wall) {
            //then wall
            return true;
        }
        return false;
    }

    //toString
    public String toString() {
        String s = "";

        s += "Obj on tile: " + this.object;
        s += "Row and col of tile: " + this.tileRow + ", " + this.tileCol;

        return s;
    }
}
