## Create an EC2 Instance on AWS with a security group that consists of "Custom TCP" on port 8080

## If you're on Windows right click on your folder where you've stored your pem file, click Gitbash Here
## SSH into your EC2 instance by copy and paste the ssh command that allows you to connect to your Linux EC2 instance with your pem key, similar to this:
ssh -i "my-key-pair.pem" ec2-user@ec2-18-224-70-167.us-east-2.compute.amazonaws.com

# Setup your EC2 environment
sudo yum install java-1.8.0-openjdk-devel -y
sudo yum install maven -y
sudo yum install git -y
sudo amazon-linux-extras install tomcat8.5 -y

# Launch Tomcat Server and deploy your application
git clone <your repo>
cd <your repo>
cd <your app>
mvn package
## This is how we copy the .war file from our target foler to tomcaps webapps folder
sudo cp target/ServletDemoAndLogin-0.0.1-SNAPSHOT.war /var/lib/tomcat/webapps/

sudo service tomcat start

#Navigate to your EC2 endpoint on port 8080 to view your application hosted on Tomcat
