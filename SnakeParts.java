public class SnakeParts {
    //array of snakes
    private Snake[] parts;
    private int leng;

    public SnakeParts(int headRowStart, int headColStart, int sizeOfBoard) {
        //initialize enough spots for all snake pieces (covers area of board)
        this.parts = new Snake[(sizeOfBoard-1) * (sizeOfBoard-1)];
        //init the head
        this.parts[0] = new Snake(headRowStart, headColStart);
    }

    //getters

    public Snake getHead() {
        return this.parts[0];
    }
    
    public Snake[] getParts() {
        return this.parts;
    }

    public int getLeng() {
        return this.leng;
    }
}
