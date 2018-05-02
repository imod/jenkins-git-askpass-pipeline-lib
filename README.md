# gitAskPass - GIT_ASKPASS

small jenkins pipeline example extension to ease the usage of GIT_ASKPASS

how to use in pipeline script (e.g. Jenkinsfile):

  `gitAskPass('MY_GIT_CREDENTIALS_ID', 'git push origin master')`


  ```groovy
    @Library('my-shared-library')

    pipeline {
        agent any
        stages {
            stage ('build') {
            steps {
                script {
                    gitAskPass('YOOBOT_BITBUCKET', 'git clone git@bitbucket.org:yooture/git-pull-issue.git')
                }
            }
            }
        }
        post { 
            always { 
                cleanWs()
            }
        }   
    }
  ```