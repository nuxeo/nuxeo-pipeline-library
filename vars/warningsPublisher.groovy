/**
 * see https://wiki.jenkins.io/display/JENKINS/Warnings+Plugin
 */
def call() {
  step([
      $class        : 'WarningsPublisher',
      consoleParsers: [
          [parserName: 'Maven'],
          [parserName: 'Java Compiler (javac)']
      ]
  ])
}
