pipeline {
    agent any

    stages {
        stage('Remove Old .war File') {
            steps {
                script {
                    /
                    sh 'rm -f /opt/tomcat-staging/webapps/school-web-app.war'
                }
            }
        }

        stage('Build .war File') {
            steps {
                dir('/path/to/your/project') {
                    
                    sh 'mvn clean package'
                }
            }
        }

        stage('Deploy .war to Tomcat') {
            steps {
                script {
                    // Replace 'your-war-file-name.war' and '/path/to/tomcat/webapps/' with actual values
                    sh 'cp /home/anushka/anushka_projects/school_web/school-web-app/target/school-web-app.war /opt/tomcat-staging/webapps'
                }
            }
        }
    }
}
