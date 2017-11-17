package org.nuxeo.ci.jenkins.pipeline

class MavenUtils {

    static def getMavenVersion(String pomPath) {
        return new XmlSlurper().parse(new File(pomPath)).version
    }

}