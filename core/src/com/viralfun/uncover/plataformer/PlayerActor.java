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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.viralfun.uncover.shared.BaseActor;
import com.viralfun.uncover.shared.World;

public class PlayerActor extends BaseActor {

    @Override
    public void initialize() {
        super.initialize();

        final int width = 40;
        final int height = 40;
        setWidth(width);
        setHeight(height);
        setPosition(80, 80);
        setOrigin(getWidth() / 2, getHeight() / 2);

        Pixmap pixmap = new Pixmap(width, height, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.BLACK);
        pixmap.fillCircle(width/2, (width-1)/2, (width-1)/2);
        Texture texture = new Texture(pixmap);

        setTexture(texture);
    }


    private final int velocityIncrement = 3;
    private final int gravity = 10;
    private final int STANDING = 0;
    private final int ASCENDING = 1;
    private final int DESCENDING= 2;

    private int jumpState = STANDING;

    @Override
    public void act(float dt) {
//        velocityX = 0;
//        velocityY = 0;

        switch (jumpState){
            case STANDING: {
                if (Gdx.input.isKeyPressed(Input.Keys.SPACE)) {
                    velocityY = 200;
                    jumpState = ASCENDING;
                }
                break;
            }
            case ASCENDING: {
                velocityY -= gravity;
                if (velocityY < 0) {
                    jumpState = DESCENDING;
                }
                break;
            }
            case DESCENDING: {
                if (velocityY == 0) {
                    jumpState = STANDING;
                    break;
                }
                velocityY -= gravity;
                break;
            }
        }

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT))
            velocityX = MathUtils.clamp(velocityX -velocityIncrement, -600, 600);
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT))
            velocityX = MathUtils.clamp(velocityX + velocityIncrement, -600, 600);

        if (Gdx.input.isKeyPressed(Input.Keys.UP))
            velocityY = MathUtils.clamp(velocityY + velocityIncrement, -600, 600);
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN))
            velocityY = MathUtils.clamp(velocityY -velocityIncrement, -600, 600);

        super.act(dt);
    }
}
