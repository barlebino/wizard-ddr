/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import java.util.ArrayList;

/**
 *
 * @author Brenan
 */
public class SpellDatabase {
    ArrayList <String> spellDatabase;
    
    Sound oneOrb;
    Sound twoOrbs;
    Sound threeOrbs;
    Sound loadOrb;
    Sound makeShield;
    Sound useShield;
    
    Texture hit;
    
    SpriteBatch batch;
    
    public SpellDatabase(SpriteBatch batch) {
        spellDatabase = new ArrayList <String>();
        /*spellDatabase.add("10101");
        spellDatabase.add("23232");
        spellDatabase.add("0000"); // original 000000000
        spellDatabase.add("1111");
        spellDatabase.add("2222");
        spellDatabase.add("3333");
        spellDatabase.add("00020002");
        spellDatabase.add("11131113");
        spellDatabase.add("33303330");
        spellDatabase.add("22212221");
        spellDatabase.add("002002002");
        spellDatabase.add("0020022");
        spellDatabase.add("0022");
        spellDatabase.add("113113113");
        spellDatabase.add("1131133");
        spellDatabase.add("1133");
        spellDatabase.add("330330330");
        spellDatabase.add("3303300");
        spellDatabase.add("3300");
        spellDatabase.add("221221221");
        spellDatabase.add("2212211");
        spellDatabase.add("2211");*/
        spellDatabase.add("10101");
        spellDatabase.add("23232");
        spellDatabase.add("0000"); // original 000000000
        spellDatabase.add("1111");
        spellDatabase.add("2222");
        spellDatabase.add("3333");
        spellDatabase.add("00010001");
        spellDatabase.add("11101110");
        spellDatabase.add("22232223");
        spellDatabase.add("33323332");
        spellDatabase.add("001001001");
        spellDatabase.add("0010011");
        spellDatabase.add("0011");
        spellDatabase.add("110110110");
        spellDatabase.add("1101100");
        spellDatabase.add("1100");
        spellDatabase.add("223223223");
        spellDatabase.add("2232233");
        spellDatabase.add("2233");
        spellDatabase.add("332332332");
        spellDatabase.add("3323322");
        spellDatabase.add("3322");
        
        oneOrb = Gdx.audio.newSound(Gdx.files.internal("oneOrb.mp3"));
        twoOrbs = Gdx.audio.newSound(Gdx.files.internal("twoOrbs.mp3"));
        threeOrbs = Gdx.audio.newSound(Gdx.files.internal("threeOrbs.mp3"));
        loadOrb = Gdx.audio.newSound(Gdx.files.internal("loadOrb.mp3"));
        makeShield = Gdx.audio.newSound(Gdx.files.internal("makeShield.mp3"));
        useShield = Gdx.audio.newSound(Gdx.files.internal("useShield.mp3"));
        
        hit = new Texture("redBox.jpg");
        
        this.batch = batch;
    }
    
    public ArrayList <String> getSpellDatabase() {
        return spellDatabase;
    }
    
