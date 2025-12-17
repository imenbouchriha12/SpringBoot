pipeline {
    agent any
    
    environment {
        DOCKER_IMAGE = "ghcr.io/imenbouchriha12/tpcafe-app:latest"
        MINIKUBE_IP = "192.168.49.2"
    }
    
    tools {
        maven 'M2_HOME'
        jdk 'JAVA_HOME'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/imenbouchriha12/SpringBoot.git'
            }
        }
        
        stage('Build Maven') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Deploy to Kubernetes') {
            steps {
                sh """
                    # Appliquer les déploiements
                    kubectl apply -f mysql-deployment.yaml
                    kubectl apply -f spring-deployment.yaml
                    
                    # Forcer le déploiement à prendre la nouvelle image
                    kubectl set image deployment/tpcafe-app tpcafe-app=${DOCKER_IMAGE} -n devops
                    
                    # Redémarrer le déploiement
                    kubectl rollout restart deployment/tpcafe-app -n devops
                    kubectl rollout status deployment/tpcafe-app -n devops --timeout=5m
                """
            }
        }
        
        stage('Verify Deployment') {
            steps {
                sh """
                    echo "=== PODS ==="
                    kubectl get pods -n devops
                    echo ""
                    echo "=== SERVICES ==="
                    kubectl get svc -n devops
                    echo ""
                    echo "=== APPLICATION URL ==="
                    echo "http://${MINIKUBE_IP}:30082/actuator/health"
                """
            }
        }
    }
    
    post {
        success {
            echo '✅ Déploiement réussi sur Kubernetes!'
        }
        failure {
            echo '❌ Déploiement échoué!'
        }
    }
}
