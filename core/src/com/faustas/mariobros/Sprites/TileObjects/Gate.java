package com.faustas.mariobros.Sprites.TileObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.faustas.mariobros.MarioBros;
import com.faustas.mariobros.Screens.PlayScreen;
import com.faustas.mariobros.Sprites.Mario;
import com.faustas.mariobros.Tools.Bits;

public class Gate extends InteractiveTileObject {
    public Gate(PlayScreen screen, MapObject object) {
        super(screen, object);
        fixture.setUserData(this);
        setCategoryFilter(Bits.GATE_BIT);
    }

    @Override
    public void onHeadHit(Mario mario) {
        MarioBros.manager.get("audio/sounds/hello.wav", Sound.class).play();
        screen.toNextLevel = true;
    }
}
