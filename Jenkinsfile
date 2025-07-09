#!/usr/bin/env groovy

def gv

pipeline {
    agent any

    tools {
        gradle 'gradle' // Name of the Gradle version configured in Jenkins
    }

    stages {

        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build jar") {
            steps {
                script {
                    echo "Building the Jar..."
                    gv.buildJar()
                }
            }
        }

        stage("build image") {
            steps {
                script {
                    echo "Building the Docker image..."
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    echo "Deploying the application..."
                    gv.deployApp()
                }
            }
        }

    }   
}
