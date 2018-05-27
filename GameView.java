package com.mygdx.game.ECSRemastered;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;

public abstract class GameView
{

    public final void updateView(float delta)
    {
        update(delta);
    }

    public abstract void update(float delta);

    public abstract void sketch(PolygonSpriteBatch batch);

    public abstract void dispose();
}