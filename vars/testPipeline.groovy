def call(body){
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    pipeline{
        agent any
        stages{
            stage('Initialize'){
                steps{
                    script{
                        echo "Hello"          
                        echo "${config.emailTo}"      
                    }
                }
            }
            stage('sonar Analysis'){
		when {
                    expression {
                        return config.codeAnalysis == true
                    }
                }
		    
                steps{
                    script{
                        echo "Running Sonar Analysis..."             
                    }
                }
            }
        }
    }//pipeline
}// call
