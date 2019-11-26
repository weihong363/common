pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        git(url: 'git@github.com:weihong363/common.git', branch: 'master', changelog: true, credentialsId: 'd598bcad58ee89e82038f7fe3c6608853627f69c')
        sh 'cd /common'
        sh 'mvn clean package'
      }
    }

    stage('run') {
      steps {
        sh 'cd target'
        sh 'java -jar common-1.0-SNAPSHOT.jar'
      }
    }

  }
}