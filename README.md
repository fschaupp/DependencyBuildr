# DependencyBuildr
Ever had a project, but didn't want to hassle with maven, etc? 
We figure this out for you!

## Vision
Throw in a project folder of yours, and we'll figure out the hard stuff for you!
In case you haven't, we try to harvest some metainformation from your used libraries 
in order to bake a nifty littly pom.xml for convenience of use.

## Why should I bother?
Sometimes it happens, that somebody whants to add a tiny library when refactoring an old project
but also wants to keep it and the other existing libraries updated. 

### So what to do?
Collect all the meta information of the libraries used and 
cram it into a dependency management tool of your choice? Sure thing!
This means, you open up one of the potentially dozens of jars, extract 
the IDs and version info of the lib, find the repo hosting the most recent 
version, and then cram all of this into the file for your dependency manager yourself. 

### Sounds like a lot of work for just adding this tiny library.
"Maybe I should do it later, when I finished the change." I hear you saying, and we all know, it will never happen.

## ... and this thingy can help me?
Yup! Just select your project folder, 
we'll extract what we need and bake you a nice little file 
for your dependency manager or add what's missing.
