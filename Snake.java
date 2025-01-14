public class Snake extends GameObject {

    //private int length = 1;

    //constructor
    public Snake(int row, int col) {
        //set its char type
        super('o', row, col);
    }

    //move methods

    public void moveUp(Bitboard board) {
        this.setRow(this.getRow() - 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveLeft(Bitboard board) {
        //move snake's pos.
        this.setCol(this.getCol() - 1);

        //make the tile the previous snake was on empty
        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //set the board with the new position of the snake
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveDown(Bitboard board) {
        this.setRow(this.getRow() + 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveRight(Bitboard board) {
        this.setCol(this.getCol() + 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }
}
