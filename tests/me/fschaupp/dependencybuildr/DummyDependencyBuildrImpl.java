package me.fschaupp.dependencybuildr;

import me.fschaupp.dependencybuildr.analyzr.DependencyBuilder;

public class DummyDependencyBuildrImpl extends DependencyBuilder {

  public DummyDependencyBuildrImpl() {
    builderFlavorName = "dummy";
  }

  public DummyDependencyBuildrImpl(String name) {
    builderFlavorName = name;
  }

}
