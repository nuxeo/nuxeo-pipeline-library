/**
 * grep for errors in server logs throwing an abort exception
 * as an alternative to https://wiki.jenkins.io/display/JENKINS/Text-finder+Plugin which
 * does not provided a dedicated step for yet.
 *
 * filepath -> path to the file being searched
 * pattern -> regexp pattern which defaults to log4j error pattern
 */
def call(String filepath, String pattern = '^[0-9]{4}-[0-9]{2}-[0-9]{2}.*ERROR.*') {
  sh """#!/bin/bash -ex
        ! grep -E '$pattern' $filepath
  """
}
