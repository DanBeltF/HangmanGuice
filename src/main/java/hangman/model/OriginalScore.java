/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.model;

import hangman.model.GameModel;

/**
 *
 * @author 2104784
 */
public class OriginalScore implements GameScore{
    
    /**
     * El juego inicia con 100 p
     * @pre correctCount >=0 & incorrectCount >=0
     * @pos 0 <= puntaje <= 100
     * @param correctCount - cantidad acertadas
     * @param incorrectCount - cantidad fallas
     * @return el puntaje alcanzado penalizando cada letra incorrecta con 10 p
     */
    @Override
    public int calculateScore(int correctCount, int incorrectCount) {
        int gameScore=100;
        gameScore += (incorrectCount*(-10));
        return gameScore<0?gameScore=0:gameScore;
    }
    
}
