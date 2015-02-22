package io.github.kajdreef.pongmvn.Util;

import io.github.kajdreef.pongmvn.Launcher;
import java.awt.Font;
import org.lwjgl.opengl.GL11;
import org.newdawn.slick.Color;
import org.newdawn.slick.TrueTypeFont;

/**
 *
 * @author kajdreef
 */
public class Score {
    private int player1;
    private int player2;
    
    private TrueTypeFont font;
    
    public Score(){
        Font awtFont = new Font("Times New Roman", Font.BOLD, 25);
        font = new TrueTypeFont(awtFont, true);

        player1 = 0;
        player2 = 0;
    }
    
    /**
     * Update the score depending on who won.
     * @param player 
     */
    public void update(Boolean player){
        if(!player){
            player1++;
        }
        else{
            player2++;
        }
    }
    
    /**
     * Reset score of the player.
     */
    public void reset(){
        this.player1 = 0;
        this.player2 = 0;
    }
   
    /**
     * Draw The score on the screen 
     */
    public void draw(){
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        
        String scoreString = player1 + " - " + player2;
        int widthString = font.getWidth(scoreString);
        font.drawString(Launcher.WIDTH/2 - widthString/2  , 0, scoreString, Color.red);
        
        GL11.glDisable(GL11.GL_BLEND);
    }
}
