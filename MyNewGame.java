package com.mygdx.game.ECSRemastered;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

public class MyNewGame extends ApplicationAdapter {

    private GameManager gm;
    private PolygonSpriteBatch polygonSpriteBatch;

    @Override
    public void create() {
        polygonSpriteBatch = new PolygonSpriteBatch();
        gm = new GameManager();
        gm.startGame();

    }

    @Override
    public void render() {
        update(Gdx.graphics.getDeltaTime());
        sketch();

    }

    private void update(float delta) {
        gm.update(delta);
    }

    private void sketch() {
        polygonSpriteBatch.begin();
        gm.sketch(polygonSpriteBatch);
        polygonSpriteBatch.end();


    }

    @Override
    public void dispose() {
        polygonSpriteBatch.dispose();
        gm.dispose();
    }

}