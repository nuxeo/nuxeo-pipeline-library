#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties
**/

@NonCPS
def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {

  /*  def newParamsList = []
    def newbool = booleanParam(defaultValue: false, description: "deploy", name: "deploy_flag")
    newParamsList.add(newbool)
    def newParams = parameters(newParamsList)
    properties([ //job property declaration
        jobProperties,
        disableConcurrentBuilds(),
        newParams,
        addSchedule,
    ])
    */

/*
    @NonCPS
    def test = (buildDiscarderProperty(setDiscardProperties(
            '',
            '1',
            '60',
            '60')));

    // discarderList = buildDiscarderProperty(discardList)
    print('working 2')

*/

    /*
    def discardList = ""
    print('working 1')
    discardList.push(buildDiscarder(setDiscardProperties(
                '7',
                '25',
                '2',
                '2')))
    print('working2')
    */
    properties([
        [$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator',
artifactDaysToKeepStr:'1', artifactNumToKeepStr: '2', daysToKeepStr: '3', numToKeepStr: '4']]
    ])
    print(properties.values())
    print(properties.keySet())
    print('working3')
}
