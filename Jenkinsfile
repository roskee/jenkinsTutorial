pipeline {
    agent any
    stages {
        stage("git-checkout"){
            steps {
                echo "git checkout phase"
                git credentialsId: '6554f690-840a-4f4e-876c-d211bc08f538', url: 'https://github.com/roskee/jenkinsTutorial'
                
            }
        }
        stage("build"){
            steps{
                bat "mvn clean compile"
            }
        }
        stage("testing"){
            steps{
                echo "testing phase"
                bat "mvn package"
            }
            
        }
        stage("deploy"){
            steps{
                echo "deploying"
                deploy adapters: [tomcat9(credentialsId: '6d426c1f-4969-4535-bbbb-39da8b2c44e7', path: '', url: 'http://localhost:8083/')], contextPath: 'mvnwebapp', onFailure: false, war: '**/*.war'
            }
        }
    }
    post {
        always{
            echo "Jenkins finshed processing our project"
        }
        success{
            echo "Project is ready for production"
        }
        failure{
            echo "Project is not ready for production"
        }
    }
}
