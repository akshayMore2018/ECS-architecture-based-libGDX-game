package com.mygdx.game.ECSRemastered.components;

import com.mygdx.game.ECSRemastered.utilities.Vector7;

public class TransformComponent extends Component {

    public Vector7 position;
    public float rotation;

    public TransformComponent(){
        position=new Vector7(0,0);
        rotation=0;
    }


    @Override
    public void update(float delta) {

    }
}
