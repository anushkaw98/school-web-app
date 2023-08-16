pipeline {
    agent any
    
    stages {
        stage('Check and Install Maven') {
            steps {
                script {
                    def mavenHome = tool name: 'Maven', type: 'hudson.tasks.Maven$MavenInstallation'
                    if (mavenHome) {
                        echo "Maven is already installed at ${mavenHome}"
                    } else {
                        echo "Maven is not installed. Installing now..."
                        def mvnTool = tool name: 'Maven', type: 'hudson.tasks.Maven$MavenInstaller'
                        if (!mvnTool) {
                            error "Failed to install Maven."
                        }
                    }
                }
            }
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
