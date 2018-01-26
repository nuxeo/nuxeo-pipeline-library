/**
 * Checks whether the current build has an upstream cause
 **/
@NonCPS
def hasUpstream() {
    return currentBuild.rawBuild.getCause(hudson.model.Cause$UpstreamCause.class) != null
}

/**
 * Navigates the upstream cause of the current cuild
 **/
@NonCPS
def upstreamCause() {
    return currentBuild.rawBuild.getCause(hudson.model.Cause$UpstreamCause.class)
}

/**
 * Copy filtered upstream artifacts to target dir
 **/
@NonCPS
def copyUpstreamArtifacts(String filename, String target, boolean flatten=true) {
    def upstreamRun = upstreamCause()?.upstreamRun
    if (upstreamRun == null) {
        return false
    }
    copyArtifacts(projectName: upstreamRun.parent.fullName, selector: [$class: 'TriggeredBuildSelector'], filter: '**/'+filename, target: target, flatten: flatten, optional: false)
    return true
}
