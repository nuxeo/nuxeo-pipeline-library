package org.nuxeo.ci.jenkins.pipeline

class MavenUtils implements Serializable {

    static def getMavenVersion(String pomString) {
        return (String) new XmlSlurper().parse(new StringReader(pomString)).version
    }

}