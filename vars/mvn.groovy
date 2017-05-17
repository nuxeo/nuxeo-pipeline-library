
def call(goals, String version = 'maven-3.3') {
    def mvnHome = tool name: version, type: 'hudson.tasks.Maven$MavenInstallation'
    sh "${mvnHome}/bin/mvn ${goals}"
}