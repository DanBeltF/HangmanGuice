/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import hangman.model.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.quicktheories.core.Gen;
import org.quicktheories.generators.Generate;
import org.quicktheories.generators.Lists;

import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;
import hangman.model.GameModel;
import java.util.Objects;

/**
 *
 * @author 2104784
 */

/**
 * Diseno de pruebas:
 * 
 * Clases de equivalencia:
 *  
 *      CE1: Descripción: gameScore = 100, correctCount ==> gameScore + 0, incorrectCount ==> gameScore - 10
 *           Resultado esperado: gameScore >= 0
 *          
 *      CE2: Descripción: gameScore = 0, correctCount ==> gameScore + 10, incorrectCount ==> gameScore - 5
 *           Resultado esperado: gameScore >= 0
 * 
 *      CE3: Descripción: gameScore = 0, correctCount ==> gameScore + 5^i, incorrectCount ==> gameScore - 8
 *           Resultado esperado: 0 <= gameScore <= 500
 *  
 */

public class GameScoreTest {
        
    private int score1;
    private int score2;
    
    @Before
    public void init() {
        score1=100;
        score2=0;
    }
    
    @Test
    public void testClaseEquivalenciaUno(){
        OriginalScore os = new OriginalScore();
        
        qt().forAll(range(0, 10).describedAs(c -> "Correct = " + c)
                   ,range(0, 10).describedAs(i -> "Incorrect = " + i))
        .check((c,i) -> {
            return os.calculateScore(c,i) == score1 + (i*(-10)) && os.calculateScore(c,i) >= 0 && os.calculateScore(c,i) <= 100;});
    }
    
    @Test
    public void testClaseEquivalenciaDos(){
        BonusScore bs = new BonusScore();
        
        qt().forAll(range(0, 10).describedAs(c -> "Correct = " + c)
                   ,range(0, 10).describedAs(i -> "Incorrect = " + i))
        .check((c,i) -> {
            int calc = (c*10)+(i*-5);
            if (calc < 0)calc=0;
            return bs.calculateScore(c,i) == calc && bs.calculateScore(c,i) >= 0;});
    }
    
    @Test
    public void testClaseEquivalenciaTres(){
        PowerScore ps = new PowerScore();
        
        qt().forAll(range(1, 10).describedAs(c -> "Correct = " + c)
                   ,range(1, 10).describedAs(i -> "Incorrect = " + i))
        .assuming((c,i) -> c!=i)
        .check((c,i) -> {
            int calc = (int) (Math.pow((double)5, (double)c)+(i*-8));
            if (calc < 0)calc=0;
            if (calc > 500)calc=500;
            return ps.calculateScore(c,i) == calc && ps.calculateScore(c,i) >= 0 && ps.calculateScore(c,i) <= 500;});
    }
}