def call(){
  junit '**/target/surefire-reports/TEST-*.xml'
	archive 'target/*.jar'
}
