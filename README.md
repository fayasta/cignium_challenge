# cignium_challenge
This repository contains the challenge code.

# Selenium Challenge

STEPS TO INSTALL AND SET UP THE ENVIRONMENT
===========================================

I) Install JAVA

1. Install Java SDK https://www.oracle.com/technetwork/java/javaee/downloads/jdk8-downloads-2133151.html 
2. Select the correct SDK based on the operating system
3. Set the environment variable
4. Go to your machine settings
  * In System variables, add: ```JAVA_HOME C:\Program Files\Java\jdk1.8.0_201 (Example of Java location)```
  * User variables for YourUser, edit *Path* variable and add --> ```%JAVA_HOME%\bin```
5. To verify the installation, open the terminal and run the following commands: 
  * ```java -version```
  * ```javac```

II) Install MAVEN

1. Download Maven Binary zip archive from https://maven.apache.org/download.cgi
2. Unzip the binary and save it in a folder.
3. Set the environment variable
4. Go to your machine settings
  * In System variables, add: ```MAVEN_HOME D:\Maven\apache-maven-3.5.4 (Example of Maven location)```
  * User variables for YourUser, edit **Path** variable and add --> ```%MAVEN_HOME%\bin```
5. To verify the installation, open the terminal and run the following commands: 
  * ```mvn -version```
    
 III) Install Git
   1. Install gitbhub from https://git-scm.com/download/win
   2. Clone the repository: git clone https://github.com/fayasta/cignium_challenge_web.git
 
 RUN THE PROJECT
 ===============
 
 1. Open a terminal
 2. Go to the project folder ```.../cignium_challenge```
 3. Run the command line ```mvn clean test```
 
