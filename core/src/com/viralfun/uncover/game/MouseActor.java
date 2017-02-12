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
package com.viralfun.uncover.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;
import com.viralfun.uncover.shared.AnimatedActor;
import com.viralfun.uncover.shared.World;

public class MouseActor extends AnimatedActor {
    @Override
    public void initialize() {
        super.initialize();
        setWidth(60);
        setHeight(80);
        setPosition(80, 80);
        setOrigin(getWidth()/2, getHeight()/2);

        TextureRegion[] frames = new TextureRegion[4];
        for (int n = 0; n < 4; n++)
        {
            String fileName = "mouse" + n + ".png";
            Texture tex = new Texture(Gdx.files.internal(fileName));
            tex.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
            frames[n] = new TextureRegion( tex );
        }
        Array<TextureRegion> framesArray = new Array<TextureRegion>(frames);
        Animation<TextureRegion> anim = new Animation<TextureRegion>(0.1f, framesArray, Animation.PlayMode.LOOP_PINGPONG);
        this.setAnimation(anim);
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

        setX( MathUtils.clamp( getX(), 0, World.WIDTH - getWidth() ));
        setY( MathUtils.clamp( getY(), 0, World.HEIGHT - getHeight() ));
    }
}
