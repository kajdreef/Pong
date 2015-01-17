/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kajdreef.pongmvn.Entities;

/**
 *
 * @author kajdreef
 */
public interface Entity {
    
    public void draw();  
    public void update(int delta);
    public void setLocation(double x, double y);
    
    public void setX(double x);
    public void setY(double y);
    public void setWidth(double width);
    public void setHeight(double Height);
    
    public double getX();
    public double getY();
    public double getWidth();
    public double getHeight();
    
    public boolean intersects(Entity other);
}
