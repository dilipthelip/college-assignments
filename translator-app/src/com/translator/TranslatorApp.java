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

    private static final String translate ="Translate to Spanish";
    public static String title = "Translator Application";
    public static String inputLabel ="Please enter the input in English";
    public static String heading ="Translator Application";
    private static String defaultInput="Enter some input";
    private static String enterValidString="Please enter some valid input";
    private static String invalidInput="Invalid Input";
    private static String reset="Reset";
    private static String[]  inputEnglishArray = {"Dog", "Cat", "Chicken", "Head", "Hand", "Foot"};
    private static String[] outputSpanishhArray = {"Perro", "Gato", "Pollo", "Cabeza", "Mano", "Pie"};
    private static String[] imageArray = {"/src/com/translator/images/Dog.jpg","/src/com/translator/images/Cat.jpg",
                                            "/src/com/translator/images/Chicken.png","/src/com/translator/images/Head.jpg"
                                            ,"/src/com/translator/images/Hand.jpg","/src/com/translator/images/Foot.jpeg" }   ;
    private static String emptyString="";
    private static String resetScreen="Please reset before searching for a new value.";

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
        ImageIcon image,selectImage;
        private JLabel imageLabel,imageLabel3,inputTextLabel,spanishLabel,diplayImageLabel;
        private JTextField inputTextField;
        private JButton convert,reset;

        boolean imagePresentinScreen=false;


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
            reset.addActionListener(clickAction);

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
            welcomeTranslatorLabel.setText("<html><FONT SIZE=14>"+TranslatorApp.heading+"</FONT></html>");
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
            boolean valuePresent;

            @Override
            public void actionPerformed(ActionEvent e) {


                if(e.getSource()==convert){

                    if(imagePresentinScreen){
                          invalidInputValidation(TranslatorApp.resetScreen);
                    }

                    enteredValue=inputTextField.getText();


                    int position=-1;

                    for(String s : TranslatorApp.inputEnglishArray){

                        position =position+1;

                        if(s.equals(enteredValue) && !imagePresentinScreen){

                            String spanishOutput = "Spanish Equivalent is : " +  outputSpanishhArray[position];

                            spanishLabel = new JLabel(spanishOutput );
                            spanishLabel.setFont(new Font("Serif", Font.BOLD, 30));

                            String imageOutput = imageArray[position];

                            searchcrieteriaPanel.add(spanishLabel);
                            searchcrieteriaPanel.add(displayImage(imageOutput));
                            imagePresentinScreen = true;
                            searchcrieteriaPanel.revalidate();
                            searchcrieteriaPanel.repaint();
                            valuePresent=true;
                            break;
                        }
                    }

                    if(!valuePresent){
                            invalidInputValidation(TranslatorApp.enterValidString);
                    }
                }else if(e.getSource() == reset){

                    spanishLabel.setText(TranslatorApp.emptyString);
                    inputTextField.setText(TranslatorApp.defaultInput);
                    
                    /**
                     * Reseting the image
                     */
                    selectImage = new ImageIcon();
                    diplayImageLabel.setIcon(selectImage);

                    imagePresentinScreen=false;
                    valuePresent=false;
                    searchcrieteriaPanel.revalidate();
                    searchcrieteriaPanel.repaint();
                    inputTextField.revalidate();
                    inputTextField.repaint();
                }

            }

            private JLabel displayImage(String location) {


                    //selectImage = new ImageIcon("/Dilip/College-Assignments/Vannesa/codebase/translator-app/src/com/translator/Chicken.png");
                String path = System.getProperty("user.dir").concat(location);
                System.out.println("Path is : " + path);
                selectImage = new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT));
                diplayImageLabel = new JLabel("",selectImage,JLabel.CENTER);

                    return  diplayImageLabel;
            }

            /**
             * This method is used to validate the input string.
              * @param enteredString
             */
            private void invalidInputValidation(String enteredString) {

                    JPanel warning=new JPanel();
                    JOptionPane.showMessageDialog
                            (warning,
                                    enteredString,
                                    TranslatorApp.invalidInput,
                                    JOptionPane.ERROR_MESSAGE
                            );
            }

        }
    }
}
