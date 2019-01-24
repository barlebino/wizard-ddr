/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 *
 * @author Brenan
 */
public class Game {
    
    Player1 player1;
    Player2 player2;
    
    public Game(SpriteBatch batch) {
        initPlayers(batch);
    }
    
    public void initPlayers(SpriteBatch batch) {
        player1 = new Player1(batch);
        player2 = new Player2(batch);
        player1.setTarget(player2);
        player2.setTarget(player1);
    }
    
    public void act() {
        player1.act();
        player2.act();
    }
}
