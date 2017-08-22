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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.viralfun.uncover.shared.BaseActor;

public class PlatformerBackground extends BaseActor {
    @Override
    public void initialize() {
        super.initialize();
        Texture imgTexture = new Texture(Gdx.files.internal("collision_level1.png"));
        setTexture(imgTexture);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, 0, 0);
    }
}
