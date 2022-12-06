public class King extends Piece{
    private boolean inCheck;

    public King(String pos, boolean racism) {
        super(pos, racism);
        symbol = 'K';
        inCheck = false;
    }

    // Kings are noobs and can only move one space at a time
    public boolean isValidMove(String targetPos){
        String position = getPosition();

    }











}
