#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties
**/


def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {

/*
    String discardList = new String()
    discardList.add(BuildDiscarderProperty(strategy(setDiscardProperties(
            artifactDaysToKeepStr: '',
            artifactNumToKeepStr: '1',
            daysToKeepStr: '60',
            numToKeepStr: '60'))))

*/

    discardList = [];

    discardList.push(buildDiscarder(logRotator(
                daysToKeepStr: '7',
                numToKeepStr: '25')))

    properties([
        discardList
    ])
}
