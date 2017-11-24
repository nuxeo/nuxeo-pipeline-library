package org.nuxeo.ci.jenkins.pipeline

class MavenUtils {

    static String getMavenVersion(String pomString) {
        return new XmlSlurper().parse(new StringReader(pomString)).version
    }

}