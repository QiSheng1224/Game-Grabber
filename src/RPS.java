package Java.project2Reg.src;

import java.util.Random;

public class RPS extends Game {
   
    public RPS(Random rng, int requiredWins, int maxLosses)
    {
        mRng = rng;
        mRequiredWins = requiredWins;
        mMaxLosses = maxLosses;
    }
    @Override
    public  String getName()
    {
        return "Rock Paper Scissors";
    }
    @Override
    protected String prepToPlay()
    {
        mPlayerWins = 0;
        mComputerWins = 0;
        return "Enter rock, paper, or scissors. Beat me "+mRequiredWins+" times before I win "+mMaxLosses+ " times! ";
    }
    @Override
    protected boolean isOver()
    {
        return mPlayerWins >= mRequiredWins || mComputerWins >= mMaxLosses;
    }
    @Override
    protected boolean isValid(String move)
    {
        move = move.toLowerCase();
        return move.equals("rock") || move.equals("paper") || move.equals("scissors");
    }
    @Override
    protected String processMove(String move)
    {
        //maybe mark as a final member variable?
        String[] randomMoves = new String[]{"rock", "paper", "scissors"};
        String result = "";

        //generate a random move and compare it to the player's move.   
        String computerMove = randomMoves[mRng.nextInt(3)];
        if(computerMove.equals(move))
        {
            result = "we tie";
        }
        else if(computerMove.equals("rock"))
        {
            if(move.equals("paper"))
            {
                result = "you Win";
                mPlayerWins++;
            }
            else
            {
                result = "I Win";
                mComputerWins++;
            }
        }
        else if(computerMove.equals("paper"))
        {
            if(move.equals("scissors"))
            {
                result = "you Win";
                mPlayerWins++;
            }
            else
            {
                result = "I Win";
                mComputerWins++;
            }
        }
        else if(computerMove.equals("scissors"))
        {
            if(move.equals("rock"))
            {
                result = "you Win";
                mPlayerWins++;
            }
            else
            {
                result = "I Win";
                mComputerWins++;
            }
        }
        return computerMove+" vs. "+move+" "+result;
    }
    @Override
    protected String finalMessage()
    {
        if (mPlayerWins >= mRequiredWins)
        {
            return "You win the set";
        }
        return "I win the set";
    }

    private Random mRng;
    private int mRequiredWins;
    private int mMaxLosses;

    private int mPlayerWins;
    private int mComputerWins;
}
