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
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class BackgroundTileActor extends BaseActor {
    @Override
    public void initialize() {
        super.initialize();
        Texture imgTexture = new Texture(Gdx.files.internal("tiles.jpg"));
        imgTexture.setWrap(Texture.TextureWrap.MirroredRepeat, Texture.TextureWrap.MirroredRepeat);
        region = new TextureRegion(imgTexture);
        region.setRegion(0, 0, imgTexture.getWidth() * 10, imgTexture.getHeight() * 10);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(region, 0, 0);

    }
}
