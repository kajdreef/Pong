/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kajdreef.pongmvn.Entities;

import static org.lwjgl.opengl.GL11.*;

/**
 *
 * @author kajdreef
 */
public class Pad extends AbstractMovingEntity {

    public Pad(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void draw() {
        glColor3f(1.0f, 0.0f, 0.0f);
        glRectd(this.x, this.y, this.x + this.width, this.y + this.height);
    }
}
