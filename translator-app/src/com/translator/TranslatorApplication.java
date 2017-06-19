package com.translator;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TranslatorApplication {

    public static String title = "Translator Application";
    public static String inputLabel ="Please enter the input in English";
    public static String heading ="Translator Application";
    public static String defaultInput="Enter some string";

    public static void main(String[] args) {

        TranslatorPage frame = new TranslatorPage();

        frame.setTitle(title);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}

     class TranslatorPage  extends JFrame implements KeyListener {

         private static final long serialVersionUID = 1L;

         final int sizeArray = 6;

         final String BANNER = "Translate English to Spanish";
         final String PROMPT = "Enter some text:";
         private JTextArea enterArea;
         private JTextField inputTextField;
         private JLabel welcomeTranslatorLabel, inputTextLabel,imageLabel,imageLabel3;
         private JPanel pNorth,pCenter, pSearchCrieteriaPanel,pSidePanel,pBotSide;
         private JButton convert;

         public TranslatorPage() {

             setDefaultCloseOperation(EXIT_ON_CLOSE);

             Container window=getContentPane();

             pNorth=new JPanel();
             pNorth.setLayout(new FlowLayout());

             pSearchCrieteriaPanel =new JPanel();
             pSearchCrieteriaPanel.setLayout(new FlowLayout());

             pCenter=new JPanel();
             pCenter.setLayout(new GridLayout(1,3));

             /**Welcome Label**/
             welcomeTranslatorLabel =  pageHeading(welcomeTranslatorLabel);
             pNorth.add(welcomeTranslatorLabel);

             inputTextLabel = new JLabel(TranslatorApplication.inputLabel);
             inputTextField = new JTextField("Enter some string");
             convert = new JButton("Convert");

             pSearchCrieteriaPanel.add(inputTextLabel,BorderLayout.WEST);
             pSearchCrieteriaPanel.add(inputTextField,BorderLayout.CENTER);
             pSearchCrieteriaPanel.add(convert,BorderLayout.EAST);

             //pCenter.add("North", pNorth);
             pCenter.add("North", pSearchCrieteriaPanel);
             pCenter.add("Center", pSearchCrieteriaPanel);


            /* panel.add(myLabel,BorderLayout.WEST);
             panel.add(myTextField,BorderLayout.CENTER);
             panel.add(convert,BorderLayout.EAST);
             panel.setPreferredSize(new Dimension(50,50));*/

             /*window.add("North",pNorth);
             window.add("Center",pCenter);*/
         }

         /**
          * This method will construct the Page heading.
          */
         private JLabel pageHeading(JLabel welcomeTranslatorLabel) {

             welcomeTranslatorLabel = new JLabel();
             welcomeTranslatorLabel.setText("<html><FONT SIZE=14>"+TranslatorApplication.heading+"</FONT></html>");
             welcomeTranslatorLabel.setOpaque(true);
             welcomeTranslatorLabel.setBackground(Color.WHITE);
             welcomeTranslatorLabel.setHorizontalAlignment(SwingConstants.CENTER);

             return  welcomeTranslatorLabel;
         }


         private JLabel addInputStringLabel(JLabel inputTextLabel) {

             inputTextLabel = new JLabel();
             welcomeTranslatorLabel.setText(TranslatorApplication.inputLabel);

             return inputTextLabel;
         }



         String[] englishArray = {"Dog", "Cat", "Chicken", "Head", "Hand", "Foot"};


         @Override
         public void keyTyped(KeyEvent e) {

         }

         @Override
         public void keyPressed(KeyEvent e) {

         }

         @Override
         public void keyReleased(KeyEvent e) {

         }


         private class WindowCloser extends WindowAdapter {
             public void windowClosing(WindowEvent event) {
                 System.exit(0);
             }
         }

     }