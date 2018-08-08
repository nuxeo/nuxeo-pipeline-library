#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties
**/


def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {


    def discardList = new String[4]
    print('working 1')
    discardList.add(setDiscardProperties(
            '',
            '1',
            '60',
            '60'));

    discarderList = buildDiscarderProperty(discardList)
    print('working 2')



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
        discardList
    ])
    print('working3')
}
