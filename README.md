# tictactoe
TicTacToe application written by Djordje Popovic

I wrote this app using TDD, for the purpose of practicing a bit of AngularJS

The technologies used are:

Java, Angular, Gradle, Spring, SpringBoot


TO RUN THE APP:
1) Navigate to the tictactoe directory
2) Get the gradle wrapper with this command: gradle wrapper --gradle-version 3.5
3) Use spring boot to run the app: ./gradlew bootRun
4) Alternatively you can use java -jar tictactoe-1.0.0-SNAPSHOT.jar if you want to execute from the jar

TO RUN THE APP IN DOCKER:
1) docker build -t tictactoe .
2) docker run --name tictactoe -p 8080:8080 tictactoe

Known issues:
Sometimes the test don't run, you can skip them for compiling, you can use:
./gradlew clean build -x test


Other notes:

I recently added this to the gradle build file: 

classpath 'io.spring.gradle:dependency-management-plugin:0.6.1.RELEASE'

https://discuss.gradle.org/t/3-0-m1-springboot-1-3-5-project-fails-to-build-aborts-with-an-error-message-on-creation-of-dependencymanagementreporttask/17999/6
