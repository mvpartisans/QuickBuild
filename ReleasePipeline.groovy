import groovy.json.JsonSlurper


def buildLib = fileLoader.fromGit('BuildLibRelease.groovy',
        'https://github.com/mvpartisans/QuickBuildLibs.git', 'master', null, '')


node {

/*    buildLib.coreBuild {[
            "lfs-a": "master",
            "lfs-b": "master"
    ]}*/

    buildLib.deploy(['host1']);

}