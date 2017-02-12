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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;

public class MouseActor extends BaseActor {
    @Override
    public void initialize() {
        super.initialize();
        this.setTexture(new Texture(Gdx.files.internal("mouse.png")));
        setWidth(40);
        setHeight(40);
        setPosition(80, 80);
    }

    @Override
    public void act(float dt) {
        super.act(dt);
        velocityX = 0;
        velocityY = 0;

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            velocityX = -100;
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            velocityX = 100;
        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            velocityY = 100;
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            velocityY = -100;
    }
}
