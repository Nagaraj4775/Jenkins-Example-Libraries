def call (Map pipelineParams){
pipeline{
options {
    disableConcurrentBuilds()
    skipDefaultCheckout()
  }
  environment {
  def committerEmail = "test@transplace.com"
  }
agent any
	stages{
		stage('git clone'){
			steps{
			  	script {
				//git credentialsId: 'Bitbucket', url: 'https://NagarajuRapelli@bitbucket.org/NagarajuRapelli/mbp.git'
				stageName = "${STAGE_NAME}"
				echo "We are in git clone"	
					checkout scm	
					
			  }
		    }
		}
	} // Stages
	post {
	always{
		script {
			echo "${committerEmail}"
			echo "Calling sub function"
			testResults(true)
			echo "$pipelineParams.buildCommand"
			echo "${BRANCH_NAME}"
			echo "${currentBuild.changeSets(msg)}"
		}
		}
	}
} // Pipeline
	
}


