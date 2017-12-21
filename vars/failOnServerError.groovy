/**
 * grep for errors in server logs throwing an abort exception
 */
def call(String path, String pattern = '^[0-9]{4}-[0-9]{2}-[0-9]{2}.*ERROR.*') {
  sh """#!/bin/bash -ex
        ! grep -E '$pattern' $path
  """
}
