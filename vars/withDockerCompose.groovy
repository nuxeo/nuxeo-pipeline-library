/**
 * invoke command inside a docker compose stack, executing the post body before shutting down the stack.
 */
def call(String name, String file, String command, Closure post) {
  withEnv(["COMPOSE_PROJECT_NAME=$name", "TESTS_COMMAND=$command"]) {
    try {
      sh """#!/bin/bash -ex
                 docker-compose -f $file pull
                 docker-compose -f $file up --no-color --build --abort-on-container-exit
             """
    } finally {
      try {
        post()
      } finally {
        sh """#!/bin/bash -ex
                 docker-compose -f $file down --rmi local --volumes --remove-orphans
              """
      }
    }
  }
}
