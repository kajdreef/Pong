package io.github.kajdreef.pongmvn.StateManager;


/**
 *
 * @author kajdreef
 */
public abstract class State {  
    public abstract void render();
    public abstract void input();
    public abstract void logic(int delta);
}
