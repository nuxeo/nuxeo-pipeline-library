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
 * Navigates the upstream run of the current cuild
 **/
@NonCPS
def upstreamRun() {
    def upstreamCause = upstreamCause()
    if (upstreamCause == null) {
        return null
    }
    return upstreamCause.upstreamRun
}


/**
 * Copy filtered upstream artifacts to target dir
 **/
@NonCPS
def copyUpstreamArtifacts(String filename, String target) {
    def upstreamRun = upstreamRun()
    if (upstreamRun == null) {
        return false
    }
    copyArtifacts(projectName: upstreamRun.parent.fullName, selector: [$class: 'TriggeredBuildSelector'], filter: '**/'+filename, target: target, flatten: true, optional: false)
    return true
}
