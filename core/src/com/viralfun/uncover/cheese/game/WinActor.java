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
import com.viralfun.uncover.shared.BaseActor;

public class WinActor extends BaseActor {
    @Override
    public void initialize() {
        super.initialize();
        this.setTexture(new Texture(Gdx.files.internal("you-win.png")));
        setVisible(false);
    }
}
