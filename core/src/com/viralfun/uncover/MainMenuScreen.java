//
// Copyright 2016 by Grindr LLC,
// All rights reserved.
//
// This software is confidential and proprietary information of
// Grindr LLC ("Confidential Information").
// You shall not disclose such Confidential Information and shall use
// it only in accordance with the terms of the license agreement
// you entered into with Grindr LLC.
//
package com.viralfun.uncover;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.viralfun.uncover.balloon.BalloonLevel;
import com.viralfun.uncover.cheese.game.BackgroundTileActor;
import com.viralfun.uncover.cheese.game.CheeseLevelScreen;
import com.viralfun.uncover.cheese.menu.CheeseMenuScreen;
import com.viralfun.uncover.plataformer.PlatformerScreen;
import com.viralfun.uncover.shared.BaseActor;
import com.viralfun.uncover.shared.BaseScreen;

public class MainMenuScreen extends BaseScreen {

    public MainMenuScreen(Game g) {
        super(g);
    }

    public void create() {
        uiStage = new Stage();
        BackgroundTileActor backgroundTileActor = new BackgroundTileActor();
        backgroundTileActor.initialize();
        uiStage.addActor(backgroundTileActor);

        addOptionToMenu("balloon", 1, 150);
        addOptionToMenu("cheese", 2, 100);
        addOptionToMenu("square", 3, 50);
    }

    private void addOptionToMenu(String description, int number, float ypos) {
        BitmapFont font = new BitmapFont();
        String text = number + " for " + description;
        Label.LabelStyle style = new Label.LabelStyle(font, Color.YELLOW);
        Label instructions = new Label(text, style);
        instructions.setFontScale(2);
        instructions.setPosition(100, ypos);
        uiStage.addActor(instructions);
    }

    public void update(float dt) {

    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.NUM_3: {
                game.setScreen(new PlatformerScreen(game));
                break;
            }            case Input.Keys.NUM_2: {
                game.setScreen(new CheeseMenuScreen(game));
                break;
            }
            case Input.Keys.NUM_1: {
                game.setScreen(new BalloonLevel(game));
                break;
            }
            default: break;
        }
        return false;
    }
}
