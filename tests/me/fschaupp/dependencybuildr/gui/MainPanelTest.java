package me.fschaupp.dependencybuildr.gui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.swing.JTextField;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class MainPanelTest {

  private MainPanel mainPanel;
  private JTextField path;

  @BeforeAll
  public void setup() {
    mainPanel = new MainPanel();

    try {
      Field pathField = MainPanel.class.getDeclaredField("path");
      pathField.setAccessible(true);
      path = (JTextField) pathField.get(mainPanel);
    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
      Assertions.fail(e);
    }

    assertNotNull(path);
  }

  @Test
  public void setSelectionEmptyOrNull() {
    try {
      mainPanel.setSelection(null);
    } catch (IOException e) {
      fail("this should not be possible");
    }

    assertEquals("", path.getText());
  }

  @Test
  public void setSelectionNotExistent() {
    try {
      mainPanel.setSelection(new File("foo/bar/baz"));
      fail("an exception should be thrown, when the file not exists");
    } catch (IOException e) {
      assertEquals("The provided file does not exist.", e.getMessage());
    }
  }

}
