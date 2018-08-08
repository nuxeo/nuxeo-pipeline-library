#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties
**/

def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {

    def newParamsList = []
    def newbool = BooleanParameterDefinition(defaultValue: false, description: "deploy", name: "deploy_flag")
    newParamsList.add(newbool)
    def newParams = parameters(newParamsList)
    properties([ //job property declaration
        disableConcurrentBuilds(),
        newParams,
    ])


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
    /*
    print(properties)
    print(properties.values())
    print(properties.keySet())
    //properties.forEach(key, print())
    print(properties.get('class'))
    properties.put('class', BuildDiscarder(setDiscardProperties(
                '7',
                '25',
                '2',
                '2')))
    */
    print('working3')
}
