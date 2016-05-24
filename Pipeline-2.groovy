import groovy.json.JsonSlurper


def buildLib = fileLoader.fromGit('BuildLibNonP.groovy',
        'https://github.com/mvpartisans/QuickBuildLibs.git', 'master', null, '')


node {

    buildLib.coreBuild {[
            "lfs-a": "May-Release",
            "lfs-b": "May-Release",
            "lfs-c": "newBranch",
            "lfs-d": "newBranch"
    ]}

}

