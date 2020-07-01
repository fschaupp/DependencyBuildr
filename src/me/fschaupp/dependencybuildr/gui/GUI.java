package me.fschaupp.dependencybuildr.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import me.fschaupp.dependencybuildr.Utils;

public class GUI extends JFrame implements Utils {

  private MainPanel mainPanel;

  public GUI() {
    createUI();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private void createUI() {
    setTitle(Constants.TITLE);
    setSize(Constants.WINDOW_SIZE);
    setLocationRelativeTo(null);
    getContentPane().setBackground(Constants.BACKGROUND_COLOR);

    mainPanel = new MainPanel();
    getContentPane().add(mainPanel, BorderLayout.CENTER);
  }
}
