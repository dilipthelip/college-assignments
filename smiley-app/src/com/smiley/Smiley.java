package com.smiley;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by z001qgd on 6/23/17.
 */
public class Smiley extends JPanel implements ActionListener{

    public Graphics graphics1;
    Color faceColor;
    int width, height;
    int eyeWhichFeel; //1 = original, 2=wink,3=eyeclose
    int eyeColor; //1 = blue, 2=black,3=yellow
    int smileWhichFeel; //1=original, 2=frown,3=Thinking smile

    Smiley(int w, int h){
        width=w;
        height=h;
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics graphics){

        graphics1 = graphics;

        super.paintComponent(graphics);

        /**
         * Face
         */
        graphics.setColor(faceColor);
        graphics.fillOval(10,10,width-100,height-100);

        /**
         * Outline of face.
         */
        graphics.setColor(Color.black);
        graphics.drawOval(10,10,width-100,height-100);

        /**
         * left Eye
         * Right Eye
         */
        //graphics.fillRect(50,75,50,5);
        if(eyeColor==1){
            graphics.setColor(Color.blue);
        }else if (eyeColor==2){
            graphics.setColor(Color.black);
        }
        else if (eyeColor==3){
            graphics.setColor(Color.yellow);
        }

        if(eyeWhichFeel ==1){ //normal smile
            graphics.fillOval(70,50,30,50);
        }else if (eyeWhichFeel ==2){ //wink
            graphics.fillRect(50,75,50,5);
        }else if (eyeWhichFeel ==3){ //close
            graphics.fillRect(50,75,50,5);
        }

        if(eyeColor==1){
            graphics.setColor(Color.blue);
        }else if (eyeColor==2){
            graphics.setColor(Color.black);
        }else if (eyeColor==3){
            graphics.setColor(Color.yellow);
        }
        if (eyeWhichFeel ==3){ //close
            graphics.fillRect(130,75,50,5);
        }else{
            graphics.fillOval(130,50,30,50);
        }


        /**
         * Mouth
         */
        if(smileWhichFeel==1) {
            graphics.setColor(Color.red);
            graphics.fillArc(70, 100, 100, 70, 180, 180);
        }else if(smileWhichFeel==2){
            graphics.setColor(Color.red);
            graphics.drawArc(90,150,40,25,0,180);
        }else if(smileWhichFeel==3){
            graphics.setColor(Color.red);
            graphics.fillRect(90, 150, 50, 5);


        }
    }

    public void setColor(Color newColor){

        faceColor = newColor;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Inside smiley Action event");
    }

    public void wink(Graphics graphics) {
        this.eyeWhichFeel=2;
        this.graphics1=graphics;
        this.paintComponent(this.graphics1);
    }

    public void thinkingSmile(Graphics graphics) {
        this.smileWhichFeel=3;
        this.graphics1=graphics;
        this.paintComponent(this.graphics1);
    }

    public void eyeColorToBlack(Graphics graphics) {
        this.eyeColor=2;
        this.graphics1=graphics;
        this.paintComponent(this.graphics1);
    }

    public void defaultToOriginal(Graphics graphics, Color black) {
        this.setColor(black);
        this.eyeColor=1;
        this.eyeWhichFeel=1;
        this.smileWhichFeel=1;
        this.paintComponent(graphics);

    }

    public void frown(Graphics graphics) {
        this.smileWhichFeel=2;
        this.graphics1=graphics;
        this.paintComponent(this.graphics1);
    }

    public void closeBothEyes(Graphics graphics) {
        this.eyeWhichFeel=3;
        this.graphics1=graphics;
        this.paintComponent(this.graphics1);

    }
}
