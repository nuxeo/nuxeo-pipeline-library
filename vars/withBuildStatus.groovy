#!groovy

/**
 * body's execution control that propagates build statuses to github according to the result
 */
def call(String context, String repourl, String sha, String backref, Closure body) {
  currentBuild.result = 'SUCCESS'
  setBuildStatus("", "PENDING", context, repourl, sha, backref)
  try {
    body.call()
    setBuildStatus("", "SUCCESS", context, repourl, sha, backref)
  } catch (Throwable cause) {
    setBuildStatus(cause.toString().take(140), "FAILURE", context, repourl, sha, backref)
    throw cause
  }
}

