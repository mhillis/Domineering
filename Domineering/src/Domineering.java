public class Domineering {
    //for reading from console
    public static final java.util.Scanner INPUT = new java.util.Scanner(System.in);
    private boolean[][] squares;//array of board squares true if occupied
    public static final boolean HORIZONTAL = false;//horizontal player
    public static final boolean VERTICAL = true;//vertical plater

    //The board is initially empty.
    public Domineering(){
        squares = new boolean[8][8];
        //java initializes all array elements to false
    }
    //create and play the game.
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Domineering!");
        Domineering game = new Domineering();
        game.play();
    }

    public String toString(){
        String result = "  0 1 2 3 4 5 6 7";//top numbers
        for(int row = 0; row < 8; row++) {
            result += "\n" + row;//side numbers
            for(int column = 0; column < 8; column++) {
                if(squares[row][column]){
                    result += " #";
                }else{
                    result += " .";
                }
            }
        }
        return result;
    }
    //play until someone wins
    public void play(){
        boolean player = HORIZONTAL;
        while(true){
            System.out.println("\n" + this);
            if(player == HORIZONTAL){
                System.out.println("Horizontal to play");
            }else{
                System.out.println("Vertical to play");
            }
            if (!(hasLegalMoveFor(player))) {
                System.out.println("No legal moves -- YOU LOSE!");
                return;
            }
                System.out.print("Row(0-7): ");
                int row = INPUT.nextInt();
                System.out.print("Column(0-7): ");
                int column = INPUT.nextInt();
                while(!isMoveValid(row, column)){
                    System.out.print("Row(0-7): ");
                    row = INPUT.nextInt();
                    System.out.print("Column(0-7): ");
                    column = INPUT.nextInt();
                }
               // isMoveValid(row, column);
                playAt(row, column, player);
                player = !player;
        }
    }
    //Play a domino with its upper left corner at row,column
    public void playAt(int row, int column, boolean player){
        squares[row][column] = true;
        if(player == HORIZONTAL){
            squares[row][column + 1] = true;
        }else{
            squares[row + 1][column] = true;
        }
    }

    //return true if there is a legal move fore specific player
    public boolean hasLegalMoveFor(boolean player){
        int rowOffset = 0;
        int columnOffset = 0;
        if (player == HORIZONTAL){
            columnOffset = 1;
        }else{
            rowOffset = 1;
        }
        for(int row = 0; row < (8 - rowOffset); row++){
            for(int column = 0; column < (8 - columnOffset); column++){
                if(!(squares[row][column] || squares[row + rowOffset][column + columnOffset])){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isMoveValid(int row, int column){
            int r,c; //for checking overlaps
             //checks if move is on the board
            if (row < 0 || row > 7 || column < 0 || column > 7)
            {
                System.out.println("Invalid move");
                return false;
            }else if (row > 0 || row < 7 || column > 0 || column < 7){//check for overlap
                for(r = 0; r < 8; r++) {
                    for(c = 0; c < 8; c++) {
                        if(squares[r][c]){
                            System.out.println("Invalid move ovarlaps Dominos!");
                            return false;
                        }
                    }
                 } return true;
                }else{return true;}
            }//ismovevalid
        }
           

