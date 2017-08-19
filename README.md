Project Title :

Sample selenium tests for a wordpress blogging webpage

Prerequisites :

Java8 , MAVEN , CHROME Browser

Installation :

1. clone the repository in a convenient location .
2. mvn clean test (this will run the selenium tests)


Test Configurations :
Testng tests are categorized under groups so that selective tests can be triggered by appropriate configuration in testng.xml
or passing -D arguments from command line

Groups name :
TrivialTests
PublishTests
CommentTests

mvn clean test -Dgroups=CommentTests