package com.company.controller;

import com.company.models.WordList;
import com.company.view.CmdLineView;

import java.util.Arrays;

public class Main {

    public static String[] letters;
    public static int numLetters = 0;
    public static int numGuesses;
    public static String theGuess;
    public static String[] hints;
    public static CmdLineView view;

    public static void main(String[] args) {

        numGuesses = 6;

        GetWord getWord = new GetWord();
        String theWord = getWord.getTheWord();

        WordList word = new WordList(theWord);

        letters = calculateLetters(word.getTheWord());

        view = new CmdLineView(letters);
        view.startGame(); //prints out dashes/length of word
        view.cheat(word.getTheWord()); //shows the word

        String[] finals = new String[letters.length]; //declaring an array which will hold the final word

        Arrays.fill(finals, "_"); //filling our final array with "_"

        while (numGuesses > 0) //looping until numGuesses reaches 0
        {
            hints = guess(finals, letters.length); //gets the letter, compares and returns the finals array

            //This block gets executed until the user has no more guesses left.
            if (numGuesses != 0)
            {
                view.displayHints(finals); //prints the final array each time to see the progress.
            }

           boolean gameEnd = compareArrays(finals, letters); //returning the state of the game
            if (gameEnd) //if true,
            {
                view.won();//the user won
                return; //breaking out of the loop.
            }
        }
    }

    //This function compares the final array and the letters array to see if the user has a completed word.
    private static boolean compareArrays(String[] finalsArray, String[] lettersArray)
    {
        return Arrays.equals(finalsArray, lettersArray);
    }

    private static String[] calculateLetters(String theWord) {
        String[] letters = theWord.split("");
        numLetters = letters.length;
        return letters;
    }

    private static String[] guess(String[] finals, int size)
    {
        theGuess = view.makeAGuess(); //gets the user's guess

        String endGame = "start"; //initial string.

        String[] hints = new String[letters.length]; //re-declares the array each time

        //loop runs for the size of the array (number of letters in the word.
        for (int i = 0; i < size; i++)
        {
            if (letters[i].equals(theGuess)) //checks each index of letters array to see it matches the user's guess
            {
                hints[i] = theGuess; //stores the correct letter guessed in the hints array.
                finals[i] = hints[i]; //clones the data from the hint's array into my final array
                endGame = "doNotDecrement"; //this stops from decrementing numGuesses
            }

        }

        //if the endGame is not equal to "doNotDecrement", that means the user did not guess the correct letter.
        if (!(endGame.equals("doNotDecrement")))
        {
            numGuesses--; //hence, we decrement by one.
            view.incorrectGuess(numGuesses);
        }

        return finals; //returning finals array

    }
}

