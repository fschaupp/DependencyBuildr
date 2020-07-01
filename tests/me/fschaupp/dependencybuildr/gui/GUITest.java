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
class GUITest {

  private GUI gui;
  private JTextField path;

  @BeforeAll
  public void setup() {
    gui = new GUI();

    try {
      Field pathField = GUI.class.getDeclaredField("path");
      pathField.setAccessible(true);
      path = (JTextField) pathField.get(gui);
    } catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) {
      Assertions.fail(e);
    }

    assertNotNull(path);
  }

  @Test
  public void setSelectionEmptyOrNull() {
    try {
      gui.setSelection(null);
    } catch (IOException e) {
      fail("this should not be possible");
    }

    assertEquals("", path.getText());
  }

  @Test
  public void setSelectionNotExistent() {
    try {
      gui.setSelection(new File("foo/bar/baz"));
      fail("an exception should be thrown, when the file not exists");
    } catch (IOException e) {
      assertEquals("The provided file does not exist", e.getMessage());
    }
  }

}
