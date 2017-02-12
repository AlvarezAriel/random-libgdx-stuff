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

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.viralfun.uncover.cheese.shared.BaseActor;

public class CheeseActor extends BaseActor {
    @Override
    public void initialize() {
        super.initialize();
        setTexture(new Texture(Gdx.files.internal("cheese.png")));
        setSize(60,60);
        setPosition(400, 300);
        this.setOrigin(getWidth()/2, getHeight()/2);
    }

    public void onEat() {
        Action spinShrinkFadeOut = Actions.parallel(
                Actions.alpha(1), // set transparency value
                Actions.rotateBy(360, 1), // rotation amount, duration
                Actions.scaleTo(0, 0, 1), // x amount, y amount, duration
                Actions.fadeOut(1) // duration of fade out
        );
        this.addAction( spinShrinkFadeOut );
    }
}
