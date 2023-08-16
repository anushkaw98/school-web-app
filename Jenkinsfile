pipeline {
    agent any 

    stages{
        stage('Build'){
            steps {
                sh 'mvn clean package'
            }
            post {
                success {
                    echo 'Now Archiving...'
                    archiveArtifacts artifacts: '**/target/*.war'
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
