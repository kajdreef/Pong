package io.github.kajdreef.pongmvn.Entities;

import java.awt.Rectangle;

/**
 *
 * @author kajdreef
 */
public abstract class AbstractEntity implements Entity {
    protected double x, y, width, height;
    protected Rectangle collisionBox = new Rectangle();
    
    public AbstractEntity(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    @Override
    public void setX(double x){
        this.x = x;
    }
    
    @Override
    public void setY(double y){
        this.y = y;
    }
       
    @Override
    public void setWidth(double width){
        this.width = width;
    }
     
    @Override
    public void setHeight(double height){
        this.height = height;
    }

    @Override
    public double getX(){
        return this.x;
    }
    
    @Override
    public double getY(){
        return this.y;
    }
        
    @Override
    public double getWidth(){
        return this.width;
    }
    
    @Override
    public double getHeight(){
        return this.height;
    }
    
    /**
     * Check if the two Entities intersects
     * @param other
     * @return 
     */
    @Override
    public boolean intersects(Entity other){
        collisionBox.setBounds((int)this.x, (int)this.y, (int)this.width, (int)this.height);
        return collisionBox.intersects(other.getX(), other.getY(), other.getWidth(), other.getHeight());
    }
}
