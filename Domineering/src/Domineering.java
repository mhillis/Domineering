
/**
 * 
 * 
 * user can still cause error by entering a not interger for row and column
 * (easy fix)
 * 
 * 
 * 
 */
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
            /** NEED TO CHECK IF USER ACTUALLY ENTERS AN INT 
             * 
             * do {
                  try {
                      System.out.print("Enter the number of students: ");
                      students = input.nextInt();
                } catch (InputMismatchException e) {
                    System.out.print("Invalid number of students. ");
                }
                input.nextLine(); // clears the buffer
                } while (students <= 0);
                
            */
              
                System.out.print("Row(0-7): ");
                int row = INPUT.nextInt();
             
            
                System.out.print("Column(0-7): ");
                int column = INPUT.nextInt();
                while(!isMoveValid(row, column, player)){
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

    /** only checking for one side of domino the offset horizontal = right point will still over lap
     *  vice versa vertical bottom point will stll overlap */
    public boolean isMoveValid(int row, int column, boolean player){
        int rowOffset = 0;
        int columnOffset = 0;
        if (player == HORIZONTAL){
            columnOffset = 1;
        }else{
            rowOffset = 1;
        }
             //checks if move is on the board
            if (row < 0 || row > 7 || row + rowOffset < 0 || row + rowOffset > 7 || column < 0 || column > 7|| column + columnOffset < 0 || column + columnOffset > 7)
            {
                System.out.println("Invalid move attempted to place domino off board");
                return false;
                //check if move overlaps a placed domino
            }else if (squares[row][column]  || squares[row + rowOffset][column + columnOffset]){
                            System.out.println("Invalid move ovarlaps Dominos!");
                            return false;
                        }else{return true;}
            }

        }
           

