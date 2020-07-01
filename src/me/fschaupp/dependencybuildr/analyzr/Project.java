package me.fschaupp.dependencybuildr.analyzr;

import java.util.List;

public class Project {
  private final Project INSTANCE = new Project();

  private List<Package> packageDependencies;
  private List<Project> projectDependencies;

  public Project getInstance() {
    return INSTANCE;
  }
}
