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
package com.viralfun.uncover.menu;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.viralfun.uncover.game.BackgroundTileActor;
import com.viralfun.uncover.game.CheeseLevelScreen;
import com.viralfun.uncover.shared.BaseActor;

public class CheeseMenuScreen implements Screen {
    private Stage uiStage;
    private Game game;

    public CheeseMenuScreen(Game g) {
        game = g;
        create();
    }

    public void create() {
        uiStage = new Stage();
        BackgroundTileActor backgroundTileActor = new BackgroundTileActor();
        backgroundTileActor.initialize();
        uiStage.addActor(backgroundTileActor);
        BaseActor titleText = new BaseActor();
        titleText.initialize();
        titleText.setTexture(new Texture(Gdx.files.internal("cheese-please.png")));
        titleText.setPosition(20, 100);
        uiStage.addActor(titleText);
        BitmapFont font = new BitmapFont();
        String text = " Press S to start, M for main menu ";
        Label.LabelStyle style = new Label.LabelStyle(font, Color.YELLOW);
        Label instructions = new Label(text, style);
        instructions.setFontScale(2);
        instructions.setPosition(100, 50);
// repeating color pulse effect
        instructions.addAction(
                Actions.forever(
                        Actions.sequence(
                                Actions.color(new Color(1, 1, 0, 1), 0.5f),
                                Actions.delay(0.5f),
                                Actions.color(new Color(0.5f, 0.5f, 0, 1), 0.5f)
                        )
                )
        );
        uiStage.addActor(instructions);
    }

    public void render(float dt) {
        // process input
        if (Gdx.input.isKeyPressed(Input.Keys.S))
            game.setScreen(new CheeseLevelScreen(game));
        // update
        uiStage.act(dt);
        // draw graphics
        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        uiStage.draw();
    }

    public void resize(int width, int height) {
    }

    public void pause() {
    }

    public void resume() {
    }

    public void dispose() {
    }

    public void show() {
    }

    public void hide() {
    }
}
