/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

/**
 *
 * @author Brenan
 */
public abstract class Player {
    
    int health;
    int maxHealth;
    
    ArrayList <Integer> ritual;
    
    int[] orbList;
    boolean[] shields;
    
    Player target;
    
    SpellDatabase spdb;
    
    public Player(SpriteBatch batch) {
        ritual = new ArrayList <Integer>();
        spdb = new SpellDatabase(batch);
        orbList = new int[4];
        for(int i = 0; i < orbList.length; i++) {
            orbList[i] = 0;
        }
        
        shields = new boolean[4];
        for(int i = 0; i < shields.length; i++) {
            shields[i] = false;
        }
        
        health = 25;
        maxHealth = 25;
    
    }
    
    public void setTarget(Player target) {
        this.target = target;
    }
    
    public abstract boolean isPlayer1();
}
