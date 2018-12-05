package com.faustas.mariobros.sprites.TileObjects;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.maps.MapObject;
import com.faustas.mariobros.MarioBros;
import com.faustas.mariobros.screens.PlayScreen;
import com.faustas.mariobros.sprites.Mario;
import com.faustas.mariobros.tools.Bits;

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
