package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {

    Game g;

    SpriteBatch batch;
    Texture background;
    Texture sage;
    Texture wizard;

    Texture arrowUp;
    Texture arrowDown;
    Texture arrowLeft;
    Texture arrowRight;

    Texture darkGreen;

    Texture redOrb;
    Texture blueOrb;
    Texture yellowOrb;
    Texture greenOrb;

    Texture redBox;
    Texture blueBox;
    Texture yellowBox;
    Texture greenBox;
    
    Texture topImg;

    double ratio = 0;

    boolean gameRun;
    boolean menu;
    boolean win;

    BitmapFont font;

    Texture titleScreen;
    Texture controlScreen;

    Texture wasdWin;
    Texture arrowWin;
    
    Sound battleMusic;
    Sound menuMusic;

    @Override
    public void create() {
        batch = new SpriteBatch();
        sage = new Texture("sage.png");
        wizard = new Texture("wizard.png");

        /*arrowUp = new Texture("upArrow.png");
         arrowDown = new Texture("downArrow.png");
         arrowLeft = new Texture("leftArrow.png");
         arrowRight = new Texture("rightArrow.png");*/
        arrowUp = new Texture("redUpArrow.png");
        arrowDown = new Texture("blueDownArrow.png");
        arrowLeft = new Texture("yellowLeftArrow.png");
        arrowRight = new Texture("greenRightArrow.png");

        background = new Texture("background.jpg");
        darkGreen = new Texture("lightGreen.png");

        redOrb = new Texture("redOrb.png");
        blueOrb = new Texture("blueOrb.png");
        yellowOrb = new Texture("yellowOrb.png");
        greenOrb = new Texture("greenOrb.png");

        redBox = new Texture("redBox.jpg");
        blueBox = new Texture("blueBox.jpg");
        yellowBox = new Texture("yellowBox.jpg");
        greenBox = new Texture("greenBox.jpg");

        titleScreen = new Texture("titleScreen.png");
        controlScreen = new Texture("controlScreen.png");

        wasdWin = new Texture("wasdWin.png");
        arrowWin = new Texture("arrowWin.png");
        
        topImg = new Texture("topImg.png");

        // g = new Game();
        font = new BitmapFont();
        font.setColor(0, 0, 0, 256);
        
        battleMusic = Gdx.audio.newSound(Gdx.files.internal("75.mp3"));
        
        menuMusic = Gdx.audio.newSound(Gdx.files.internal("01.mp3"));

        gameRun = false;
        menu = true;
        
        menuMusic.loop();
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        if (gameRun) {
            /*run();
             batch.draw(background, 0, 0);
             batch.draw(sage, 0, 0);
             batch.draw(wizard, 900 - 120, 0);
             drawArrows();
             drawHealth();
             drawOrbs();
             drawShields();*/
            doGameStuff();
        } else {
            doMenuStuff();
            /*if(menu) {
             batch.draw(titleScreen, 0, 0);
             if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
             gameRun = true;
             } else if(Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
             menu = false;
             }
             } else {
             batch.draw(controlScreen, 0, 0);
             if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
             gameRun = true;
             }
             }*/
        }
        batch.end();
        /*run();
         batch.draw(background, 0, 0);
         batch.draw(sage, 0, 0);
         batch.draw(wizard, 900 - 120, 0);
         drawArrows();
         drawHealth();
         drawOrbs();
         drawShields();
         batch.end();*/
    }

    public void run() {
        g.act();
    }

    public void drawArrows() {
        /*for(int i = 0; i < g.player1.ritual.size(); i++) {
         if(g.player1.ritual.get(i).equals((Integer) 0)) {
         batch.draw(arrowUp, 900 - 360 + i * 40, 300, 40, 40);
         } else if(g.player1.ritual.get(i).equals((Integer) 1)) {
         batch.draw(arrowDown, 900 - 360 + i * 40, 300, 40, 40);
         } else if(g.player1.ritual.get(i).equals((Integer) 2)) {
         batch.draw(arrowLeft, 900 - 360 + i * 40, 300, 40, 40);
         } else if(g.player1.ritual.get(i).equals((Integer) 3)) {
         batch.draw(arrowRight, 900 - 360 + i * 40, 300, 40, 40);
         }
         }*/

        for (int i = 0; i < g.player1.ritual.size(); i++) {
            if (g.player1.ritual.get(i).equals((Integer) 0)) {
                batch.draw(arrowUp, 900 - i * 40 - 40, 300, 40, 40);
            } else if (g.player1.ritual.get(i).equals((Integer) 1)) {
                batch.draw(arrowDown, 900 - i * 40 - 40, 300, 40, 40);
            } else if (g.player1.ritual.get(i).equals((Integer) 2)) {
                batch.draw(arrowLeft, 900 - i * 40 - 40, 300, 40, 40);
            } else if (g.player1.ritual.get(i).equals((Integer) 3)) {
                batch.draw(arrowRight, 900 - i * 40 - 40, 300, 40, 40);
            }
        }

        for (int i = 0; i < g.player2.ritual.size(); i++) {
            if (g.player2.ritual.get(i).equals((Integer) 0)) {
                batch.draw(arrowUp, 0 + i * 40, 300, 40, 40);
            } else if (g.player2.ritual.get(i).equals((Integer) 1)) {
                batch.draw(arrowDown, 0 + i * 40, 300, 40, 40);
            } else if (g.player2.ritual.get(i).equals((Integer) 2)) {
                batch.draw(arrowLeft, 0 + i * 40, 300, 40, 40);
            } else if (g.player2.ritual.get(i).equals((Integer) 3)) {
                batch.draw(arrowRight, 0 + i * 40, 300, 40, 40);
            }
        }
    }

    public void drawHealth() {
        ratio = (double) g.player2.health / g.player2.maxHealth;
        batch.draw(darkGreen, 0, 400, (int) (360 * ratio), 40);
        ratio = (double) g.player1.health / g.player1.maxHealth;
        batch.draw(darkGreen, 900 - (int) (360 * ratio), 400, (int) (360 * ratio), 40);
    }

    public void drawOrbs() {
        // player 2
        for (int i = 0; i < g.player2.orbList[0]; i++) {
            batch.draw(redOrb, 10 + 40 * i, 275 - 5, 30, 30);
        }
        for (int i = 0; i < g.player2.orbList[1]; i++) {
            batch.draw(blueOrb, 10 + 40 * i, 225 - 5, 30, 30);
        }
        for (int i = 0; i < g.player2.orbList[2]; i++) {
            batch.draw(yellowOrb, 10 + 40 * i, 175 - 5, 30, 30);
        }
        for (int i = 0; i < g.player2.orbList[3]; i++) {
            batch.draw(greenOrb, 10 + 40 * i, 125 - 5, 30, 30);
        }

        // player 1
        for (int i = 0; i < g.player1.orbList[0]; i++) {
            batch.draw(redOrb, 900 - 10 - 40 * i - 40, 275 - 5, 30, 30);
        }
        for (int i = 0; i < g.player1.orbList[1]; i++) {
            batch.draw(blueOrb, 900 - 10 - 40 * i - 40, 225 - 5, 30, 30);
        }
        for (int i = 0; i < g.player1.orbList[2]; i++) {
            batch.draw(yellowOrb, 900 - 10 - 40 * i - 40, 175 - 5, 30, 30);
        }
        for (int i = 0; i < g.player1.orbList[3]; i++) {
            batch.draw(greenOrb, 900 - 10 - 40 * i - 40, 125 - 5, 30, 30);
        }
    }

    public void drawShields() {
        if (g.player2.shields[0]) {
            batch.draw(redBox, 10, 350, 30, 30);
        }
        if (g.player2.shields[1]) {
            batch.draw(blueBox, 50, 350, 30, 30);
        }
        if (g.player2.shields[2]) {
            batch.draw(yellowBox, 90, 350, 30, 30);
        }
        if (g.player2.shields[3]) {
            batch.draw(greenBox, 130, 350, 30, 30);
        }

        if (g.player1.shields[0]) {
            batch.draw(redBox, 900 - 10 - 30, 350, 30, 30);
        }
        if (g.player1.shields[1]) {
            batch.draw(blueBox, 900 - 50 - 30, 350, 30, 30);
        }
        if (g.player1.shields[2]) {
            batch.draw(yellowBox, 900 - 90 - 30, 350, 30, 30);
        }
        if (g.player1.shields[3]) {
            batch.draw(greenBox, 900 - 130 - 30, 350, 30, 30);
        }
    }

    public void doMenuStuff() {
        if (menu) {
            batch.draw(titleScreen, 0, 0);
            if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                g = new Game(batch);
                gameRun = true;
                menu = false;
                menuMusic.stop();
                long id = battleMusic.loop();
                battleMusic.setVolume(id, 0.25f);
            } else if (Gdx.input.isKeyJustPressed(Input.Keys.Z)) {
                menu = false;
            }
        } else {
            if (win) {
                if(g.player1.health <= 0) {
                    batch.draw(wasdWin, 0, 0);
                } else if(g.player2.health <= 0) {
                    batch.draw(arrowWin, 0, 0);
                }
                if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                    win = false;
                    menu = true;
                }
            } else {
                batch.draw(controlScreen, 0, 0);
                if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                    g = new Game(batch);
                    gameRun = true;
                    menu = false;
                    menuMusic.stop();
                    long id = battleMusic.loop();
                    battleMusic.setVolume(id, 0.25f);
                }
            }
            /*batch.draw(controlScreen, 0, 0);
             if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
             g = new Game();
             gameRun = true;
             menu = false;
             }*/
        }
    }

    public void doGameStuff() {
        run();
        batch.draw(background, 0, 0);
        batch.draw(sage, 0, 0);
        batch.draw(wizard, 900 - 120, 0);
        batch.draw(topImg, 0, 450);
        drawArrows();
        drawHealth();
        drawOrbs();
        drawShields();
        if (g.player1.health <= 0 || g.player2.health <= 0) {
            gameRun = false;
            win = true;
            battleMusic.stop();
            menuMusic.loop();
        } else if(Gdx.input.isKeyJustPressed(Input.Keys.ESCAPE)) {
            gameRun = false;
            menu = true;
            battleMusic.stop();
            menuMusic.loop();
        }
    }
}
