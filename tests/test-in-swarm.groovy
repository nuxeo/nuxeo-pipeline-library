@Library('nuxeo@feature-NXBT-1770-test-and-push') _

node('slacoin') {
    
    stage('clone') {
        checkout()
    }
    
    stage('compose') {
        withDockerCompose("${JOB_NAME}-${BUILD_NUMBER}", '-f tests/docker-compose-pgsql-9.6.yml -f tests/docker-compose-swarm.yml', {}) {
            sh 'hostname'
        }
    }

}
