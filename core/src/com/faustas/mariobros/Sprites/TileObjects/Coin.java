package com.faustas.mariobros.Sprites.TileObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.math.Vector2;
import com.faustas.mariobros.MarioBros;
import com.faustas.mariobros.Scenes.Hud;
import com.faustas.mariobros.Screens.PlayScreen;
import com.faustas.mariobros.Sprites.Items.ItemDef;
import com.faustas.mariobros.Sprites.Items.Mushroom;
import com.faustas.mariobros.Sprites.Mario;
import com.faustas.mariobros.Tools.Bits;
import com.faustas.mariobros.Tools.Config;

public class Coin extends InteractiveTileObject {
    private static TiledMapTileSet tileSet;

    public Coin(PlayScreen screen, MapObject object){
        super(screen, object);
        tileSet = map.getTileSets().getTileSet("tileset_gutter");
        fixture.setUserData(this);
        setCategoryFilter(Bits.COIN_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        int BLANK_COIN = 28;
        if(getCell().getTile().getId() == BLANK_COIN)
            MarioBros.manager.get("audio/sounds/bump.wav", Sound.class).play();
        else {
            if(object.getProperties().containsKey("mushroom")) {
                screen.spawnItem(new ItemDef(new Vector2(body.getPosition().x, body.getPosition().y + 16 / Config.PPM),
                        Mushroom.class));
                MarioBros.manager.get("audio/sounds/powerup_spawn.wav", Sound.class).play();
            }
            else
                MarioBros.manager.get("audio/sounds/coin.wav", Sound.class).play();
            getCell().setTile(tileSet.getTile(BLANK_COIN));
            Hud.addScore(100);
        }
    }
}
