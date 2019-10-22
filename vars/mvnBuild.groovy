def call(Map pipelineParams){

  //echo "$pipelineParams.BuildConfiguration"
echo "We are in Jenkins build stage"
  echo "adding one more line"
//sh "mvn clean package -Dmaven.test.failure.ignore=true"
}
