package me.fschaupp.dependencybuildr.analyzr;

import java.util.Map;

public class Package {

  public String name;
  public Version version;
  public String filename;

  public String[] authors;

  public Map<Package, Version> dependencies;

}
