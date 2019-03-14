pipeline {
 agent any
 stages {
  stage('Build') {
   steps {
    sh 'echo "Single line"'
    sh '''
     echo "Multiple Lines"
     pwd
     ls -lah
    '''
}}}}
