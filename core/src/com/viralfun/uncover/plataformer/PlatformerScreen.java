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
package com.viralfun.uncover.plataformer;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.math.MathUtils;
import com.viralfun.uncover.shared.BaseScreen;

public class PlatformerScreen  extends BaseScreen {
    private PlatformerBackground background;
    private PlayerActor ball;

    public PlatformerScreen(Game g) {
        super(g);
    }

    @Override
    protected void create() {
        background = new PlatformerBackground();
        background.initialize();
        mainStage.addActor(background);

        ball = new PlayerActor();
        ball.initialize();
        mainStage.addActor(ball);

    }

    @Override
    public void update(float dt) {
        Camera cam = mainStage.getCamera();
        // center camera on player
        cam.position.set( ball.getX() + ball.getOriginX(),
                ball.getY() + ball.getOriginY(), 0 );
        // bound camera to layout
        double viewWidth = Gdx.graphics.getWidth();
        cam.position.x = (float) MathUtils.clamp(cam.position.x, viewWidth /2, background.getWidth() - viewWidth /2);
        double viewHeight = Gdx.graphics.getHeight();
        cam.position.y = (float) MathUtils.clamp(cam.position.y, viewHeight /2, background.getHeight() - viewHeight /2);
        cam.update();

        float x = ball.getX();
        float y = ball.getY();

//        background.region.getTexture().

        if (ball.getX() >= background.getWidth()) {
            ball.velocityX = 0;
            ball.setX(background.getWidth() - 1);
        }

        if (ball.getY() + ball.getHeight() >= background.getHeight()) {
            ball.velocityY = 0;
            ball.setY(background.getHeight() - ball.getHeight() - 1);
        }
    }
}
