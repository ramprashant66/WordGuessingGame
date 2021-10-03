package com.company.view;

import java.util.Scanner;

public class CmdLineView {

    private String[] letters;
    private String theGuess;

    public CmdLineView(String[] letters) {
        this.letters = letters;
    }



    //Printing that the user guessed incorrectly and the number of guesses remaining.
    public void incorrectGuess(int numGuesses)
    {
        System.out.println("Incorrect guess! Number of tries remaining: " + numGuesses);
        if (numGuesses == 0) //no more guesses left
        {
            System.out.println("\nThe game has ended! The correct word was: " );
            for (String letter : letters)
            {
                System.out.print(letter); //printing out the word
            }
        }
    }

    //Printing that the user has successfully guessed the word.
    public void won()
    {
        System.out.println("Congratulations! You guessed the word correctly!");
    }
    //prints out the number of dashes/ length of word
    public void startGame() {
        System.out.println("Guess the word \n");
        for(int i = 0; i < letters.length; i++){
            System.out.print("_ ");
        }
        System.out.print("\n");
    }

    public String makeAGuess(){
        System.out.println("Guess a letter: ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }

    public void displayHints(String[] hints){
        for(String hint: hints){
            System.out.print(hint);
        }
        System.out.print("\n");
    }

    public void cheat(String theWord){
        System.out.println("The word is " + theWord + ".");
    }

    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public String getTheGuess() {
        return theGuess;
    }

    public void setTheGuess(String theGuess) {
        this.theGuess = theGuess;
    }
}
