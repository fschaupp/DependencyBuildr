package me.fschaupp.dependencybuildr.gui;

import static me.fschaupp.dependencybuildr.gui.LayoutUtils.getConstraints;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import me.fschaupp.dependencybuildr.Utils;
import me.fschaupp.dependencybuildr.gui.filefilters.MavenFileFilter;

public class GUI extends JFrame implements Utils {

  private Container rootPane;

  private JTextField path;
  private JButton browse;
  private JFileChooser projectChooser;

  private FormLayout layout;

  public GUI() {
    createUI();

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  private void createUI() {
    setTitle(Constants.TITLE);
    setSize(Constants.WINDOW_SIZE);
    setLocationRelativeTo(null);
    getContentPane().setBackground(Constants.BACKGROUND_COLOR);

    createLayout();
    createUIComponents();
  }

  private void createUIComponents() {
    path = new JTextField();
    path.setEditable(false);
    rootPane.add(path, getConstraints(2, 2));

    projectChooser = new JFileChooser();
    projectChooser.setAcceptAllFileFilterUsed(false);
    projectChooser.setFileFilter(MavenFileFilter.INSTANCE);
    projectChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    projectChooser.addActionListener(l -> {
      System.err.println("action! " + l.getID());
    });

    browse = new JButton("...");
    browse.addActionListener(l -> projectChooser.showOpenDialog(browse));
    rootPane.add(browse, getConstraints(2, 4));
  }

  private void createLayout() {
    rootPane = getContentPane();
    layout = new FormLayout(new ColumnSpec[] {
                                               FormSpecs.UNRELATED_GAP_COLSPEC,
                                               ColumnSpec.decode("default:grow"),
                                               FormSpecs.RELATED_GAP_COLSPEC,
                                               FormSpecs.BUTTON_COLSPEC,
                                               FormSpecs.UNRELATED_GAP_COLSPEC
    },
                            new RowSpec[] {
                                            RowSpec.decode("7dlu:grow"),
                                            FormSpecs.DEFAULT_ROWSPEC,
                                            RowSpec.decode("7dlu:grow")
                            });

    rootPane.setLayout(layout);
  }
}
