package com.mygdx.game.ECSRemastered.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.PolygonSpriteBatch;
import com.mygdx.game.ECSRemastered.utilities.Vector7;

public class RenderComponent extends Component {

    private Texture texture;
    public float height,width;

    public RenderComponent(float width,float height){
        this.width=width;
        this.height=height;
    }

    public void setTexture(String textureName) {
        this.texture = new Texture(textureName);
    }



    public void render(PolygonSpriteBatch batch, Vector7 world){
        batch.draw(texture,world.x+this.getEntity().getComponent(TransformComponent.class).position.x,world.y+this.getEntity().getComponent(TransformComponent.class).position.y,width,height);
    }

    @Override
    public void update(float delta) {

    }
}
