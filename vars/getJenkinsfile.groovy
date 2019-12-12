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
			echo "${currentBuild.changeSets}"
			
			
			<!-- CHANGE SET -->
<% changeSet = build.changeSet
if (changeSet != null) {
hadChanges = false %>
<h2>Changes</h2>
<ul>
<% changeSet.each { cs ->
hadChanges = true
aUser = cs.author %>
<li>Commit <b>${cs.revision}</b> by <b><%= aUser != null ? aUser.displayName :      it.author.displayName %>:</b> (${cs.msg})
<ul>
<% cs.affectedFiles.each { %>
<li class="change-${it.editType.name}"><b>${it.editType.name}</b>: ${it.path}                              </li> <%  } %> </ul>   </li> <%  }

 if (!hadChanges) { %>  
  <li>No Changes !!</li>
 <%  } %>   </ul> <% } %>
	
	
		}
		}
	}
} // Pipeline
	
}


