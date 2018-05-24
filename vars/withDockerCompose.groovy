/**
 * run pipeline inside a docker compose stack, executing the post body before shutting down the stack.
 */
def withDockerCompose(String name, String lineargs, Closure post, Closure body) {
    withEnv(["COMPOSE_PROJECT_NAME=$name"]) {
        try {
            sh """#!/bin/bash -ex
                 docker-compose $lineargs pull
                 docker-compose $lineargs up --no-color --build --abort-on-container-exit
             """
            node(name) {
                body()
            }
        } finally {
            try {
                post()
            } finally {
                sh """#!/bin/bash -ex
                 docker-compose $lineargs down --rmi local --volumes --remove-orphans
              """
            }
        }
    }
}
