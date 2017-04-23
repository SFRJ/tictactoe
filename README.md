# tictactoe
TicTacToe application written by Djordje Popovic

I wrote this app using TDD, for the purpose of practicing a bit of AngularJS

The technologies used are:

Java, Angular, Gradle, Spring, SpringBoot


TO RUN THE APP:
1) Navigate to the tictactoe directory
2) Get the gradle wrapper with this command: gradle wrapper --gradle-version 3.5
3) Use spring boot to run the app: ./gradlew bootRun



Other notes:

I recently added this to the gradle build file: 

classpath 'io.spring.gradle:dependency-management-plugin:0.6.1.RELEASE'

https://discuss.gradle.org/t/3-0-m1-springboot-1-3-5-project-fails-to-build-aborts-with-an-error-message-on-creation-of-dependencymanagementreporttask/17999/6
