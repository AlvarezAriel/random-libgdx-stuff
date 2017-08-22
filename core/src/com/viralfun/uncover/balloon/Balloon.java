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
package com.viralfun.uncover.balloon;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.viralfun.uncover.shared.BaseActor;

public class Balloon extends BaseActor {
    public float speed;
    public float amplitude;
    public float oscillation;
    public float initialY;
    public float time;
    public int offsetX;

    public Balloon() {
        initialize();
        speed = 80 * MathUtils.random(0.5f, 2.0f);
        amplitude = 50 * MathUtils.random(0.5f, 2.0f);
        oscillation = 0.01f * MathUtils.random(0.5f, 2.0f);
        initialY = 120 * MathUtils.random(0.5f, 2.0f);
        time = 0;
        offsetX = -100;
        setTexture(new Texture( Gdx.files.internal("balloon.png")));
        setScale(0.2f, 0.2f);
        // initial spawn location off-screen
        setX(offsetX);
    }

    public void act(float dt) {
        super.act(dt);
        time += dt;
        // set starting location to left of window
        float xPos = speed * time + offsetX;
        float yPos = amplitude * MathUtils.sin(oscillation
                * xPos) + initialY;
        setPosition(xPos, yPos);
    }
}