    public void useIncantation(String s, Player p) {
        System.out.print("used incantation");
        
        if(p.isPlayer1()) {
            System.out.println(" by player 1");
        } else {
            System.out.println(" by player 2");
        }
        
        if(s.equals("101010101")) {
            if(p.health < 100) {
                p.health++;
            }
            System.out.println("healing");
        } else if(s.equals("010101010")) {
            p.target.health--;
            System.out.println("attacking");
        } 
        // shield spells
        else if(s.equals("0000")) {
            if(!p.shields[0]) {
               makeShield.play(); 
            }
            p.shields[0] = true;
            System.out.println("fire shield");
        } else if(s.equals("1111")) {
            if(!p.shields[1]) {
               makeShield.play(); 
            }
            p.shields[1] = true;
            System.out.println("water shield");
        } else if(s.equals("2222")) {
            if(!p.shields[2]) {
               makeShield.play(); 
            }
            p.shields[2] = true;
            System.out.println("wind shield");
        } else if(s.equals("3333")) {
            if(!p.shields[3]) {
               makeShield.play(); 
            }
            p.shields[3] = true;
            System.out.println("earth shield");
        } 
        // orb summon
        else if(s.equals("00010001") && p.orbList[0] < 3) {
            loadOrb.play();
            p.orbList[0]++;
            System.out.println("fire orb");
        } else if(s.equals("11101110") && p.orbList[1] < 3) {
            loadOrb.play();
            p.orbList[1]++;
            System.out.println("water orb");
        } else if(s.equals("22232223") && p.orbList[2] < 3) {
            loadOrb.play();
            p.orbList[2]++;
            System.out.println("wind orb");
        } else if(s.equals("33323332") && p.orbList[3] < 3) {
            loadOrb.play();
            p.orbList[3]++;
            System.out.println("earth orb");
        } 
        // attack spells
        else if(s.equals("001001001") && p.orbList[0] >= 3) {
            p.orbList[0] = p.orbList[0] - 3;
            if(p.target.shields[0]) {
                useShield.play();
                p.target.shields[0] = false;
            } else {
                threeOrbs.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 12;
            }
            System.out.println("fire attack 3");
        } else if(s.equals("0010011") && p.orbList[0] >= 2) {
            p.orbList[0] = p.orbList[0] - 2;
            if(p.target.shields[0]) {
                useShield.play();
                p.target.shields[0] = false;
            } else {
                twoOrbs.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 4;
            }
            System.out.println("fire attack 2");
        } else if(s.equals("0011") && p.orbList[0] >= 1) {
            p.orbList[0] = p.orbList[0] - 1;
            if(p.target.shields[0]) {
                useShield.play();
                p.target.shields[0] = false;
            } else {
                oneOrb.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 2;
            }
            System.out.println("fire attack 1");
        } else if(s.equals("110110110") && p.orbList[1] >= 3) {
            p.orbList[1] = p.orbList[1] - 3;
            if(p.target.shields[1]) {
                useShield.play();
                p.target.shields[1] = false;
            } else {
                threeOrbs.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 12;
            }
            System.out.println("water attack 3");
        } else if(s.equals("1101100") && p.orbList[1] >= 2) {
            p.orbList[1] = p.orbList[1] - 2;
            if(p.target.shields[1]) {
                useShield.play();
                p.target.shields[1] = false;
            } else {
                twoOrbs.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 4;
            }
            System.out.println("water attack 2");
        } else if(s.equals("1100") && p.orbList[1] >= 1) {
            p.orbList[1] = p.orbList[1] - 1;
            if(p.target.shields[1]) {
                useShield.play();
                p.target.shields[1] = false;
            } else {
                oneOrb.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 2;
            }
            System.out.println("water attack 1");
        } else if(s.equals("223223223") && p.orbList[2] >= 3) {
            p.orbList[2] = p.orbList[2] - 3;
            if(p.target.shields[2]) {
                useShield.play();
                p.target.shields[2] = false;
            } else {
                threeOrbs.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 12;
            }
            System.out.println("wind attack 3");
        } else if(s.equals("2232233") && p.orbList[2] >= 2) {
            p.orbList[2] = p.orbList[2] - 2;
            if(p.target.shields[2]) {
                useShield.play();
                p.target.shields[2] = false;
            } else {
                twoOrbs.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 4;
            }
            System.out.println("wind attack 2");
        } else if(s.equals("2233") && p.orbList[2] >= 1) {
            p.orbList[2] = p.orbList[2] - 1;
            if(p.target.shields[2]) {
                useShield.play();
                p.target.shields[2] = false;
            } else {
                oneOrb.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 2;
            }
            System.out.println("wind attack 1");
        } else if(s.equals("332332332") && p.orbList[3] >= 3) {
            p.orbList[3] = p.orbList[3] - 3;
            if(p.target.shields[3]) {
                useShield.play();
                p.target.shields[3] = false;
            } else {
                threeOrbs.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 12;
            }
            System.out.println("earth attack 3");
        } else if(s.equals("3323322") && p.orbList[3] >= 2) {
            p.orbList[3] = p.orbList[3] - 2;
            if(p.target.shields[3]) {
                useShield.play();
                p.target.shields[3] = false;
            } else {
                twoOrbs.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 4;
            }
            System.out.println("earth attack 2");
        } else if(s.equals("3322") && p.orbList[3] >= 1) {
            p.orbList[3] = p.orbList[3] - 1;
            if(p.target.shields[3]) {
                useShield.play();
                p.target.shields[3] = false;
            } else {
                oneOrb.play();
                //batch.draw(hit, 0, 0);
                p.target.health = p.target.health - 2;
            }
            System.out.println("earth attack 1");
        }
        
        if(p.target.health < 0) {
            p.target.health = 0;
        }
    }
}
