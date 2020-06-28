def call(body){
pipeline{
    agent any
    stages{
        stage('one'){
            steps{
                script{
                    echo "Hello"                
                }
            }
        }
    }
}//pipeline
}// call
