pipeline {
  agent any
  stages {
    stage('build') {
      parallel {
        stage('build') {
          steps {
            git(url: 'git@github.com:weihong363/common.git', branch: 'master', changelog: true, credentialsId: 'd598bcad58ee89e82038f7fe3c6608853627f69c')
          }
        }

        stage('') {
          steps {
            sh 'sh \'cd /common | mvn clean package\''
          }
        }

      }
    }

  }
  environment {
    build = 'mvn clean install'
  }
}