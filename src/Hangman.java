package Hangman.src;


import java.util.ArrayList;

import hangman_local.Ihangman;


public class Hangman implements Ihangman{
    private String wordToGuess;
    private int tries;
    private ArrayList<Character> wordGuessedList;
    private ArrayList<Character> charList;

    public Hangman(String wordToGuess, int tries){
        this.wordToGuess = wordToGuess.toUpperCase();
        this.tries = tries;
        charList = new ArrayList<>();
        wordGuessedList = new ArrayList<>();

        for (int i = 0; i < wordToGuess.length(); i++) {
            if(wordToGuess.charAt(i) == ' '){
                wordGuessedList.add(' ');
            }
            else{
                wordGuessedList.add('_');
            }
        }

        System.out.println(wordToGuess);
    }

    @Override
    public String getWord() {
        return this.wordToGuess;
    }

    @Override
    public void setWord(String word) {
        this.wordToGuess = word;
    }

    public ArrayList<Character> getWordList(){
        return wordGuessedList;
    }

    @Override
    public int getTries() {
        return this.tries;
    }

    @Override
    public boolean checkLetterInAlphabet( char letter) {
        if((letter >= 'a' && letter <= 'z') || (letter >= 'A' && letter <= 'Z')){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkLoose() {
        if(tries <= 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkIfLetterInWord(char letter) {
        int count = 0;
        if(checkLetterInAlphabet(letter)){
            for (int i = 0; i < wordToGuess.length(); i++) {
                if(wordToGuess.charAt(i) == letter){
                    return true;
                }
                else{
                    count++;
                }
            }
        }
        if(count == wordToGuess.length()){
            tries -=1;    
        }
        return false;
    }

    @Override
    public void changeViewWord(char letterGuessed, int index) {
        if(checkIfLetterInWord(letterGuessed)){
        wordGuessedList.set(index, letterGuessed);
        }
    }

    public boolean checkWin(){
        if(!wordGuessedList.contains('_')){
            return true;
        }
        return false;
    }

    public ArrayList<Character> convertToCharArray(){
        for (int i = 0; i < wordToGuess.length(); i++) {
           charList.add(wordToGuess.charAt(i));
        }
        return charList;
    }
    
}
