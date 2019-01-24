/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

/**
 *
 * @author Brenan
 */
public class Player2 extends Player {
    
    // SpellDatabase spdb = new SpellDatabase();
    
    public Player2(SpriteBatch batch) {
        super(batch);
    }
    
    public void act() {
        getCombSpells();
        takeInput();
        /*for(int i = 0; i < ritual.size(); i++) {
            System.out.print(ritual.get(i));
        }
        System.out.println();*/
    }
    
    public void takeInput() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.W)) {
            ritual.add(0);
            if(ritual.size() <= 9) {
                System.out.print("player 2: ");
                for(int i = 0; i < ritual.size(); i++) {
                    System.out.print(ritual.get(i));
                }
                System.out.println();
            }
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.S)) {
            ritual.add(1);
            if(ritual.size() <= 9) {
                System.out.print("player 2: ");
                for(int i = 0; i < ritual.size(); i++) {
                    System.out.print(ritual.get(i));
                }
                System.out.println();
            }
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.A)) {
            ritual.add(2);
            if(ritual.size() <= 9) {
                System.out.print("player 2: ");
                for(int i = 0; i < ritual.size(); i++) {
                    System.out.print(ritual.get(i));
                }
                System.out.println();
            }
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.D)) {
            ritual.add(3);
            if(ritual.size() <= 9) {
                System.out.print("player 2: ");
                for(int i = 0; i < ritual.size(); i++) {
                    System.out.print(ritual.get(i));
                }
                System.out.println();
            }
        }
        
        if(ritual.size() > 9) {
            ritual.remove(0);
            System.out.print("player 2: ");
            for(int i = 0; i < ritual.size(); i++) {
                System.out.print(ritual.get(i));
            }
            System.out.println();
        }
    }
    
    public void checkSpells(ArrayList <String> incantComb) {
        
    }
    
    public void getCombSpells() {
        String incantation = "";
        for(int i = 0; i < ritual.size() - 1; i++) {
            incantation = Integer.toString(ritual.get(i));
            for(int j = i + 1; j < ritual.size(); j++) {
                incantation = incantation + Integer.toString(ritual.get(j));
                for(int k = 0; k < spdb.getSpellDatabase().size(); k++) {
                    if(incantation.equals(spdb.getSpellDatabase().get(k))) {
                        for(int l = i; l <= j; l++) {
                            ritual.remove(i);
                        }
                        spdb.useIncantation(incantation, this);
                    }
                }
            }
        }
    }
    
    public boolean isPlayer1() {
        return false;
    }
}
