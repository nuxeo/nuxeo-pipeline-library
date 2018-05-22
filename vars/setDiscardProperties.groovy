#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
**/

def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {
	
	properties([
	[$class: 	'BuildDiscarderProperty', 
	strategy: 	[$class: 'LogRotator', artifactDaysToKeepStr: artiDaysToKeep, artifactNumToKeepStr: artiNumToKeep, daysToKeepStr: daysToKeep, numToKeepStr: numToKeep]]])
}
