package org.nuxeo.ci.jenkins.pipeline

class ReleaseUtils {

    static def readLog(String log) {
        return new ConfigSlurper().parse(log).flatten()
    }
}
