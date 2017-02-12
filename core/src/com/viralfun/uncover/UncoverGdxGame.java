package com.viralfun.uncover;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;

public class UncoverGdxGame extends ApplicationAdapter {
    private SpriteBatch batch;
    private CheeseActor cheeseActor;

    public Stage mainStage;
    public Stage uiStage;

    private BackgroundTileActor backgroundTileActor;
    private MouseActor mouseActor;
    private Texture winMessage;
    private boolean win;

    private float timeElapsed;
    private Label timeLabel;

    public void create() {
        batch = new SpriteBatch();
        mainStage = new Stage();
        uiStage = new Stage();

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


        timeElapsed = 0;
        BitmapFont font = new BitmapFont();
        String text = "Time: 0";
        Label.LabelStyle style = new Label.LabelStyle( font, Color.NAVY );
        timeLabel = new Label( text, style );
        timeLabel.setFontScale(2);
        timeLabel.setPosition(500, 440);

        uiStage.addActor( timeLabel );
    }

    public void render() {
        // check user input
        // check win condition: mouseActor must be overlapping cheese
        float deltaTime = Gdx.graphics.getDeltaTime();
        mainStage.act(deltaTime);
        uiStage.act(deltaTime);

        Rectangle cheeseRectangle = cheeseActor.getBoundingRectangle();
        Rectangle mouseActorRectangle = mouseActor.getBoundingRectangle();

        if (cheeseRectangle.overlaps(mouseActorRectangle)) {
            win = true;
            cheeseActor.onEat();
        }

        // clear screen and draw graphics
        Gdx.gl.glClearColor(0.8f, 0.8f, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);



        Camera cam = mainStage.getCamera();
        // center camera on player
        cam.position.set( mouseActor.getX() + mouseActor.getOriginX(),
                mouseActor.getY() + mouseActor.getOriginY(), 0 );
        // bound camera to layout
        double viewWidth = Gdx.graphics.getWidth();
        cam.position.x = (float) MathUtils.clamp(cam.position.x, viewWidth /2, World.WIDTH - viewWidth /2);
        double viewHeight = Gdx.graphics.getHeight();
        cam.position.y = (float) MathUtils.clamp(cam.position.y, viewHeight /2, World.HEIGHT - viewHeight /2);
        cam.update();

        mainStage.draw();

        batch.begin();
        if (win) {
            batch.draw(winMessage, 170, 60);
        } else {
            timeElapsed += deltaTime;
            timeLabel.setText( "Time: " + (int)timeElapsed );
        }
        batch.end();

        uiStage.draw();

    }

}
