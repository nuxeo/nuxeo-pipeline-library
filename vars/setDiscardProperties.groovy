/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
**/

import jenkins.model.*;
import hudson.model.*;
import hudson.maven.*;
import hudson.tasks.*;

def build = Thread.currentThread().toString()
def regexp= ".+?/job/([^/]+)/.*"
def match = build  =~ regexp
def jobName = match[0][1]
println(jobName)

def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {

	def build = Thread.currentThread().toString()
	def regexp= ".+?/job/([^/]+)/.*"
	def match = build  =~ regexp
	def jobName = match[0][1]
	println(jobName)

	properties([[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', artifactDaysToKeepStr: artiDaysToKeep, artifactNumToKeepStr: artiNumToKeep, daysToKeepStr: daysToKeep, numToKeepStr: numToKeep]]])
}
