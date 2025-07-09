#!/usr/bin/env groovy

library identifier: 'jenkins-shared-library@main', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://github.com/MoDiaa/jenkins-shared-library.git',
         credentialsId: 'github'
        ]
)



def gv

pipeline {
    agent any

    tools {
        gradle 'gradle' // Name of the Gradle version configured in Jenkins
    }

    stages {

        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }

        stage("build and push image") {
            steps {
                script {
                    buildImage 'mohameddiaa10/myrepo:gradle-simple-app'
                    dockerLogin()
                    dockerPush 'mohameddiaa10/myrepo:gradle-simple-app'
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "Deploying the application..."
                   // gv.deployApp()
                }
            }
        }

    }   
}
