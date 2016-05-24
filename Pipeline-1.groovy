import groovy.json.JsonSlurper


def buildLib = fileLoader.fromGit('BuildLib.groovy',
        'https://github.com/mvpartisans/QuickBuildLibs.git', 'master', null, '')


node {

    buildLib.coreBuild {[
            "lfs-a": "master",
            "lfs-b": "master"
            //"lfs-c": "newBranch"
            //"lfs-d": "newBranch"
    ]}

}

