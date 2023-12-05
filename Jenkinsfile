pipeline {
    agent any
    stages {
        stage('1 - Get Code') {
         steps {
            git 'https://github.com/haterest/maven-cucumber-bdd'
            }
        }
        stage('2 - Compiler') {
         steps {
            bat label: 'Compiler source code', script: 'mvn clean'
            }
        }
        stage('3 - Run Test') {
         steps {
            bat label: 'Run E2E test', script: 'mvn test -DBROWSER=chrome verify'
            }
        }
        stage('4 - Public Report') {
         steps {
            cucumber buildStatus: 'UNCHANGED', customCssFiles: '', customJsFiles: '', failedFeaturesNumber: -1, failedScenariosNumber: -1, failedStepsNumber: -1, fileIncludePattern: '**/*.json', pendingStepsNumber: -1, skippedStepsNumber: -1, sortingMethod: 'ALPHABETICAL', undefinedStepsNumber: -1
            }
        }
    }
}
