package pkg_Mechanics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.awt.image.*;

/**
 * This class implements a simple graphical user interface with a text entry
 * area, a text output area and an optional image.
 * 
 * @author Michael Kolling
 * @version 1.0 (Jan 2003)
 */
public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame myFrame;
    private JTextField entryField;
    private JTextArea log, timer;
    private JLabel aImage;
    private JButton aB1;
    private JButton aB2;
    private JButton aB3;
    private JButton aB4;
    private JButton aB5;
    private JButton aB6;
    private JButton aB7;
    /**
     * Construct a UserInterface. As a parameter, a Game Engine
     * (an object processing and executing the game commands) is
     * needed.
     * 
     * @param gameEngine  The GameEngine object implementing the game logic.
     */
    public UserInterface(final GameEngine pGameEngine)
    {
        aEngine = pGameEngine;
        createGUI();
    }

    /**
     * Print out some text into the text area.
     */
    public void print(final String pText)
    {
        log.append(pText);
        log.setCaretPosition(log.getDocument().getLength());
    }

    /**
     * Print out some text into the text area, followed by a line break.
     */
    public void println(final String pText)
    {
        log.append(pText + "\n");
        log.setCaretPosition(log.getDocument().getLength());
    }

    public void setTimer(final String pText)
    {
        timer.setText(pText);
    }//setTimer

    /**
     * Show an image file in the interface.
     */
    public void showImage(final String pImageName)
    {
        URL vImageURL = this.getClass().getClassLoader().getResource(pImageName);
        if(vImageURL == null)
            System.out.println("image not found");
        else 
        {
            ImageIcon vIcon = new ImageIcon(vImageURL);
            aImage.setIcon(vIcon);
            myFrame.pack();
        }
    }

    /**
     * Enable or disable input in the input field.
     */
    public void enable(final boolean on)
    {
        entryField.setEditable(on);
        if(!on)
            entryField.getCaret().setBlinkRate(0);
    }

    /**
     * Set up graphical user interface.
     */
    private void createGUI()
    {
        myFrame = new JFrame("Zuul-Vie");
        entryField = new JTextField(34);

        log = new JTextArea();
        log.setEditable(false);
        JScrollPane listScroller = new JScrollPane(log);
        listScroller.setPreferredSize(new Dimension(700, 700));
        listScroller.setMinimumSize(new Dimension(100,100));

        JPanel panel = new JPanel();
        aImage = new JLabel();

        JPanel panelBoutton = new JPanel();
        panelBoutton.setLayout(new GridLayout(4,2));

        timer = new JTextArea();
        timer.setEditable(false);
        panelBoutton.add(timer);
        
        aB1 = new JButton("North");
        aB1.addActionListener(this);
        panelBoutton.add(aB1);

        aB2 = new JButton("South");
        aB2.addActionListener(this);
        panelBoutton.add(aB2);

        aB3 = new JButton("East");
        aB3.addActionListener(this);
        panelBoutton.add(aB3);

        aB4 = new JButton("West");
        aB4.addActionListener(this);
        panelBoutton.add(aB4);
        
        aB5 = new JButton("Up");
        aB5.addActionListener(this);
        panelBoutton.add(aB5);
        
        aB6 = new JButton("Down");
        aB6.addActionListener(this);
        panelBoutton.add(aB6);
        
        aB7 = new JButton("Help");
        aB7.addActionListener(this);
        panelBoutton.add(aB7);
        
        panel.setLayout(new BorderLayout());
        panel.add(aImage, BorderLayout.NORTH);
        panel.add(listScroller, BorderLayout.CENTER);
        panel.add(entryField, BorderLayout.SOUTH);
        panel.add(panelBoutton, BorderLayout.WEST);

        myFrame.getContentPane().add(panel, BorderLayout.CENTER);

        // add some event listeners to some components
        myFrame.addWindowListener(new WindowAdapter() 
            {
                public void windowClosing(WindowEvent e) {System.exit(0);}
            }); 

        entryField.addActionListener(this);

        myFrame.pack();
        myFrame.setVisible(true);
        entryField.requestFocus();
    }

    /**
     * Actionlistener interface for entry textfield.
     */
    public void actionPerformed(final ActionEvent pE) 
    {
        // no need to check the type of action at the moment.
        // there is only one possible action: text entry
        if(pE.getSource()==entryField) processCommand();
        else  
        {
            if (pE.getSource()==aB1)aEngine.interpretCommand("go " + aB1.getText());
            if (pE.getSource()==aB2)aEngine.interpretCommand("go " + aB2.getText());
            if (pE.getSource()==aB3)aEngine.interpretCommand("go " + aB3.getText());
            if (pE.getSource()==aB4)aEngine.interpretCommand("go " + aB4.getText()); 
            if(pE.getSource()==aB5)aEngine.interpretCommand("go " + aB5.getText());
            if(pE.getSource()==aB6)aEngine.interpretCommand("go " + aB6.getText());
            if(pE.getSource() == aB7) aEngine.interpretCommand("help");
        }
    }

    /**
     * A command has been entered. Read the command and do whatever is 
     * necessary to process it.
     */
    private void processCommand()
    {
        boolean vFinished = false;
        String vInput = entryField.getText();
        entryField.setText("");
        aEngine.interpretCommand(vInput);
    }//processCommand
}
