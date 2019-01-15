def call(credentialsId, gitCommand) {
    def randomUUID = UUID.randomUUID().toString()
    def tmpAskPassScript = pwd(tmp:true) + "/${randomUUID}"
    def askPassScript = libraryResource 'gitaskpass/scripts/git_askpass.sh'
    writeFile(file: tmpAskPassScript, text: askPassScript)
    withCredentials([usernamePassword(credentialsId: credentialsId, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {            
        sh """
        chmod +x \"${tmpAskPassScript}\"
        GIT_ASKPASS=${tmpAskPassScript} ${gitCommand}
        """
    }
}
