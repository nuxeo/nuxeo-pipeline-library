#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties 
**/

def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {

    test = currentJob.getName();
    println(test);
}
