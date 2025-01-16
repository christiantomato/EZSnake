public class Snake extends GameObject {

    //constructor for snake head
    public Snake(int row, int col) {
        //set its char type
        super('O', row, col);
    }

    //move methods

    public void moveUp(Bitboard board) {

        //set tile empty first?
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setRow(this.getRow() - 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveLeft(Bitboard board) {
        //move snake's pos.
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setCol(this.getCol() - 1);

        //make the tile the previous snake was on empty
        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //set the board with the new position of the snake
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }
 
    public void moveDown(Bitboard board) {
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setRow(this.getRow() + 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }

    public void moveRight(Bitboard board) {
        board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        this.setCol(this.getCol() + 1);

        //board.getTiles()[this.getRow()][this.getCol()].setEmpty();
        //board.getTiles()[this.getRow()][this.getCol()].setObject(this);
    }
}
