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

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class TimerActor extends Actor {

    private Label timeLabel;
    private boolean ticking = true;
    private float timeElapsed;

    public TimerActor() {

    }

    public void initialize() {
        BitmapFont font = new BitmapFont();
        String text = "Time: 0";
        Label.LabelStyle style = new Label.LabelStyle( font, Color.NAVY );
        timeLabel = new Label( text, style );
        timeLabel.setFontScale(2);
        timeLabel.setPosition(500, 440);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if (isTicking()) {
            timeElapsed += delta;
            timeLabel.setText( "Time: " + (int)timeElapsed );
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        timeLabel.draw(batch, parentAlpha);
    }

    public boolean isTicking() {
        return ticking;
    }

    public void setTicking(boolean ticking) {
        this.ticking = ticking;
    }
}
