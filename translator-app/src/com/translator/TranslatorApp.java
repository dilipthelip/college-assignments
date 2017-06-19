package com.translator;

import com.sun.javafx.binding.FloatConstant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by z001qgd on 6/18/17.
 */
public class TranslatorApp {

    private static final String translate ="Translate";
    public static String title = "Translator Application";
    public static String inputLabel ="Please enter the input in English";
    public static String heading ="Translator Application";
    private static String defaultInput="Enter some input";
    private static String enterValidString="Please enter some input";
    private static String invalidInput="Invalid Input";
    private static String reset="Reset";
    private static String[]  inputEnglishArray = {"Dog", "Cat", "Chicken", "Head", "Hand", "Foot"};
    private static String[] outputSpanishhArray = {"Perro", "Gato", "Pollo", "Cabeza", "Mano", "Pie"};
    //String[] imageArray = {"Perro", "Gato", "Pollo", "Cabeza", "Mano", "Pie"};

    public static void main(String[] args) {

        TranslatorFrame frame = new TranslatorFrame();

        frame.setTitle(title);
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }


    private static class TranslatorFrame extends JFrame {

        JPanel gridPanel = new JPanel(new GridLayout(1,4));
        JPanel searchcrieteriaPanel = new JPanel(new FlowLayout());
        JPanel spanishPanel;
        ImageIcon image;
        private JLabel imageLabel,imageLabel3,inputTextLabel,spanishLabel;
        private JTextField inputTextField;
        private JButton convert,reset;


        TranslatorFrame(){

            image = new ImageIcon("image.jpeg");

            /**
             * Page Heading
             */
            gridPanel.add(emptyWhiteBackground(imageLabel,image));
            gridPanel.add(pageHeading());
            gridPanel.add(emptyWhiteBackground(imageLabel3,image));

            /**Search Crietria**/
            buildSearchcrieteriaPanel();

            ClickAction clickAction = new ClickAction();
            convert.addActionListener(clickAction);

            spanishPanel = new JPanel(new FlowLayout());

            this.add("North", gridPanel);
            this.add(searchcrieteriaPanel);
            //this.add(spanishPanel);
           // this.add("Center",spanishPanel);

        }





        /**
         * This method is used to build the search crietria section in the GUI.
         */
        private void buildSearchcrieteriaPanel() {

            inputTextLabel = new JLabel(TranslatorApp.inputLabel);
            inputTextField = new JTextField(TranslatorApp.defaultInput, 20);
            convert = new JButton(TranslatorApp.translate);
            reset = new JButton(TranslatorApp.reset);
            searchcrieteriaPanel.add(inputTextLabel);
            searchcrieteriaPanel.add(inputTextField);
            searchcrieteriaPanel.add(convert);
            searchcrieteriaPanel.add(reset);
        }

        private JLabel emptyWhiteBackground(JLabel imageLabel, ImageIcon image) {

            imageLabel = new JLabel();
            imageLabel.setIcon(this.image);
            imageLabel.setOpaque(true);
            imageLabel.setBackground(Color.WHITE);

            return  imageLabel;
        }

        /**
         * This section is to add the Welcome Page heading.
         * @return
         */
        private JLabel pageHeading() {

            JLabel  welcomeTranslatorLabel = new JLabel();
            welcomeTranslatorLabel.setText("<html><FONT SIZE=14>"+TranslatorApplication.heading+"</FONT></html>");
            welcomeTranslatorLabel.setOpaque(true);
            welcomeTranslatorLabel.setBackground(Color.WHITE);
            welcomeTranslatorLabel.setHorizontalAlignment(SwingConstants.CENTER);
            welcomeTranslatorLabel.setHorizontalAlignment(2);

            return  welcomeTranslatorLabel;
        }


        /**
         * This class is the Action Listener for the translate Button.
         */
        private class ClickAction implements  ActionListener {

            String enteredValue;

            @Override
            public void actionPerformed(ActionEvent e) {


                if(e.getSource()==convert){

                    enteredValue=inputTextField.getText();
                    invalidInputValidation(enteredValue);

                    int position=-1;

                    for(String s : TranslatorApp.inputEnglishArray){

                        position =position+1;

                        if(s.equals(enteredValue)){

                            String spanishOutput = "Spanish Equivalent is : " +  outputSpanishhArray[position];

                            spanishLabel = new JLabel(spanishOutput );
                            spanishLabel.setFont(new Font("Serif", Font.BOLD, 30));
                            searchcrieteriaPanel.add(spanishLabel);
                            searchcrieteriaPanel.revalidate();
                            searchcrieteriaPanel.repaint();

                        }
                    }
                }



            }

            /**
             * This method is used to validate the input string.
              * @param enteredString
             */
            private void invalidInputValidation(String enteredString) {

                if(TranslatorApp.defaultInput.endsWith(enteredString)){
                    JPanel warning=new JPanel();
                    JOptionPane.showMessageDialog
                            (warning,
                                    TranslatorApp.enterValidString,
                                    TranslatorApp.invalidInput,
                                    JOptionPane.ERROR_MESSAGE
                            );
                }
            }

        }
    }
}
