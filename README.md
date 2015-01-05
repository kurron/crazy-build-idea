crazy-build-idea
================

I have an idea on how we might optimize Bamboo builds.  Bamboo has the notion
of an Artifact which is simply copying one or more files and directories from
one stage to another.  The goal is to seperate the build into stages, copying
artifacts between stages, building out a pipeline.  This is an improvement over
the current build system because now we have finer control over replaying 
failed stages.  Right now we essentially have only two options as far as
replays are concerned.  I'm proposing the following:

```
Continuous Integration tasks
----------------------------
stageOne - Executes the first stage of the CI build pipeline [assemble, groovydoc, javadoc, sourceCodeInspection, testClasses]
    sourceJar
    testSourceJar
stageTwo - Executes the second stage of the CI build pipeline [unitTest]
stageThree - Executes the third stage of the CI build pipeline [componentTest, integrationTest]
stageFour - Executes the fourth stage of the CI build pipeline [byteCodeInspection]
stageFive - Executes the fifth stage of the CI build pipeline [publication, registration]

byteCodeInspection - Runs byte code inspections [codeCoverageReport]
codeCoverageReport
componentTest - Runs component-level tests [classes, testClasses]
integrationTest - Runs integration-level tests [classes, testClasses]
publication - Publishes verified artifacts [publishToMavenLocal]
registration - Registers the artifact with the self-service deployment system
sourceCodeInspection - Runs source code inspections [classes, testClasses]
    checkstyleMain - Run Checkstyle analysis for main classes
    checkstyleTest - Run Checkstyle analysis for test classes
    codenarcMain - Run CodeNarc analysis for main classes
    codenarcTest - Run CodeNarc analysis for test classes
unitTest - Run unit-level tests [classes, testClasses]
```

Stage One compiles the source, assembles the JAR files and runs source-level inspections.  The second stage executes the unit-level tests while stage three 
runs component- and integration-level tests. Stage four runs byte code inspections, such as code coverage analysis. Finally, the fifth stage publishes the artifacts 
and notifies the self-deployment tooling.