pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                dir('path/to/your/maven/project') {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    def warFile = sh(returnStdout: true, script: 'ls /opt/tomcat-staging/webapps/target/*.war').trim()
                    def tomcatWebapps = '/opt/tomcat-staging/webapps'

                    // Remove existing .war file
                    sh "rm -f ${tomcatWebapps}/*.war"

                    // Copy new .war file to Tomcat webapps
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
