def call(){

echo "We are in Jenkins build stage"
sh "mvn clean package -Dmaven.test.failure.ignore=true"
}
