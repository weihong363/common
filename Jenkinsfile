pipeline {
  agent any
  stages {
    stage('build') {
      steps {
        git(url: 'git@github.com:weihong363/common.git', branch: 'master', changelog: true, credentialsId: '33b76101-3e0b-4b19-bb25-035b5161c6f6')
      }
    }

  }
  environment {
    build = 'mvn clean install'
  }
}