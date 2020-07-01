package me.fschaupp.dependencybuildr.analyzr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import me.fschaupp.dependencybuildr.DummyDependencyBuildrImpl;

class DependencyBuilderTest {

  @Test
  public void registerBuilderEmptyKey() {
    try {
      DependencyBuilder.registerBuilder("", new DummyDependencyBuildrImpl());
      DependencyBuilder.registerBuilder(null, new DummyDependencyBuildrImpl());
      fail("keys must not be empty or null");
    } catch (IllegalArgumentException e) {
      assertEquals("The dependency builder key must not be empty or null", e.getMessage());
      assertNull(DependencyBuilder.get(""));
    }
  }

  @Test
  public void registerBuilderNullBuilder() {
    try {
      DependencyBuilder.registerBuilder("dummy", null);
      fail("keys must not be empty");
    } catch (IllegalArgumentException e) {
      assertEquals("The dependency builder must not be null", e.getMessage());
    }
  }

}
