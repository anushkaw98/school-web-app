pipeline {
    agent any
    
    environment {
        MAVEN_HOME = tool 'Maven'
    }
    
   
    
    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                script {
                    def mvnCmd = "${MAVEN_HOME}/bin/mvn"
                    sh "${mvnCmd} clean package"
                }
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    def warFile = sh(returnStdout: true, script: 'ls target/*.war').trim()
                    def tomcatWebapps = '/opt/tomcat-staging/webapps' 
                    sh "cp ${warFile} ${tomcatWebapps}/"
                }
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
    }
}
