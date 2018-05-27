package com.mygdx.game.ECSRemastered.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mygdx.game.ECSRemastered.utilities.Vector7;
import com.mygdx.game.ECSRemastered.components.CameraComponent;
import com.mygdx.game.ECSRemastered.components.RenderComponent;
import com.mygdx.game.ECSRemastered.components.ScriptComponent;
import com.mygdx.game.ECSRemastered.components.TransformComponent;

public class Actor extends Entity {
    public Actor(String name) {
        super(name);

        this.addComponent(new TransformComponent());
        this.addComponent(new RenderComponent(32,32));

        this.addComponent(new ScriptComponent() {
            @Override
            public void run() {
                setPosition(new Vector7(0,0));
                setTexture();
            }

            @Override
            public void update(float delta) {
            }

            void setPosition(Vector7 pos) {
                entity.getComponent(TransformComponent.class).position.set(pos);
            }
            Vector7 getPosition(){
                return entity.getComponent(TransformComponent.class).position;
            }

            void setTexture(){
                entity.getComponent(RenderComponent.class).setTexture("player.png");
            }
        });



        this.addComponent(new ScriptComponent() {
            @Override
            public void run() {

            }

            @Override
            public void update(float delta) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
                    Vector7 pos=entity.getComponent(TransformComponent.class).position.cpy();
                    pos.x-=16;
                    entity.getComponent(TransformComponent.class).position=pos;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
                    Vector7 pos=entity.getComponent(TransformComponent.class).position.cpy();
                    pos.x+=16;
                    entity.getComponent(TransformComponent.class).position=pos;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.UP)){
                    Vector7 pos=entity.getComponent(TransformComponent.class).position.cpy();
                    pos.y+=16;
                    entity.getComponent(TransformComponent.class).position=pos;
                }
                else if(Gdx.input.isKeyJustPressed(Input.Keys.DOWN)){
                    Vector7 pos=entity.getComponent(TransformComponent.class).position.cpy();
                    pos.y-=16;
                    entity.getComponent(TransformComponent.class).position=pos;
                }

            }
        });

        this.addComponent(new CameraComponent());
    }
}
