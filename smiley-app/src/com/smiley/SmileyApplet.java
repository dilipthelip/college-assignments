package com.smiley;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SmileyApplet extends JApplet implements ActionListener {

    private static final String wink ="Wink";
    private static String frown = "Frown";
    private static String thinkingSmiley="Thinking Smile";
    private static String eyeColorToBlack="Eye Color to Black";
    private static String original="Default";
    Smiley smiley1, smiley2,smiley3;
    JComboBox smiley1ComboBox,smiley2ComboBox,smiley3ComboBox;
    JTextField textField;

    private static  String orangeFaceColor = "Smiley Face Color to Orange!";
    private static  String yellowFaceColor="Smiley Face Color to Yellow!";
    String greenFaceColor="Smiley Face Color to Green!";;
    private static  String resetToOriginal = "Reset to Original";

    public void init(){
        setSize(950,400);

        Scrollbar scrollbar = new Scrollbar(Scrollbar.HORIZONTAL, 50, 0, 0, 100);

        smiley1 = new Smiley(300,300);
        smiley1.setColor(Color.YELLOW);
        smiley1.eyeWhichFeel = 1;
        smiley1.smileWhichFeel=1;
        smiley1.eyeColor=1;

        smiley2 = new Smiley(300,300);
        smiley2.setColor(Color.ORANGE);
        smiley2.eyeWhichFeel = 1;
        smiley2.smileWhichFeel=1;
        smiley2.eyeColor=1;

        smiley3 = new Smiley(300,300);
        smiley3.setColor(Color.BLACK);
        smiley3.eyeWhichFeel = 1;
        smiley3.smileWhichFeel=1;
        smiley3.eyeColor=3;

        String [] smiley1Options = {original,orangeFaceColor,wink,thinkingSmiley,eyeColorToBlack};
        smiley1ComboBox = new JComboBox(smiley1Options);


        String [] smiley2Options = {original,yellowFaceColor,wink,frown,eyeColorToBlack};
        smiley2ComboBox = new JComboBox(smiley2Options);


        String [] smiley3Options = {original,greenFaceColor,wink,frown,eyeColorToBlack};
        smiley3ComboBox = new JComboBox(smiley3Options);

        setLayout(new FlowLayout());

        add(smiley1ComboBox);
        add(smiley2ComboBox);
        add(smiley3ComboBox);
        add(smiley1);
        add(smiley2);
        add(smiley3);
        addComboBoxActionListener();


    }

    private void addComboBoxActionListener() {

        smiley1ComboBox.addActionListener(this);
        smiley2ComboBox.addActionListener(this);
        smiley3ComboBox.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {


        if(evt.getSource() == smiley1ComboBox){
            String selectedValue = (String) smiley1ComboBox.getSelectedItem();
            smiley1Operations(selectedValue);

        }else if (evt.getSource() == smiley2ComboBox){
            String selectedValue = (String) smiley2ComboBox.getSelectedItem();
            smiley2Operations(selectedValue);
        }
        else if (evt.getSource() == smiley3ComboBox){
            String selectedValue = (String) smiley3ComboBox.getSelectedItem();
            smiley3Operations(selectedValue);
        }

    }

    private void smiley3Operations(String selectedValue) {

        if(selectedValue.equals(greenFaceColor)){
            smiley3.setColor(Color.GREEN);
            smiley3.repaint();
            smiley3.revalidate();
        }else if(selectedValue.equals(frown)){
            smiley3.frown(smiley2.graphics1);
            smiley3.repaint();
            smiley3.revalidate();
        }
        else if(selectedValue.equals(wink)){
            smiley3.wink(smiley2.graphics1);
            smiley3.repaint();
            smiley3.revalidate();
        }
        else if(selectedValue.equals(eyeColorToBlack)){
            smiley3.eyeColorToBlack(smiley2.graphics1);
            smiley3.repaint();
            smiley3.revalidate();
        }

        else if(selectedValue.equals(original)){
            smiley3.defaultToOriginal(smiley2.graphics1);
            smiley3.repaint();
            smiley3.revalidate();
        }
    }

    /**
     * This method takes care of modifying the Second Smiley:
     * @param selectedValue
     */
    private void smiley2Operations(String selectedValue) {

        if(selectedValue.equals(yellowFaceColor)){
            smiley2.setColor(Color.YELLOW);
            smiley2.repaint();
            smiley2.revalidate();
        }else if(selectedValue.equals(frown)){
            smiley2.frown(smiley2.graphics1);
            smiley2.repaint();
            smiley2.revalidate();
        }
        else if(selectedValue.equals(wink)){
            smiley2.wink(smiley2.graphics1);
            smiley2.repaint();
            smiley2.revalidate();
        }
        else if(selectedValue.equals(eyeColorToBlack)){
            smiley2.eyeColorToBlack(smiley2.graphics1);
            smiley2.repaint();
            smiley2.revalidate();
        }

        else if(selectedValue.equals(original)){
            smiley2.defaultToOriginal(smiley2.graphics1);
            smiley2.repaint();
            smiley2.revalidate();
        }
    }

    /**
     * This method takes care of modifying the First Smiley:
     * @param selectedValue
     */
    private void smiley1Operations(String selectedValue) {

        if(selectedValue.equals(orangeFaceColor)){
            smiley1.setColor(Color.ORANGE);
            //smiley2.wink();
            smiley1.repaint();
            smiley1.revalidate();
        }else if(selectedValue.equals(wink)){
            smiley1.wink(smiley1.graphics1);
            smiley1.repaint();
            smiley1.revalidate();
        }
        else if(selectedValue.equals(thinkingSmiley)){
            smiley1.thinkingSmile(smiley1.graphics1);
            smiley1.repaint();
            smiley1.revalidate();
        }
        else if(selectedValue.equals(eyeColorToBlack)){
            smiley1.eyeColorToBlack(smiley1.graphics1);
            smiley1.repaint();
            smiley1.revalidate();
        }

        else if(selectedValue.equals(original)){
            smiley1.defaultToOriginal(smiley1.graphics1);
            smiley1.repaint();
            smiley1.revalidate();
        }
    }
}
