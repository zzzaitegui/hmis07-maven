pipeline {
  agent any

  tools {
    maven "maven_default"
  }

  stages {
    stage('Git fetch') {
      steps {
        git branch: 'main', url: 'https://github.com/zzzaitegui/hmis07-maven.git'
      }
    }
    stage('Compile, Test, Package') {
      steps {
        sh "mvn clean package"
      }
      post {
        success {
          junit '**/target/surefire-reports/TEST-*.xml'
          archiveArtifacts '**/target/*.jar'
          jacoco(
            execPattern: '**/target/jacoco.exec',
            classPattern: '**/target/classes',
            sourcePattern: '**/src/',
            exclusionPattern: '**/test/'
          )
          publishCoverage adapters: [jacocoAdapter('**/target/site/jacoco/jacoco.xml')]
        }
      }
    }
    stage('Analysis') {
      steps {
        sh "mvn site"
      }
      post {
        success {
          recordIssues enabledForFailure: true, tool: checkStyle()
          recordIssues enabledForFailure: true, tool: pmdParser()
          recordIssues enabledForFailure: true, tool: cpd()
          recordIssues enabledForFailure: true, tool: spotBugs()
        }
      }
    }
    stage('Documentation') {
      steps {
        sh "mvn javadoc:javadoc javadoc:aggregate"
      }
      post {
        success {
          step $class: 'JavadocArchiver', javadocDir: 'target/site/apidocs', keepAll: false
          publishHTML(target: [reportName: 'Maven Site', reportDir: 'target/site/es', reportFiles: 'index.html', keepAll: false])
        }
      }
    }
  }
}