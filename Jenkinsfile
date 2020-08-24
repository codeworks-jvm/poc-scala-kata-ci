pipeline {
    agent {
        docker {
            image 'maven:3.3-jdk-8'
            args '-v /root/.m2:/root/.m2 --entrypoint=""'
        }
    }
    stages {
        stage ('Build & Code quality scan') {
            steps {
                withSonarQubeEnv('SonarQubeScanner') {
                    sh "mvn clean compile sonar:sonar"
                }
            }
        }
        stage('Test') {
            steps {
		        echo 'Testing the application...'
                sh 'mvn test'
            }
        }
	    stage('Deploy') {
	        steps {
		        echo 'Deploying the application...'
	        }
        }
    }
}
