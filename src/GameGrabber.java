package Java.project2Reg.src;

import java.util.Random;
import java.util.Scanner;

public class GameGrabber {
    public GameGrabber(Game[] games, Scanner user)
    {
        mGames =  new Game[games.length];
        mGames = games;
        mPlayer = user;
    }
    /**
     * This method will allow the user to select a game to play.
     */
    public void doMenu()
    {
        int choice = 0;
        while(choice != mGames.length)
        {
            //Prints out the menu
            for(int i =0; i < mGames.length; i++)
            {
                System.out.println(i+") "+mGames[i].getName());
            }
            System.out.println(mGames.length+") Quit");
            System.out.print("Pick a game (0-"+mGames.length+") ");

            //get valid input for game
            choice = mPlayer.nextInt();
            while(choice>mGames.length || choice<0)
            {
                System.out.print("Pick a game (0-"+mGames.length+") ");
                choice = mPlayer.nextInt();
            }

            //run the game
            if (choice == mGames.length)
            {
                System.out.println("goodbye");
            }
            else
            {
                mGames[choice].play(mPlayer);
            }
        }
    }
    public Game[] getGames()
    {
        return mGames;
    }

    
    public static void main(String[] args)
    {
        Game[] games = new Game[4];
        Random rng = new Random();
        games[0] = new Hangman(new WordsList(rng), 5, 10, 20);
        games[1] = new NumberGuesser(rng, 100, 8);
        games[2] = new RPS(rng, 2,2);
        games[3] = new WordJumble(new WordsList(rng),rng, 3, 10, 8);
        GameGrabber grabber = new GameGrabber(games, new Scanner(System.in));
        grabber.doMenu();
    }
    private Game[] mGames;
    private Scanner mPlayer;

}