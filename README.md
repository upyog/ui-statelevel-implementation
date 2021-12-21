                     eGov State Level Customization test Implementation

1. Create a new maven project for State level UI automation for the respective state. 
2. Create a new repository in github for the project and push the code to github.
3. Keep the following settings.xml file under the .m2 folder in your system. 
4. Update the username and personal access token in the file accordingly.

<profiles>
    <profile>
      <id>github</id>
      <repositories>
        <repository>
          <id>central</id>
          <url>https://repo1.maven.org/maven2</url>
        </repository>
        <repository>
          <id>github</id>
          <url>https://maven.pkg.github.com/egovernments/ui-statelevel-automation</url>
          <snapshots>
            <enabled>true</enabled>
          </snapshots>
        </repository>
      </repositories>
    </profile>
  </profiles>

  <servers>
    <server>
      <id>github</id>
      <username>USERNAME</username>
      <password>PERSONAL ACCESS TOKEN</password>
    </server>


5. Add the dependency of Core UI automation repo in the pom.xml of the newly created maven project. This will download the core UI automation jar from central maven repository

<dependency>
  <groupId>stateeGovernanceUI</groupId>
  <artifactId>satateegovui</artifactId>
  <version>0.0.1-SNAPSHOT</version>
</dependency>

Note: Version may differ based on the latest version.


6.Add the state level tests in this new maven project and use the already existing step definitions and utilities from core UI automation repo.

● Add feature files under the package: src/test/java/
● Add step definitions under the package: src/main/java/stepDefinition
● Add test data in the following folder: src/test/java/TestData
● Add testing.xml with the test which is needed to run
● To run the tests, execute the following maven command : 
$ mvn test -DdataPath=pathToDataPropertiesFile -DcredsPath=pathToCredentialsPropertiesFile

