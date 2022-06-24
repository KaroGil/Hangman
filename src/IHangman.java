package Hangman.src;

import java.util.ArrayList;

public interface IHangman {
    
    /*
     * gets the word to guess
     */
    String getWord();

    /**
     * sets the word to guess
     */
    void setWord(String word);

    /**
     * 
     * @return  how many turns the player gets
     */
    int getTries();

    /**
     * 
     * @return true if the letter is in the alphabet, false otherwise
     */
    boolean checkLetterInAlphabet(char letter);

    /**
     * checks if the player has lost.
     * @return true if tries are up, false otherwise
     */
    boolean checkLoose();

    /**
     * 
     * @return if letter in word true, else false
     */
    boolean checkIfLetterInWord(char letter);


    /**
     * changes the part of the word the players sees.
     */
    void changeViewWord(char letterGuessed,  int index);

    /**
     * gets the list of letters the player has already guessed.
     * @return guessedLetter list
     */
    ArrayList<Character> getLettersGuessedList();

    /**
     * adds a guessed letter to the gussed letter list
     */
    void addLetterGuessed(Character letter);

}
