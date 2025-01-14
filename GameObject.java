public class GameObject {
    //character that represents the type of object 	
    //' ' = empty, 'o' = snake, '$' = apple, * = wall
    private char type;
    //the obj position on the grid
    private int row, col;

    //constructor
    public GameObject(char type, int row, int col) {
        this.type = type;
        this.row = row;
        this.col = col;
    }

    //getters

    public char getObjectType() {
        return this.type;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }

    //setters

    public void setObjectType(char type) {
        this.type = type;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    //to string
    public String toString() {
        String s = "";

        s += "obj type: " + this.type + "\n";
        s += "row, col: " + this.row + ", " + this.col;
        
        return s;
    }
}
