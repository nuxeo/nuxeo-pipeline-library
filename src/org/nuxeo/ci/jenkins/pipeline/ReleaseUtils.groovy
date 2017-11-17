package org.nuxeo.ci.jenkins.pipeline

class ReleaseUtils {

    static def readLog(String logPath) {
        return new ConfigSlurper().parse(new File(logPath).toURI().toURL()).flatten()
    }
}
