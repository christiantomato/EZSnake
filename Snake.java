public class Snake extends GameObject {

    //private int length = 1;

    //constructor
    public Snake(int row, int col) {
        //set its char type
        super('o', row, col);
    }

    //move methods

    public void moveLeft(Bitboard board) {
        //make the tile the previous snake was on empty
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //move snake's pos.
        this.setCol(this.getCol() - 1);
        //set the board with the new position of the snake
        board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveRight(Bitboard board) {
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setCol(this.getCol() + 1);
        board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveUp(Bitboard board) {
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setRow(this.getRow() - 1);
        board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveDown(Bitboard board) {
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setRow(this.getRow() + 1);
        board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }
}
