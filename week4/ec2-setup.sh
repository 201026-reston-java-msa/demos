## SSH into your EC2 instance
## Make sure that your EC2 
## If you're on Windows right click on your folder where you've stored your pem file, click Gitbash Here
## SSH into your EC2 instance by copy and paste the ssh command that allows you to connect to your Linux EC2 instance with your pem key, similar to this:
ssh -i "my-key-pair.pem" ec2-user@ec2-18-224-70-167.us-east-2.compute.amazonaws.com

# Setup your EC2
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

# To install jenkins, run the following
sudo wget -O /etc/yum.repos.d/jenkins.repo \
    https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key
sudo yum upgrade
sudo yum install jenkins java-1.8.0-openjdk-devel
sudo systemctl daemon-reload
sudo systemctl start jenkins

# Navigate to your EC2 endpoint 