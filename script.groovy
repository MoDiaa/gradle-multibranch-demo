def buildJar() {
    echo "building the application..."
    sh 'gradle clean build'
} 

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'dockerhub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t mohameddiaa10/myrepo:gradle-simple-app .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        //sh 'echo $DOCKER_PASSWORD | docker login -u $DOCKER_USERNAME --password-stdin'
       // sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh 'docker push mohameddiaa10/myrepo:gradle-simple-app'
    }
}  

def deployApp() {
    echo 'deploying the application...'
} 

return this
