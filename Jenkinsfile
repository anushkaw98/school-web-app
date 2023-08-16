pipeline {
    agent any
    
    environment {
        MAVEN_HOME = tool 'Maven'
    }
    
    triggers {
        // SCM trigger watches for changes in the specified branch
        scm('*/main')
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
                    def tomcatWebapps = '/path/to/tomcat/webapps' // Change this to your Tomcat webapps directory
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
