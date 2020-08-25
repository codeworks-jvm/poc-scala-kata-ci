FROM jenkins/jenkins

MAINTAINER Denise NGUYEN <denise.nguyen@codeworks.fr>

ENV JENKINS_USER admin
ENV JENKINS_PASS admin

ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY plugins.txt /usr/share/jenkins/plugins.txt
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/plugins.txt

USER root

RUN apt update -qq && apt install -y apt-transport-https ca-certificates curl gnupg2 software-properties-common
RUN curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add -
RUN apt-key fingerprint 0EBFCD88
RUN add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable"
RUN apt update && apt install -y docker-ce
RUN apt-get clean
RUN usermod -aG docker jenkins
#RUN chown -R :docker /var/run/docker.sock

USER jenkins

