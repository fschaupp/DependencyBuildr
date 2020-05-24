package me.fschaupp.dependencybuildr.gui.filefilters;

import java.io.File;

import javax.swing.filechooser.FileFilter;

/**
 * a {@link FileFilter} filtering only to pom.xml files
 * 
 * @author fschaupp
 *
 */
public final class MavenFileFilter extends FileFilter {

  public static final String MAVEN_DESCRIPTION = "Maven Project-File";
  public static final String MAVEN_PROJECT_FILE_NAME = "pom.xml";

  public static final MavenFileFilter INSTANCE = new MavenFileFilter();

  private MavenFileFilter() {
  }

  @Override
  public boolean accept(File f) {
    if (f == null || f.getName().trim().length() == 0)
      return false;

    if (f.isDirectory())
      return true;

    return f.getName().equalsIgnoreCase(MAVEN_PROJECT_FILE_NAME);
  }

  @Override
  public String getDescription() {
    return MAVEN_DESCRIPTION;
  }

}
