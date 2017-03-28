pipeline {
    agent any
    stages {
        stage ('Delete previous') {
            steps {
                sh './uninstall.sh'
            }
        }
        stage ('Build') {
            steps {
                sh './gradlew build buildDocker'
            }
        }
        stage ('Deploy') {
            steps {
                sh 'docker-compose -p weight-control -f src/main/docker/docker-compose.yml up -d'
            }
        }
    }
}
