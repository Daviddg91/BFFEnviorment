pipeline {
	
	pipeline {

    agent {
        label AGENT_LABEL
    }

    tools {
        jdk JDK_NAME
    }

    environment {
        MAVEN_SKIP_RC = true
    }

    options {
        buildDiscarder(
            logRotator(artifactNumToKeepStr: '5', numToKeepStr: '10')
        )
        disableConcurrentBuilds()
    }

    parameters {
        booleanParam(name: 'CLEAN', defaultValue: true, description: 'Perform the build in clean workspace')
    }

    stages {

        stage('Clean workspace') {
             when {
                 expression { params.CLEAN }
             }
             steps {
                 sh 'git clean -fdx'
           }
        }

        stage('Build & Install') {
            steps {
                sh "./mvnw -U $MAVEN_PARAMS -Dskip.camel.maven.plugin.tests -Darchetype.test.skip -Dmaven.test.skip.exec=true clean install"
            }
        }

        stage('Code Quality Review') {
            steps {
                withCredentials([string(credentialsId: 'apache-camel-core', variable: 'SONAR_TOKEN')]) {
                    sh "./mvnw $MAVEN_PARAMS -Dsonar.host.url=https://sonarcloud.io -Dsonar.java.experimental.batchModeSizeInKB=2048 -Dsonar.organization=apache -Dsonar.projectKey=apache_camel -Dsonar.branch.name=$BRANCH_NAME org.sonarsource.scanner.maven:sonar-maven-plugin:sonar"
                }
            }
        }

        stage('Test') {
            steps {
                timeout(unit: 'HOURS', time: 7) {
                    sh "./mvnw $MAVEN_PARAMS $MAVEN_TEST_PARAMS -Darchetype.test.skip -Dmaven.test.failure.ignore=true -Dcheckstyle.skip=true verify"
                }
            }
            post {
                always {
                    junit allowEmptyResults: true, testResults: '**/target/surefire-reports/*.xml'
                    junit allowEmptyResults: true, testResults: '**/target/failsafe-reports/*.xml'
                }
            }
        }

    }

    post {
        always {
            emailext(
                subject: '${DEFAULT_SUBJECT}',
                body: '${DEFAULT_CONTENT}',
                recipientProviders: [[$class: 'CulpritsRecipientProvider']]
            )
        }
    }
}

  agent any

  tools {
    jdk 'jdk17'
    maven 'maven-3.6.3'
  }
  
   environment {
      // General Variables for Pipeline
      PROJECT_ROOT = './'
      EMAIL_ADDRESS = 'ryskzero@gmail.com'
      REGISTRY = 'david28/docker-bffenvironment'
  }

  stages {
    stage('Build') {
      steps {
        withMaven(maven : 'mvn-3.6.3') {
          sh "mvn package"
        }
      }
    }

    stage ('OWASP Dependency-Check Vulnerabilities') {
      steps {
        withMaven(maven : 'mvn-3.6.3') {
          sh 'mvn dependency-check:check'
        }

        dependencyCheckPublisher pattern: 'target/dependency-check-report.xml'
      }
    }

    stage('SonarQube analysis') {
      steps {
        withSonarQubeEnv(credentialsId: 'sonarqube-secret', installationName: 'sonarqube-server') {
          withMaven(maven : 'mvn-3.6.3') {
            sh 'mvn sonar:sonar -Dsonar.dependencyCheck.jsonReportPath=target/dependency-check-report.json -Dsonar.dependencyCheck.xmlReportPath=target/dependency-check-report.xml -Dsonar.dependencyCheck.htmlReportPath=target/dependency-check-report.html'
          }
        }
      }
    }

    stage('Create and push container') {
      steps {
        withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
          withMaven(maven : 'mvn-3.6.3') {
            sh "mvn jib:build"
          }
        }
      } 
    }

    stage('Anchore analyse') {
      steps {
        writeFile file: 'anchore_images', text: 'docker.io/maartensmeets/spring-boot-demo'
        anchore name: 'anchore_images'
      }
    }

    stage('Deploy to K8s') {
      steps {
        withKubeConfig([credentialsId: 'kubernetes-config']) {
          sh 'curl -LO "https://storage.googleapis.com/kubernetes-release/release/$(curl -s https://storage.googleapis.com/kubernetes-release/release/stable.txt)/bin/linux/amd64/kubectl"'
          sh 'chmod u+x ./kubectl'
          sh './kubectl apply -f k8s.yaml'
        }
      } 
    }
  }
}
