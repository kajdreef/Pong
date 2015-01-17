/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.kajdreef.pongmvn.StateManager;

import io.github.kajdreef.pongmvn.Entities.*;
import io.github.kajdreef.pongmvn.Util.Score;
import java.util.ArrayList;
import io.github.kajdreef.pongmvn.Launcher;
import org.lwjgl.input.Keyboard;

/**
 *
 * @author kajdreef
 */
public class Pong extends State {    
    private ArrayList<Entity> entityList = new ArrayList<Entity>();

    private MoveableEntity ball = null;
    private MoveableEntity pad1 = null;
    private MoveableEntity pad2 = null;
    
    private Score score = null;
    
    private final int padOffset = 20, padHeight = 40;
    
    public Pong(){
        restartGame();
    }
    
    /**
     * Initialize every new pong game.
     */
    private void init(){
        entityList.clear();
        
        ball = new Ball(50,120,10,10);
        pad1 = new Pad(padOffset,Launcher.HEIGHT/2 - padHeight/2,10,padHeight);
        pad2 = new Pad(Launcher.WIDTH-padOffset,Launcher.HEIGHT/2 - padHeight/2 ,10,padHeight);

        entityList.add(ball);
        entityList.add(pad1);
        entityList.add(pad2);
    }
    
    
    @Override
    public void render(){
        for (Entity entity : entityList){
            entity.draw();
        }
        score.draw();
    }
    
    @Override
    public void input(){
        // Buffered Mouse input
        while(Keyboard.next()){
            if(Keyboard.isKeyDown(Keyboard.KEY_UP)){
                pad2.setDY(-2);
            }
            else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN)){
                pad2.setDY(2);
            }
            else{
                pad2.setDY(0);
            }
            
            if(Keyboard.isKeyDown(Keyboard.KEY_W)){
                pad1.setDY(-2);
            }
            else if(Keyboard.isKeyDown(Keyboard.KEY_S)){
                pad1.setDY(2);
            }
            else{
                pad1.setDY(0);
            }
            
            if(Keyboard.isKeyDown(Keyboard.KEY_ESCAPE)){
                restartGame();
            }
        }
    }
    
    @Override
    public void logic(int delta){
        
        // Check if the pad and ball collided.
        if(pad1.intersects(ball) || pad2.intersects(ball)){
            ball.setDX(-1*ball.getDX());
        }
        
        // update the score, when scored.
        if(ball.getX() < 0){
            score.update(true);
            init();
        }
        else if (ball.getX() > Launcher.WIDTH){
            score.update(false);
            init();
        }
         
        // Update the position of the entities.
        for (Entity entity : entityList){
            entity.update(delta);
        }
    }
    
    /** 
     * Restart the pong game with new score.
     */
    public void restartGame(){
        score = new Score();
        init();
    }
}
