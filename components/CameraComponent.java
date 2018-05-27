package com.mygdx.game.ECSRemastered.components;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.ECSRemastered.utilities.Vector7;

public class CameraComponent extends Component {
    private Vector7 world;
    public CameraComponent(){
        world=new Vector7(0,0);
    }

    public Vector7 getWorld() {
        return world;
    }

    @Override
    public void update(float delta) {

        if(this.entity != null){
            world.x =Gdx.graphics.getWidth()/2-this.entity.getComponent(TransformComponent.class).position.x;
            world.y = Gdx.graphics.getHeight()/2-this.entity.getComponent(TransformComponent.class).position.y;
        }
    }
}
