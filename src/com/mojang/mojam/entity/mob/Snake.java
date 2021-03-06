package com.mojang.mojam.entity.mob;

import com.mojang.mojam.network.TurnSynchronizer;
import com.mojang.mojam.screen.Art;
import com.mojang.mojam.screen.Bitmap;

public class Snake extends HostileMob {

	public static final int COLOR = 0xffff9900;
	
	public Snake(double x, double y) {
		super(x, y, Team.Neutral);
		setPos(x, y);
		setStartHealth(3);
		dir = TurnSynchronizer.synchedRandom.nextDouble() * Math.PI * 2;
		minimapColor = 0xffff0000;
		yOffs = 10;
		facing = TurnSynchronizer.synchedRandom.nextInt(4);
		deathPoints = 2;
		strength = 1;
		speed=1.5;
		limp = 4;
	}

	public void tick() {
		super.tick();
		walk();
	}

	public void die() {
		super.die();
	}

	public Bitmap getSprite() {
		return Art.snake[((stepTime / 6) & 3)][(facing + 1) & 3];
	}

	@Override
	public String getDeathSound() {
		return "/sound/Enemy Death 2.wav";
	}

	@Override
	public int getColor() {
		return COLOR;
	}

	@Override
	public int getMiniMapColor() {
		return COLOR;
	}

	@Override
	public String getName() {
		return "SNAKE";
	}

	@Override
	public Bitmap getBitMapForEditor() {
		return Art.snake[0][0];
	}
}
