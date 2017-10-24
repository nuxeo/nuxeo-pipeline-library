
@NonCPS
def checkForBranch(def url, String token, String passwd) {
    def connection = (HttpURLConnection) url.toURL().openConnection()
    connection.setRequestProperty('Authorization', "${env.GITHUB_TOKEN}:${env.GITHUB_PASSWD}")

    switch(connection.responseCode) {
        case HttpURLConnection.HTTP_OK:
            return branch
        default:
            return fallback
    }
}

def call(String owner, String repository, String branch, String fallback = 'master') {
    withCredentials([usernamePassword(credentialsId: 'eea4e470-2c5e-468f-ab3a-e6c81fde94c0', passwordVariable: 'GITHUB_PASSWD', usernameVariable: 'GITHUB_TOKEN')]) {
        return checkForBranch("https://api.github.com/repos/${owner}/${repository}/branches/${branch}", env.GITHUB_TOKEN, env.GITHUB_PASSWD)
    }
}