package me.fschaupp.dependencybuildr.analyzr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Collection;

import org.junit.jupiter.api.Test;

import me.fschaupp.dependencybuildr.DummyDependencyBuildrImpl;

class DependencyBuilderTest {

  @Test
  public void registerBuilderEmptyKey() {
    try {
      DependencyBuilder.registerBuilder("", new DummyDependencyBuildrImpl());
      fail("keys must not be empty");
    } catch (IllegalArgumentException e) {
      assertEquals("The dependency builder key must not be empty or null", e.getMessage());
      assertNull(DependencyBuilder.get(""));
    }

    try {
      DependencyBuilder.registerBuilder(null, new DummyDependencyBuildrImpl());
      fail("keys must not be null");
    } catch (IllegalArgumentException e) {
      assertEquals("The dependency builder key must not be empty or null", e.getMessage());
    }
  }

  @Test
  public void registerBuilderNullBuilder() {
    try {
      DependencyBuilder.registerBuilder("dummy", null);
      fail("a builder has to be provided");
    } catch (IllegalArgumentException e) {
      assertEquals("The dependency builder must not be null", e.getMessage());
    }
  }

  @Test
  public void registerBuilder() {
    DependencyBuilder dummy = new DummyDependencyBuildrImpl();
    DependencyBuilder.registerBuilder("dummy", dummy);
    assertEquals(dummy, DependencyBuilder.get("dummy"));
  }

  @Test
  public void unregisterBuilder() {
    DependencyBuilder unregisterTest = new DummyDependencyBuildrImpl();
    DependencyBuilder.registerBuilder("unregisterTest", unregisterTest);

    assertEquals(unregisterTest, DependencyBuilder.unregisterBuilder("unregisterTest"));
    assertNull(DependencyBuilder.get("unregisterTest"));
    assertNull(DependencyBuilder.unregisterBuilder("unregisterTest"));
  }

  @Test
  public void getAllBuilders() {
    DependencyBuilder.registerBuilder("foo", new DummyDependencyBuildrImpl("foo"));
    DependencyBuilder.registerBuilder("bar", new DummyDependencyBuildrImpl("bar"));

    Collection<DependencyBuilder> builders = DependencyBuilder.getBuilders();
    assertTrue(builders.stream().filter(b -> b.toString() == "foo").findAny().isPresent());
    assertTrue(builders.stream().filter(b -> b.toString() == "bar").findAny().isPresent());
  }

}
