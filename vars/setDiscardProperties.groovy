#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties 
**/

def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {

	if (properties([
        [$class:        'BuildDiscarderProperty',
        strategy:       [$class: 'LogRotator', artifactDaysToKeepStr: "NULL", artifactNumToKeepStr: "NULL", daysToKeepStr: "NULL", numToKeepStr: "NULL"]]]))	{	 
		properties([
		[$class: 	'BuildDiscarderProperty', 
		strategy: 	[$class: 'LogRotator', artifactDaysToKeepStr: artiDaysToKeep, artifactNumToKeepStr: artiNumToKeep, daysToKeepStr: daysToKeep, numToKeepStr: numToKeep]]])
	}
}
