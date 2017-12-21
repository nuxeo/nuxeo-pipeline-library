/**
 * https://wiki.jenkins.io/display/JENKINS/Claim+plugin
 */
def call() {
  step([$class: 'ClaimPublisher'])
}
