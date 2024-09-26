package Java.project2Reg.src;

import java.util.Random;

public class NumberGuesser extends Game {

    
    public NumberGuesser(Random rng, int maxNumber, int maxGuesses)
    {
        mRng = rng;
        mMaxNumber = maxNumber;
        mMaxGuesses = maxGuesses;
    }
    
    @Override
    public  String getName()
    {
        return "Number Guesser";
    }
    @Override
    protected String prepToPlay()
    {
        mNumber = mRng.nextInt(mMaxNumber) + 1;
        mGuesses = 0;
        mNumberGuessed =0;
        return "I've picked a number 1 to " + mMaxNumber + ". You get " + mMaxGuesses + " guesses to guess it";
    }
    @Override
    protected boolean isOver()
    {
        return mGuesses>=mMaxGuesses || mNumberGuessed==mNumber;
    }
    @Override
    protected boolean isValid(String move)
    {
        //try to parse the move as an integer and return true if it succeeds
        try
        {
            int temp = Integer.parseInt(move);
            mNumberGuessed = temp;
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    @Override
    protected String processMove(String move)
    {
        mGuesses++;
        if(mNumberGuessed==mNumber)
        {
            return "That's it!";
        }
        else if(mNumberGuessed<mNumber)
        {
            return "Too Low";
        }
        else
        {
            return "Too High";
        }
    }
    @Override
    protected String finalMessage()
    {
        return "The number was: " + mNumber;
    }

    private Random mRng;
    private int mMaxNumber;
    private int mMaxGuesses;

    private int mNumber;
    private int mNumberGuessed;
    private int mGuesses;
}