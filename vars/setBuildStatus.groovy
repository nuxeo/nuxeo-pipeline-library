#!groovy

/**
 * https://wiki.jenkins.io/display/JENKINS/GitHub+Plugin
 */
def call(String message, String state, String context, String repourl, String sha, String backref) {
  step([
      $class             : "GitHubCommitStatusSetter",
      reposSource        : [$class: "ManuallyEnteredRepositorySource", url: repourl],
      contextSource      : [$class: "ManuallyEnteredCommitContextSource", context: context],
      errorHandlers      : [[$class: "ChangingBuildStatusErrorHandler", result: "UNSTABLE"]],
      commitShaSource    : [$class: "ManuallyEnteredShaSource", sha: sha],
      statusBackrefSource: [$class: "ManuallyEnteredBackrefSource", backref: backref],
      statusResultSource : [$class: "ConditionalStatusResultSource", results: [[$class: "AnyBuildResult", message: message, state: state]]]
  ]);
}

