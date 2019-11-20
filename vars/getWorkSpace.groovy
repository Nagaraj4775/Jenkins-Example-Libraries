def call(environment,appName){
    if(environment == 'uat'){
        return "/u01/app/prod/build/${environment}/${appName}"
    }
    else{
        return "/u01/app/nonprod/build/${environment}/${appName}"
    }
}
