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
                sh './gradlew build sonarqube buildDocker'
            }
        }
        stage ('Deploy') {
            steps {
                sh 'docker-compose -p weight-control -f src/main/docker/docker-compose.yml up -d'
            }
        }
    }
    post {
        success {
            script {
                sh 'curl -s ' + "http://myhubot_hubot_1:1234/build/${env.JOB_NAME}/success"
            }
        }
        unstable {
            script {
                sh 'curl -s ' + "http://myhubot_hubot_1:1234/build/${env.JOB_NAME}/unstable"
            }
        }
        failure {
            script {
                sh 'curl -s ' + "http://myhubot_hubot_1:1234/build/${env.JOB_NAME}/failure"
            }
        }
    }
}
