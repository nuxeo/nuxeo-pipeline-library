#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties
**/


def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {

    properties([
    [$class: 'BuildDiscarderProperty', strategy:
        [$class: 'LogRotator',
            artifactDaysToKeepStr: '',
            artifactNumToKeepStr: '1',
            daysToKeepStr: '60',
            numToKeepStr: '60']]
    ])
}
