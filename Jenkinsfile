pipeline {
    agent any

    stages {
        stage('Remove Old .war File') {
            steps {
                script {
                    // Replace 'your-war-file-name.war' with the actual name of your .war file
                    sh 'rm -f /path/to/tomcat/webapps/your-war-file-name.war'
                }
            }
        }

        stage('Build .war File') {
            steps {
                dir('/path/to/your/project') {
                    // Use the appropriate Maven command to build the project
                    sh 'mvn clean package'
                }
            }
        }

        stage('Deploy .war to Tomcat') {
            steps {
                script {
                    // Replace 'your-war-file-name.war' and '/path/to/tomcat/webapps/' with actual values
                    sh 'cp /path/to/your/project/target/your-war-file-name.war /path/to/tomcat/webapps/'
                }
            }
        }
    }
}
