pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the code from Git
                checkout scm
            }
        }

        stage('Build') {
            steps {
                // Build your project using Maven
                sh 'mvn clean install'
            }
        }

        stage('Static Code Analysis') {
            steps {
                // Run SonarQube analysis
                withSonarQubeEnv('server-sonar') {
                    sh 'mvn sonar:sonar'
                }
            }
        }

        stage('Deploy') {
            steps {
                script {

                    // Check if the WAR file exists
                    if (fileExists(/opt/tomcat-staging/webapps/school-web-app.war)) {
                        // If it exists, delete it
                        sh "rm -f /opt/tomcat-staging/webapps/school-web-app.war"
                    }

                    // Copy the new WAR file
                    sh "cp target/school-web-app.war /opt/tomcat-staging/webapps"
        }
    }
}



        stage('Restart Tomcat') {
            steps {
                // Restart Tomcat
                sh '/opt/tomcat-staging/bin/shutdown.sh'
                sh '/opt/tomcat-staging/bin/startup.sh'
            }
        }
    }

   
}
