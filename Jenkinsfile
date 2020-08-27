pipeline {
    agent {
        docker {
            image 'maven:3.3-jdk-8'
            args '-v /root/.m2:/root/.m2 --entrypoint=""'
        }
    }
    stages {
        stage ('Build & Code Quality Scan') {
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
	    stage('Deploy Snapshot') {
	        steps {
		        echo 'Deploying the application...'
		        // Replace fileId with the created one's
		        configFileProvider([configFile(fileId: '8310d80b-cf52-422d-9041-c61556b21e28', variable: 'MAVEN_GLOBAL_SETTINGS')]) {
                    sh 'mvn -gs $MAVEN_GLOBAL_SETTINGS clean deploy -Dmaven.test.skip=true'
                }
            }
        }
    }
}
