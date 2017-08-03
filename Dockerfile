# Set the base image to Ubuntu
FROM ubuntu

# File Author / Maintainer
MAINTAINER Djordje Popovic

##################JAVA 8 START##################
RUN apt-get update
RUN apt-get upgrade -y
RUN apt-get install -y software-properties-common
RUN add-apt-repository ppa:webupd8team/java
RUN apt-get update
RUN echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | /usr/bin/debconf-set-selections && apt-get install -y oracle-java8-installer && apt-get clean
RUN apt-get clean
RUN java -version
RUN javac -version
#################JAVA 8 END####################

#################GIT START#####################
RUN apt-get install -y git
RUN git config --global user.name "java8-docker-container"
RUN git config --global user.email "some@email.com"
#################GIT END######################

#################MAVEN START##################
RUN apt-get update
RUN apt-get install -y maven
RUN export PATH=${M2_HOME}/bin:${PATH}
RUN mvn -version
#################MAVEN END####################

#################TICTACTOE START##############
EXPOSE 8080
ADD build/libs/tictactoe-1.0.0-SNAPSHOT.jar /tictactoe.jar
ENTRYPOINT ["java","-jar","/tictactoe.jar"]
#################TICTACTOE END################