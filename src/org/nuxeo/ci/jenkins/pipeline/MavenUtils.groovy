package org.nuxeo.ci.jenkins.pipeline

class MavenUtils {

    @NonCPS
    static def getMavenVersion(String pomString) {
        return new XmlSlurper().parse(new StringReader(pomString)).version
    }

}