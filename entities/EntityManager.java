package com.mygdx.game.ECSRemastered.entities;

import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.mygdx.game.ECSRemastered.entities.Entity;
import com.mygdx.game.ECSRemastered.components.RenderComponent;
import com.mygdx.game.ECSRemastered.components.ScriptComponent;
import com.mygdx.game.ECSRemastered.utilities.Vector7;
import com.mygdx.game.world.TileMap;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class EntityManager {

    private HashMap<String, Entity> entities;
    private LinkedList<Entity> tempEntities;

    public EntityManager() {
        tempEntities = new LinkedList<Entity>();
        entities = new HashMap<String, Entity>();


    }

    public void createEntity(Entity entity) {
        tempEntities.add(entity);
    }

    private void addEntity(Entity entity) {
        String key = entity.getName();

        if (key != null && !key.isEmpty()) {
            entities.put(key, entity);
        }

    }

    public Entity getEntityByName(String name){

        Entity result=entities.get(name);
        if(result!=null)
            return entities.get(name);
        else
            throw new IllegalArgumentException("ERROR: no entity found with the name:" + name);
    }

    private void run() {

        for (Entity entity : tempEntities) {
            List<ScriptComponent> scriptComponents = entity.getComponents(ScriptComponent.class);
            if (!scriptComponents.isEmpty()) {
                for (ScriptComponent script : scriptComponents) {
                    script.run();
                }
            }

            this.addEntity(entity);
        }

        tempEntities.clear();

    }

    public void update(float delta) {
        if (!tempEntities.isEmpty()) {
            this.run();
        }

        for (Entity entity : entities.values()) {
            entity.update(delta);
        }
    }


    public void sketch(PolygonSpriteBatch batch, Vector7 world) {

        for (Entity entity : entities.values()) {
            RenderComponent renderer = entity.getComponent(RenderComponent.class);
            if (renderer != null) {
                renderer.render(batch,world);
            }
        }
    }

}