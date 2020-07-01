package me.fschaupp.dependencybuildr.analyzr;

import java.util.Map;
import java.util.TreeMap;

public abstract class DependencyBuilder {
  private static Map<String, DependencyBuilder> dependencyBuilder = new TreeMap<String, DependencyBuilder>();

  public static void registerBuilder(String builderName, DependencyBuilder builder) {
    if (builderName == null || builderName.trim().length() == 0) {
      throw new IllegalArgumentException("The dependency builder key must not be empty or null");
    }

    if (builder == null) {
      throw new IllegalArgumentException("The dependency builder must not be null");
    }

    if (!dependencyBuilder.containsKey(builderName)) {
      dependencyBuilder.put(builderName, builder);
    }
  }

  public static DependencyBuilder unregisterBuilder(String builderName) {
    if (dependencyBuilder.containsKey(builderName)) {
      return dependencyBuilder.remove(builderName);
    } else {
      return null;
    }
  }

  public static DependencyBuilder get(String builderName) {
    return dependencyBuilder.get(builderName);
  }
}
