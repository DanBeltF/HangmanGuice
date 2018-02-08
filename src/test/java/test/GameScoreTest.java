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
    
    public GameScoreTest() {
    }
    
    @Before
    public void init() {
    }
    
    @Test
    public void testClaseEquivalenciaUno(){
        OriginalScore os = new OriginalScore();
        
        qt().forAll(integers().allPositive().describedAs(c -> "Correct = " + c)
                   ,integers().between(0, 10).describedAs(i -> "Incorrect = " + i))
        .check((c,i) -> os.calculateScore(c,i) == i*-10 && os.calculateScore(c,i) >= 0);
    }
    
    @Test
    public void testClaseEquivalenciaDos(){
        BonusScore bs = new BonusScore();
        
        qt().forAll(integers().allPositive().describedAs(c -> "Correct = " + c)
                   ,integers().allPositive().describedAs(i -> "Incorrect = " + i))
        .check((c,i) -> bs.calculateScore(c,i) == (c*10)+(i*-5) && bs.calculateScore(c,i) >= 0);
    }
    
    @Test
    public void testClaseEquivalenciaTres(){
        PowerScore ps = new PowerScore();
        
        qt().forAll(integers().allPositive().describedAs(c -> "Correct = " + c)
                   ,integers().allPositive().describedAs(i -> "Incorrect = " + i))
        .check((c,i) -> ps.calculateScore(c,i) == (5^c)+(i*-8) && ps.calculateScore(c,i) >= 0 && ps.calculateScore(c,i) <= 500);
    }
}