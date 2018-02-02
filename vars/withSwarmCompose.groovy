/**
 * run pipeline inside a docker compose stack through swarm, executing the post closure before shutting down the stack.
 */
def withSwarmCompose(String name, String file, Closure post = null, Closure body) {
    def config = JenkinsLocationConfiguration.get()
    def master = config.getUrl()
    def compose = {
        dir("${WORKSPACE}@tmp") {
            writeFile(file:'docker-compose-swarm.yml', text:libraryResource('docker-compose-swarm.yml'))
            dir('jenkins-slave-swarm') {
               writeFile(file:'Dockerfile', text:libraryResource('jenkins-slave-swarm/Dockerfile'))
            }
        }
        return "docker-compose -f $file -f ${WORKSPACE}@tmp/docker-compose-swarm.yml"
    }.call()
    
    withEnv(["COMPOSE_PROJECT_NAME=$name", "JENKINS_MASTER=$master", ]) {
        withCredentials([string(credentialsId: 'jenkins-api-token', variable: 'JENKINS_API_TOKEN')]) {
            try {
                sh """#!/bin/bash -ex                                                                                                                                                                                    
                    $compose pull                                                                                                                                                                       
                    $compose up -d --no-color --build                                                                                                                         
                """
                node(name) {
                    try {
                        body()
                    } finally {
                        if (post) {
                            post()
                        }
                    }
                }
            } finally {
                sh """#!/bin/bash -ex                                                                                                                                                                                
                    $compose down --rmi local --volumes --remove-orphans                                                                                                                                
                """
            }
        }
    }
}
