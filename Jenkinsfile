pipeline {
    agent any
    stages {
        stage('Build Maven') {
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
        stage("Docker Build Image"){
            steps{
                script{
                    withCredentials([usernameColonPassword(credentialsId: 'docker', variable: 'dockerhub')]) {
                       sh 'docker build -t rasitesdmr1486/springboot-jenkins-gcp:latest .'
                    }

                }

            }

        }
        stage("Docker Push Image"){
            steps{
                script{
                    withDockerRegistry(credentialsId: 'docker', url: 'dokcer') {
                       sh 'docker tag rasitesdmr1486/springboot-jenkins-gcp:latest rasitesdmr1486/springboot-jenkins-gcp:latest'
                       sh 'docker push rasitesdmr1486/springboot-jenkins-gcp:latest'
                    }

                }

            }

        }

        stage("Docker Compose"){
           steps{
                 sh 'docker-compose -d'
           }
        }

    }
}
