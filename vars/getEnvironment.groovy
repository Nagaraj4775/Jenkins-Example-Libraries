def call(branchValues,BRANCH){
    if (BRANCH == 'master')
		'dev' 
	else if (BRANCH == 'develop')
		'dev'
	else if (BRANCH == "${env.STAGING_BRANCH_SPEC_GIT}")
	    'staging'
	else if (BRANCH == "${env.ALPHA_BRANCH_SPEC_GIT}")
	    'alpha'
	else if (BRANCH == "${env.UAT_BRANCH_SPEC_GIT}")
	    'uat' 
	else {    
        String result;
        branchValues.each{
            if (BRANCH.matches("${it}(.*)")){
	            //println("Branch matched in fbph")
	            result = 'fb'
	        }
            else{
                null
            }
        }
        return result
	}
}
