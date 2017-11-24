package org.nuxeo.ci.jenkins.pipeline

class MavenUtils implements Serializable {

    static String getMavenVersion(String pomString) {
        return new XmlSlurper().parse(new StringReader(pomString)).version
    }

}