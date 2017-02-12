package com.viralfun.uncover;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class UncoverGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private CheeseActor cheeseActor;
    public Stage mainStage;
    private BackgroundTileActor backgroundTileActor;
    private MouseActor mouseActor;
    private Texture winMessage;
    private boolean win;

    public void create() {
        batch = new SpriteBatch();
        mainStage = new Stage();

        backgroundTileActor = new BackgroundTileActor();
        backgroundTileActor.initialize();
        mainStage.addActor(backgroundTileActor);

        cheeseActor = new CheeseActor();
        cheeseActor.initialize();
        mainStage.addActor(cheeseActor);

        mouseActor = new MouseActor();
        mouseActor.initialize();
        mainStage.addActor(mouseActor);

        winMessage = new Texture(
                Gdx.files.internal("you-win.png"));
        win = false;
    }

    public void render() {
        // check user input
        // check win condition: mousey must be overlapping cheese
        mainStage.act(Gdx.graphics.getDeltaTime());

        Rectangle cheeseRectangle = cheeseActor.getBoundingRectangle();
        Rectangle mouseyRectangle = mouseActor.getBoundingRectangle();

        win = cheeseRectangle.overlaps(mouseyRectangle);

        // clear screen and draw graphics
        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mainStage.draw();
        batch.begin();
        if (win)
            batch.draw(winMessage, 170, 60);
        batch.end();

    }

}
