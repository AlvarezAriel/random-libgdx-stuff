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
package com.viralfun.uncover.shared;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;

public class AnimatedActor extends BaseActor {
    public float elapsedTime;
    public Animation<TextureRegion> anim;

    public AnimatedActor() {
        super();
        elapsedTime = 0;
    }

    public void setAnimation(Animation<TextureRegion> a) {
        Texture t = a.getKeyFrame(0).getTexture();
        float h = getHeight();
        float w = getWidth();
        setTexture(t);
        setSize(w,h);
        anim = a;
    }

    public void act(float dt) {
        super.act(dt);
        elapsedTime += dt;
        if (velocityX != 0 || velocityY != 0)
            setRotation(MathUtils.atan2(velocityY, velocityX) * MathUtils.radiansToDegrees);
    }

    public void draw(Batch batch, float parentAlpha) {
        region.setRegion(anim.getKeyFrame(elapsedTime));
        super.draw(batch, parentAlpha);
    }
}
