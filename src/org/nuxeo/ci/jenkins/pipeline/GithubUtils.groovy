/*
 * (C) Copyright 2017 Nuxeo (http://nuxeo.com/) and others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package org.nuxeo.ci.jenkins.pipeline

import groovy.json.JsonSlurper

class GithubUtils {

    static class Repository implements Serializable {
        String owner
        String name
        Boolean isPrivate
    }

    /**
     * Given a blob URL (https://api.github.com/repos/nuxeo/integration-scripts-priv/contents/private-packages.ini),
     * fetch the Repository JSON object of the Blob (https://api.github.com/repos/nuxeo/integration-scripts-priv)
     * and return it as a simple org.nuxeo.ci.jenkins.pipeline.GithubUtils.Repository object
     *
     * @param blobURL
     * @param username
     * @param password
     * @return
     */
    static Repository getRepositoryFromBlob(String blobURL, String username, String password) {
        def connection = new URI(blobURL).resolve('..').toString()[0..-2].toURL().openConnection()
        connection.setRequestProperty('Authorization', 'Basic ' + Base64.encoder.encodeToString("${username}:${password}".bytes))

        try {
            def jsonRepository = new JsonSlurper().parseText(connection.inputStream.text)
            return new Repository(
                    owner: jsonRepository.owner.login,
                    name: jsonRepository.name,
                    isPrivate: jsonRepository.private
            )
        } finally {
            connection.disconnect()
        }
    }

    /**
     * Check from Github API if https://api.github.com/repos/${owner}/${repository}/branches/${branch} exists.
     * If true, return the branch name or the name of the fallback branch.
     *
     * @param owner
     * @param repository
     * @param branch
     * @param token
     * @param password
     * @param fallback
     * @return
     */
    static String checkForBranch(String owner, String repository, String branch, String username, String password, String fallback = 'master') {
        def connection = (HttpURLConnection) "https://api.github.com/repos/${owner}/${repository}/branches/${branch}".toURL().openConnection()
        connection.setRequestProperty('Authorization', 'Basic ' + Base64.encoder.encodeToString("${username}:${password}".bytes))

        switch(connection.responseCode) {
            case HttpURLConnection.HTTP_OK:
                return branch
            default:
                return fallback
        }
    }

}
