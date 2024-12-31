pipeline {
    agent any

    environment {
        MAVEN_HOME = "/path/to/maven" // Remplacez avec le chemin Maven si nécessaire
    }

    stages {
        stage('Checkout') {
            steps {
                echo 'Clonage du dépôt...'
                checkout scm
            }
        }

        stage('Build') {
            steps {
                echo 'Construction du projet...'
                sh 'mvn clean package'
            }
        }

        stage('Test') {
            steps {
                echo 'Exécution des tests...'
                sh 'mvn test'
            }
        }

        stage('Archive Artifacts') {
            steps {
                echo 'Archivage des artefacts...'
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }

        stage('Deploy') {
            steps {
                echo 'Déploiement...'
                // Ajoutez ici les commandes de déploiement, comme scp, ansible, etc.
            }
        }
    }

    post {
        success {
            echo 'Pipeline exécuté avec succès !'
        }
        failure {
            echo 'Le pipeline a échoué.'
        }
    }
}
