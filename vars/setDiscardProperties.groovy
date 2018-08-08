#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties
**/


def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {


    discardList = ""
    print('working 1')
    discardList.append(BuildDiscarderProperty(strategy(Logrotator(
            '',
            '1',
            '60',
            '60'))));
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
