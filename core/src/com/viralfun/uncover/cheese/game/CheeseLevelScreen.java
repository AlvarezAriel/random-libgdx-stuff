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
package com.viralfun.uncover.cheese.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.viralfun.uncover.cheese.menu.CheeseMenuScreen;
import com.viralfun.uncover.shared.BaseScreen;
import com.viralfun.uncover.shared.World;

public class CheeseLevelScreen extends BaseScreen {

    private CheeseActor cheeseActor;
    private BackgroundTileActor backgroundTileActor;
    private MouseActor mouseActor;

    private TimerActor timerActor;
    private WinActor winActor;

    private boolean win;

    public CheeseLevelScreen(Game g) {
        super(g);
    }

    public void create() {
        mainStage = new Stage();
        uiStage = new Stage();

        backgroundTileActor = new BackgroundTileActor();
        backgroundTileActor.initialize();
        mainStage.addActor(backgroundTileActor);

        cheeseActor = new CheeseActor();
        cheeseActor.initialize();
        mainStage.addActor(cheeseActor);

        mouseActor = new MouseActor();
        mouseActor.initialize();
        mainStage.addActor(mouseActor);

        winActor = new WinActor();
        winActor.initialize();
        uiStage.addActor(winActor);

        timerActor = new TimerActor();
        timerActor.initialize();
        uiStage.addActor( timerActor );

        win = false;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.M: {
                game.setScreen( new CheeseMenuScreen(game) );
                break;
            }
            case Input.Keys.P: {
                togglePaused();
                timerActor.setTicking(!isPaused());
                break;
            }
            default: break;
        }
        return false;
    }

    @Override
    public void update(float deltaTime) {
        // check user input
        // check win condition: mouseActor must be overlapping cheese

        Rectangle cheeseRectangle = cheeseActor.getBoundingRectangle();
        Rectangle mouseActorRectangle = mouseActor.getBoundingRectangle();

        if (cheeseRectangle.overlaps(mouseActorRectangle)) {
            win = true;
            cheeseActor.onEat();
        }

        Camera cam = mainStage.getCamera();
        // center camera on player
        cam.position.set( mouseActor.getX() + mouseActor.getOriginX(),
                mouseActor.getY() + mouseActor.getOriginY(), 0 );
        // bound camera to layout
        double viewWidth = Gdx.graphics.getWidth();
        cam.position.x = (float) MathUtils.clamp(cam.position.x, viewWidth /2, World.WIDTH - viewWidth /2);
        double viewHeight = Gdx.graphics.getHeight();
        cam.position.y = (float) MathUtils.clamp(cam.position.y, viewHeight /2, World.HEIGHT - viewHeight /2);
        cam.update();

        if (win) {
            winActor.setVisible(true);
            timerActor.setTicking(false);
        }

    }
}
