package com.viralfun.uncover;

import com.badlogic.gdx.Game;
import com.viralfun.uncover.menu.CheeseMenuScreen;

public class UncoverGdxGame extends Game {
    public void create() {
        CheeseMenuScreen cl = new CheeseMenuScreen(this);
        setScreen(cl);
    }
}
