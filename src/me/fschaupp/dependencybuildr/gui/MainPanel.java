package me.fschaupp.dependencybuildr.gui;

import static me.fschaupp.dependencybuildr.gui.LayoutUtils.getConstraints;

import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import me.fschaupp.dependencybuildr.analyzr.DependencyBuilder;
import me.fschaupp.dependencybuildr.gui.filefilters.MavenFileFilter;

public class MainPanel extends JPanel {

  private JTextField path;
  private JButton browse;
  private JFileChooser projectChooser;

  private JComboBox<DependencyBuilder> dependencyManagementFlavors;

  private FormLayout layout;

  public MainPanel() {
    createLayout();
    createUIComponents();
  }

  private void createLayout() {
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

    setLayout(layout);
  }

  private void createUIComponents() {
    path = new JTextField();
    path.setEditable(false);
    add(path, getConstraints(2, 2));

    projectChooser = new JFileChooser();
    projectChooser.setAcceptAllFileFilterUsed(false);
    projectChooser.setFileFilter(MavenFileFilter.INSTANCE);
    projectChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
    projectChooser.addActionListener(l -> {
      if (JFileChooser.APPROVE_SELECTION.contentEquals(l.getActionCommand())) {
        try {
          setSelection(projectChooser.getSelectedFile());
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    });

    browse = new JButton("...");
    browse.addActionListener(l -> projectChooser.showOpenDialog(browse));
    add(browse, getConstraints(2, 4));

    dependencyManagementFlavors = new JComboBox<>(DependencyBuilder.getBuilders().toArray(new DependencyBuilder[0]));
  }

  public void setSelection(File selectedFile) throws IOException {
    if (selectedFile == null) {
      path.setText("");
      return;
    }

    if (!selectedFile.exists()) {
      throw new IOException("The provided file does not exist.");
    }
  }

}
