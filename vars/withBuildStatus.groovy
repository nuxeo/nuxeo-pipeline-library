/**
 * body's execution control that propagates build statuses to github according to the result
 */
def call(String context, String repourl, String sha, Closure body) {
  currentBuild.result = 'SUCCESS'
  setBuildStatus("", "PENDING", context, repourl, sha)
  try {
    body.call()
    setBuildStatus("", "SUCCESS", context, repourl, sha)
  } catch (Throwable cause) {
    setBuildStatus(cause.toString().take(140), "FAILURE", context, repourl, sha)
    throw cause
  }
}

/**
 * https://wiki.jenkins.io/display/JENKINS/GitHub+Plugin
 */
def setBuildStatus(String message, String state, String context, String repourl, String sha) {
  step([
      $class             : "GitHubCommitStatusSetter",
      reposSource        : [$class: "ManuallyEnteredRepositorySource", url: repourl],
      contextSource      : [$class: "ManuallyEnteredCommitContextSource", context: context],
      errorHandlers      : [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      commitShaSource    : [$class: "ManuallyEnteredShaSource", sha: sha],
      statusBackrefSource: [$class: "ManuallyEnteredBackrefSource", backref: "${BUILD_URL}"],
      statusResultSource : [$class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]]]
  ]);
}

