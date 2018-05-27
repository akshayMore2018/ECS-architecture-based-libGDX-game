package com.mygdx.game.ECSRemastered.components;

import com.mygdx.game.ECSRemastered.entities.Entity;

public abstract class Component {

    protected Entity entity;

    public Component(){
        this.entity=null;
    }

    public Entity getEntity() {
        return entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public abstract void update(float delta);
}
