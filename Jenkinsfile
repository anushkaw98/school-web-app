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

        stage('Download SonarQube Report') {
    steps {
        script {
            // Get the workspace path
            def workspacePath = env.WORKSPACE

            // Get the job name
            def jobName = env.JOB_NAME

            // Define the path to the SonarQube report
            def reportPath = "${workspacePath}/target/sonar"

            // Create the directory if it doesn't exist
            sh "mkdir -p ${reportPath}"

            // Download the SonarQube report
            sh "curl -o ${reportPath}/sonar-report.pdf http://192.168.168.132:9000/api/pdfreport/show?id=${jobName}"

            // Send the report via email
            emailext(
                subject: 'SonarQube Analysis Report',
                body: 'Attached is the SonarQube analysis report.',
                attachmentsPattern: "${reportPath}/sonar-report.pdf",
                to: 'dammithari@gmail.com',
            )
        }
    }
}

        

        stage('Deploy') {
            steps {
                script {
                    // Define the path to the WAR file
                    def warFilePath = '/opt/tomcat/webapps/school-web-app.war'

                    // Check if the WAR file exists
                    if (fileExists(warFilePath)) {
                        // If it exists, delete it
                        sh "rm -f ${warFilePath}"
                    }

                    // Copy the new WAR file
                    sh "cp target/school-web-app.war /opt/tomcat/webapps"
                }
            }
        }
    }
}
