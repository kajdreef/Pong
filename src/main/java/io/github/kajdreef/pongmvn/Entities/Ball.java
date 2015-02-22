/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kajdreef.pongmvn.Entities;

import io.github.kajdreef.pongmvn.Launcher;
import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author kajdreef
 */
public class Ball extends AbstractMovingEntity {

    private double SPEED = 1.5;
    
    public Ball(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.dx = SPEED * Launcher.WIDTH/640;
        if(Math.random() < 0.5)
            this.dy = SPEED * Launcher.HEIGHT/480;
        else
            this.dy = -SPEED * Launcher.HEIGHT/480;
    }

    @Override
    public void draw() {
        glColor3f(1.0f, 0.0f, 0.0f);
        glRectd(this.x, this.y, this.x + this.width, this.y + this.height);
    }
}
