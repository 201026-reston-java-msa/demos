#!/bin/bash

# basics
sudo yum update -y
sudo yum remove -y java
sudo yum install -y git java-1.8.0-openjdk-devel
sudo yum install maven -y
sudo amazon-linux-extras install tomcat8.5 -y

# Change tomcat port to 8085 (this command edits a file in place, and uses regular expressions to determine what to do)
sudo sed -i 's/<Connector port=\"8080\"/<Connector port=\"8085\"/' /etc/tomcat/server.xml
sudo service tomcat start

# jenkins:
sudo wget -O /etc/yum.repos.d/jenkins.repo \
    https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
sudo yum upgrade
sudo yum install jenkins java-1.8.0-openjdk-devel
sudo systemctl daemon-reload
sudo systemctl start jenkins
