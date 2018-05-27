package com.mygdx.game.ECSRemastered.world;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TileMap {

    private Tile[][] tiles;
    private int height,width;
    public Texture tileImg;

    public TileMap(int width, int height){
        tileImg = new Texture(Gdx.files.internal("towerDefense_tile024.png"));
        this.width=width;
        this.height=height;
        tiles=new Tile[width][height];

        for(int x=0;x<width;x++){
            for(int y=0;y<height;y++){
                tiles[x][y]=new Tile(TERRAIN.TILE_1);
                getTile(x,y).setEntityID(-1);
            }
        }
    }


    public Tile getTile(int x,int y){
        return tiles[x][y];
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

}
