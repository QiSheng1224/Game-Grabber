package Java.project2Reg.src;

import java.util.Scanner;

public abstract class Game {


    /** 
     * initializes the game state
     */
    protected abstract String prepToPlay();
    /**
     *  check if the game is over
     */
    protected abstract boolean isOver();
    /**
     * check if the @param move is correct
     */
    protected abstract boolean isValid(String move);
    /**
     *  updates the game instance with the @param move 
     */
    protected abstract String processMove(String move);
    /**
     *  returns the final message of the game
     */
    protected abstract String finalMessage();
    /**
     * returns the name of the game
     */
    public abstract String getName();



  
    /**
     * The main method. It is the entry point of each game instance
     */
    
    public void play(Scanner user)
    {
        String move = "";
        System.out.println(prepToPlay());
        //game loop
        while(!isOver())
        {
            //get Valid move
            
            System.out.print("Enter Your Move or 'quit' to quit> ");
            if(user.hasNext())
            {
                move = user.next();
                if(move.equals("quit"))
                {
                    break;
                }
                while(!isValid(move))
                {
                    System.out.print("Invalid Move! try again> ");
                    move = user.next();
                }
            }
            String tempMove = processMove(move);
            if(tempMove==null || tempMove.equals(""))
            {
                continue;
            }
            else{
                System.out.println(tempMove);
            }
        }
        System.out.println(finalMessage());
    }

}
