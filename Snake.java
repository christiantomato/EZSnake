public class Snake extends GameObject {

    int prevRow, prevCol;

    //constructor for snake head
    public Snake(int row, int col) {
        //set its char type
        super('O', row, col);
    }

    public int getPrevRow() {
        return this.prevRow;
    }

    public int getPrevCol() {
        return this.prevCol;
    }
    
    public void setPrevPosition(int row, int col) {
        this.prevRow = row;
        this.prevCol = col;
    }

    //move methods for head

    public void moveUp(Bitboard board) {
        //set previous
        this.prevRow = this.getRow();
        this.prevCol = this.getCol();
        //set empty
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //move it
        this.setRow(this.getRow() - 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveLeft(Bitboard board) {
        //move snake's pos.
        this.prevRow = this.getRow();
        this.prevCol = this.getCol();
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setCol(this.getCol() - 1);

        //make the tile the previous snake was on empty
        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //set the board with the new position of the snake
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }
 
    public void moveDown(Bitboard board) {
        this.prevRow = this.getRow();
        this.prevCol = this.getCol();
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setRow(this.getRow() + 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveRight(Bitboard board) {
        this.prevRow = this.getRow();
        this.prevCol = this.getCol();
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setCol(this.getCol() + 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }
}
