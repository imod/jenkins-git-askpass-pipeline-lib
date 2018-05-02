# gitAskPass - GIT_ASKPASS

small jenkins pipeline example extension to ease the usage of GIT_ASKPASS on a remote repositories via HTTP/HTTPS

### how to use

  `gitAskPass('<GIT_CREDENTIALS_ID_TO_USE>', '<the full git command needing authentication>')`


  ```groovy
    @Library('my-shared-library')

    pipeline {
        agent any
        stages {
            stage ('build') {
            steps {
                script {
                    gitAskPass('MY_GIT_CREDENTIALS', 'git clone https://github.com/imod/jenkins-git-askpass-pipeline-lib.git')
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