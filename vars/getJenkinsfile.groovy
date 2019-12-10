pipeline{
options {
    disableConcurrentBuilds()
    //skipDefaultCheckout()
  }
  environment {
  def committerEmail = "test@transplace.com"
  }
agent any
	stages{
		stage('git clone'){
			steps{
			  	script {
				git credentialsId: 'Bitbucket', url: 'https://NagarajuRapelli@bitbucket.org/NagarajuRapelli/mbp.git'
			  }
		    }
		}
	} // Stages
	post {
	always{
		script {
			echo "${committerEmail}"
		}
		}
	}
} // Pipeline


