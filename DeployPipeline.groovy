/**
 * Created by iansari on 5/25/16.
 */


node {
    def hosts = ["google", "yahoo", "microsoft"]
    def hostsToPush = [:]
    int ct = 0
    def retryList = new ArrayList();

    def shellCommands = {
        sh '''
            echo retrying again $CT
            #test
        '''
    }

    stage 'Test'
    withEnv(["ER1=0"]) {
        try {
            shellCommands.call();

        } catch (Exception e) {

            input message: "Retry First Host ${hosts[0]}?"
            shellCommands.call();

        }

        for (int i = 0; i < hosts.size(); i++) {
            def hostName = hosts[i]

            hostsToPush["host_" + hostName] = {
                try {
                    shellCommands.call();
                } catch (Exception e) {
                    retryList << hostName
                }
            }
        }

        parallel hostsToPush

        println "retrying hosts" + retryList
        for (int i = 0; i < retryList.size(); i++) {

        }
    }

    stage 'Deployed'
    println 'Deployed'

}