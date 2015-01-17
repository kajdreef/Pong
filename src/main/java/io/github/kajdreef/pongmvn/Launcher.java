package io.github.kajdreef.pongmvn;

import io.github.kajdreef.pongmvn.StateManager.*;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;


import static org.lwjgl.opengl.GL11.*;

public class Launcher{
    public static int HEIGHT = 480;
    public static int WIDTH = 640;
    
    private static State state = null;
    
    public enum States{
        PONG, MAINMENU
    }
    
    private static States currentState = null;
    private static States nextState = States.PONG;
    
    /**
     * Initialize the display.
     */
    private static void initDisplay(){
        try{
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.setTitle("Pong");
            Display.create();
        } catch(LWJGLException e){
            e.printStackTrace();
            Display.destroy();
            System.exit(1);
        }
    }
    
    /**
     * Initialize OpenGL.
     */
    private static void initOpenGL(){
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        // Left, Right, Bottom, Top, z-near, z-far
        glOrtho(0, WIDTH, HEIGHT, 0, 1, -1);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();        
    }
    
    /**
     * Destroy the display.
     */
    public static void destroy(){
        Display.destroy();
    }

    /**
     * Request a new state.
     * @param newState 
     */
    public static void requestNewState(States newState){
        Launcher.nextState = newState;
    }
    
    /**
     * Check if a new state was requested.
     */
    private static void checkState(){
        if(currentState != nextState){
            switch(nextState){
                case PONG:
                    state = new Pong();
                    break;
                case MAINMENU:
                    state = new MainMenu();
                    break;
            }
            currentState = nextState;
        }
    }

    public static void main(String[] args){
        initDisplay();
        initOpenGL();

        while(!Display.isCloseRequested()){ 
            glClear(GL_COLOR_BUFFER_BIT);

            checkState();
            
            state.render();
            state.input();
            state.logic(3);
            
            Display.update();
            Display.sync(60);
        }
        
        destroy();
        
        System.exit(0);
    }
}