/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kajdreef.pongmvn.Entities;

import io.github.kajdreef.pongmvn.Launcher;

/**
 *
 * @author kajdreef
 */
public abstract class AbstractMovingEntity extends AbstractEntity implements MoveableEntity {
    protected double dx, dy;
    
    public AbstractMovingEntity(double x, double y, double width, double height){
        super(x, y, width, height);
        this.dx = 0;
        this.dy = 0;
    }
    
    @Override
    public double getDX(){
        return this.dx;
    }
    
    @Override
    public double getDY(){
        return this.dy;
    }
    
    @Override
    public void setDX(double dx){
        this.dx = dx;
    }
    
    @Override
    public void setDY(double dy){
        this.dy = dy;
    }
    
    @Override
    public void update(int delta){
        this.x += this.dx * delta;
        this.y += this.dy * delta;
        if(this.y> Launcher.HEIGHT -this.height || this.y < 0  ){
            this.dy*=-1;
        }
    }
}
