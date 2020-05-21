package me.fschaupp.dependencybuildr.gui;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import me.fschaupp.dependencybuildr.Constants;
import me.fschaupp.dependencybuildr.Utils;

public class GUI extends JFrame implements Utils { 
  
  private JTextField path;
  private JButton browse;
  private JFileChooser projectChooser;

  public GUI() {
    setTitle(Constants.TITLE);
    setSize(Constants.WINDOW_SIZE);
    setLocationRelativeTo(null);
    setBackground(Constants.BACKGROUND_COLOR);
    
    createUI();
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void createUI() {
    path = new JTextField();
    browse = new JButton("...");
    projectChooser = new JFileChooser();
    
    
    
  }
}
