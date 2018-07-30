#!groovy
/**
  * Set Discard old builds properties
  * To be placed before the "stage phases" of the job
  * Overrides all set current job properties 
**/

import jenkins.model.*;
import hudson.model.*;
import hudson.maven.*;
import hudson.tasks.*;
import com.cloudbees.hudson.plugins.folder.*;
import org.jenkinsci.plugins.workflow.multibranch.*;
import com.cloudbees.hudson.plugins.modeling.impl.auxiliary.*;
import com.cloudbees.hudson.plugins.modeling.impl.jobTemplate.*;
import jenkins.branch.*;
import org.jenkinsci.plugins.workflow.job.*;
import javax.mail.internet.*;
import javax.mail.*;
import javax.activation.*;
import hudson.tasks.MailSender;
import jenkins.plugins.mailer.tasks.MimeMessageBuilder;
import java.util.*;
import hudson.tools.*;
import com.github.mjdetullio.jenkins.plugins.multibranch.FreeStyleMultiBranchProject;
import com.github.mjdetullio.jenkins.plugins.multibranch.MavenMultiBranchProject;
import hudson.matrix.*;


def call(String artiDaysToKeep, String artiNumToKeep, String daysToKeep, String numToKeep ) {

    test = currentJob.getName();
    println(test);
}
