package com.viralfun.uncover;

import com.badlogic.gdx.Game;

public class UncoverGdxGame extends Game {
    public void create() {
        CheeseLevel cl = new CheeseLevel(this);
        setScreen(cl);
    }
}
