package com.mygdx.game.ECSRemastered;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.mygdx.game.ECSRemastered.components.CameraComponent;
import com.mygdx.game.ECSRemastered.entities.Actor;
import com.mygdx.game.ECSRemastered.entities.EntityManager;
import com.mygdx.game.ECSRemastered.utilities.Vector7;
import com.mygdx.game.ECSRemastered.world.TileMap;

public class ViewGamePlay extends GameView {
    private EntityManager manager;
    private TileMap map;

    public ViewGamePlay() {
        map = new TileMap(10, 10);
        manager = new EntityManager();
        manager.createEntity(new Actor("player"));
    }

    @Override
    public void update(float delta) {
        manager.update(delta);
    }

    @Override
    public void sketch(PolygonSpriteBatch batch) {
        Vector7 world = manager.getEntityByName("player").getComponent(CameraComponent.class).getWorld();
        for (int i = 0; i < map.getWidth(); i++) {
            for (int j = 0; j < map.getHeight(); j++) {
                batch.draw(map.tileImg, world.x + i * Config.SCALED_TILE_SIZE, world.y + j * Config.SCALED_TILE_SIZE, Config.SCALED_TILE_SIZE, Config.SCALED_TILE_SIZE);
            }
        }

        manager.sketch(batch, world);
    }

    @Override
    public void dispose() {

    }
}