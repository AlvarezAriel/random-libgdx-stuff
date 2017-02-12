package com.viralfun.uncover;

import com.badlogic.gdx.Game;
import com.viralfun.uncover.cheese.menu.CheeseMenuScreen;

public class UncoverGdxGame extends Game {
    public void create() {
        MainMenuScreen cl = new MainMenuScreen(this);
        setScreen(cl);
    }
}
