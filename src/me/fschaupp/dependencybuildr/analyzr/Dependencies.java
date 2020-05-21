package me.fschaupp.dependencybuildr.analyzr;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dependencies {
  private final Dependencies INSTANCE = new Dependencies();

  private List<Dependency> dependencies;
  private Map<String, DependencyBuilder> dependencyBuilder = new HashMap<String, DependencyBuilder>();

  public Dependencies getInstance() {
    return INSTANCE;
  }

  public void registerBuilder(String builderName, DependencyBuilder builder) {
    if (!dependencyBuilder.containsKey(builderName)) {
      dependencyBuilder.put(builderName, builder);
    }
  }
}
