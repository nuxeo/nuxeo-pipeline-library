package org.nuxeo.ci.jenkins.pipeline

class ReleaseUtils {

    @NonCPS
    static def readLog(String log) {
        return new ConfigSlurper().parse(log).flatten()
    }
}
