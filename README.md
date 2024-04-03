# imyeomsu
고가용성을 확보한 LCK 이벤트 프로젝트입니다.


파이프라인 테스트 스크립트
```
pipeline {
    agent any
    
    stages {
        stage('Checkout') {
            steps {
                // GitHub에서 소스 코드를 체크아웃합니다.
                git branch: 'main',
                url: 'https://github.com/your/repository.git'
            }
        }
        stage('Chmod +x') {
            steps {
                sh '''
                    chmod +x gradlew
                '''
            }
        }
        stage('Gradle Build') {
            steps {
                echo 'build start with gradle'
                sh './gradlew clean build'
            }
        }
        stage('Code Coverage') {
            steps {
                // Run JaCoCo report generation
                jacoco(execPattern: '**/build/jacoco/*.exec')

                // Archive generated JaCoCo reports
                archiveArtifacts artifacts: 'build/reports/jacoco/test/html/*', fingerprint: true
            }
        }
    }
    
    post {
        always {
            // Publish JaCoCo report as a post-build action
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'build/reports/jacoco/test/html',
                reportFiles: 'index.html',
                reportName: 'JaCoCo Code Coverage Report'
            ])

            // Publish your second report
            publishHTML(target: [
                allowMissing: false,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'build/reports/tests/test',
                reportFiles: 'index.html',
                reportName: 'Your Second Report Name'
            ])
        }
    }
}

```
