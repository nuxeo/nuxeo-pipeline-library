/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
**/

def withDiscardProperties (
	properties([[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', artifactDaysToKeepStr: '', artifactNumToKeepStr: '1', daysToKeepStr: '60', numToKeepStr: '60']]])
)
