import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static Logger logger = LoggerFactory.getLogger(Game.class);
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();

    public void play() {
        //start game
        printGameRules();
        String choice = input.nextLine().toUpperCase();

        ScoreBoard scoreBoard = new ScoreBoard();

        while (!choice.equals("QUIT")) //do the following if the user does not put in "quit"
        {
            GameOption choicenum = getChoiceNum(choice);
            while(choicenum == null) //continue while user input is still not valid
            {
                System.out.println("Sorry, it looks like you didn't enter a correct input. Try again.");
                choice = input.nextLine().toUpperCase();
                choicenum = getChoiceNum(choice);
            }
            GameOption compnum = getComputerChoice();
            completeGamePlay(scoreBoard, choicenum, compnum);
            printResults(scoreBoard);
            choice = input.nextLine().toUpperCase(); //prompt for new user input
        }
    }

    private void printResults(ScoreBoard scoreBoard) {
        System.out.println("wins:" + scoreBoard.getWins() + "\nloses:" + scoreBoard.getLosses() + "\nties:" + scoreBoard.getTies()); //print out number of wins, ties, and loses
        System.out.println("Let's play again! \n \n"); //start game again
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private void completeGamePlay(ScoreBoard scoreBoard, GameOption choicenum, GameOption compnum) {
        if(choicenum == compnum) //tie cases
        {
            System.out.println("It's a tie");
            scoreBoard.incTies();
        }
        else if (choicenum == GameOption.ROCK && compnum == GameOption.SCISSORS
                || choicenum == GameOption.SCISSORS && compnum == GameOption.PAPER
                ||choicenum == GameOption.PAPER && compnum == GameOption.ROCK)
        {
            System.out.println("you win!");
            scoreBoard.incWins();
        }
        else
        {
            System.out.println("you lose.");
            scoreBoard.incLosses();
        }
    }

    private GameOption getChoiceNum(String choice) {
        GameOption selectedOption = null;

        if (choice.equals("QUIT")) {
            System.exit(0);
        }

        try {
            selectedOption = GameOption.valueOf(choice);
        } catch (Exception e) {
            return null;
        }
        return selectedOption;
    }
    public GameOption getComputerChoice() {
        int randomValue = random.nextInt(3);//computer generate random num
        GameOption option = GameOption.values()[randomValue];
        System.out.println("Computer chose " + option.toString().toLowerCase());
        return option;
    }

    private void printGameRules() {
        System.out.println("Let's play Rock, Paper, Scissors!");
        System.out.println("Say \"Rock\", \"Paper\", or \"Scissors\" to indicate your choice. Otherwise say \"Quit\" to quit.");
    }

    private class ScoreBoard {
        private Integer ties = 0;
        private Integer wins = 0;
        private Integer losses = 0;

        public Integer getTies() {
            return ties;
        }

        public void incTies() {
            this.ties++;
        }

        public Integer getWins() {
            return wins;
        }

        public void incWins() {
            this.wins++;
        }

        public Integer getLosses() {
            return losses;
        }

        public void incLosses() {
            this.losses++;
        }
    }
}
