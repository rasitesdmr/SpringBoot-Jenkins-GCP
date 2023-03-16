pipeline {
    agent any
    stages {
        stage('Build') {
           agent {
             docker {
               image 'maven:3.8.5-openjdk-17'
               args '-v $HOME/.m2:/root/.m2'
               reuseNode true
             }
           }
           steps {
                 checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'rasitesdmr', url: 'https://github.com/rasitesdmr/SpringBoot-Jenkins-GCP.git']])
                 sh 'mvn clean package -DskipTests'
           }
        }

    }
}
