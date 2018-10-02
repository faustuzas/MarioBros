package com.faustas.mariobros;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.faustas.mariobros.Scenes.Hud;
import com.faustas.mariobros.Screens.PlayScreen;

public class MarioBros extends Game {
    public SpriteBatch batch;
    private Hud hud;
    private int currentLevel = 1;
	public static AssetManager manager;

    @Override
	public void create () {
		batch = new SpriteBatch();
		hud = new Hud(batch);

		setUpAssetsManager();

		playFirstLevel();
	}

	public void playFirstLevel() {
        currentLevel = 3;
        hud.reset();
        playLevel();
    }

    public void playNextLevel() {
        ++currentLevel;
        playLevel();
        hud.nextLevel(currentLevel);
    }

    private void playLevel() {
        String mapName = "level" + currentLevel + ".tmx";
        setScreen(new PlayScreen(this, hud, mapName));
    }

	@Override
	public void dispose() {
		super.dispose();
		manager.dispose();
        hud.dispose();
        batch.dispose();
	}

	@Override
	public void render () {
		super.render();
	}

	private void setUpAssetsManager() {
        manager = new AssetManager();
        manager.load("audio/music/mario_music.ogg", Music.class);
        manager.load("audio/sounds/coin.wav", Sound.class);
        manager.load("audio/sounds/bump.wav", Sound.class);
        manager.load("audio/sounds/breakblock.wav", Sound.class);
        manager.load("audio/sounds/powerup_spawn.wav", Sound.class);
        manager.load("audio/sounds/powerup.wav", Sound.class);
        manager.load("audio/sounds/powerdown.wav", Sound.class);
        manager.load("audio/sounds/stomp.wav", Sound.class);
        manager.load("audio/sounds/mariodie.wav", Sound.class);
        manager.load("audio/sounds/hello.wav", Sound.class);
        manager.finishLoading();
    }
}
