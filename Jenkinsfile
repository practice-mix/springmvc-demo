pipeline {

  agent any

  stages {

    stage('Checkout Source') {
      steps {
        git url:'https://github.com/practice-mix/springmvc-demo.git', branch:'master'
      }
    }
    
      stage("Build image") {
            steps {
                script {
                    myapp = docker.build("localhost.registry.org:4431/demo/web:${env.BUILD_ID}")
                }
            }
        }

      stage("Push image") {
            steps {
                script {
                    docker.withRegistry('https://localhost.registry.org:4431', 'docker-registry-local') {
                            myapp.push("latest")
                            myapp.push("${env.BUILD_ID}")
                    }
                }
            }
        }


    stage('Deploy App') {
      steps {
        script {
          kubernetesDeploy(configs: "k8s.yaml", kubeconfigId: "mykubeconfig")
        }
      }
    }

  }

}
