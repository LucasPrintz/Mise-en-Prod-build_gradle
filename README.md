# Mise en production projet gradle

## Installation

''' bash
git clone https://github.com/LucasPrintz/Mise-en-Prod-build_gradle.git
cd Mise-en-Prod-build_gradle
'''

## Build en local

''' bash
cd covid-api
./gradlew build
'''

Cette commande génére le fichier covid-api-0.0.1-SNAPSHOT.jar dans le dossier build/libs, qui peut être lancé par la commande :

''' bash
java -jar covid-api-0.0.1-SNAPSHOT.jar
'''

## Build avec docker

Depuis le dossier Mise-en-Prod-build_gradle, lancer la commande :

''' bash
docker compose up -d
'''

## Lancer les builds depuis Jenkins

Dans Jenkins, aller dans `Dashboard > Manage Jenkins > Credentials > System > Global credentials (unrestricted) > Add Credentials` 
et ajouter les identifiants de connexion à DockerHub sous l'identifiant docker_hub_credentials.

Puis aller dans `Dashboard > New Item > Pipeline` et créer un pipeline avec le script suivant :

``` groovy 
pipeline {
    agent any
    stages {
        stage('Clone') {
            steps {
                git branch: 'main', url: "https://github.com/LucasPrintz/Mise-en-Prod-build_gradle.git"
            }
        }
        stage('Build') {
            steps {
                script {
                    dockerImage = docker.build "lucaspri/mise-en-prod-build_gradle" + ":latest"
                }
            }
        }
        stage('Push') {
            steps {
                script {
                    docker.withRegistry('https://registry.hub.docker.com', 'docker_hub_credentials') {
                        dockerImage.push()
                    }
                }
            }
        }
    }
}
```
Lancer la pipeline publie une image sur DockerHub avec le tag `latest`.

## Tester l'application

L'application est accessible à l'adresse `http://localhost:8080/`.

Afin de vérifier son bon fonctionnement, on peut tester les requêtes suivantes :

### Création d'un centre de vaccination dans la base de données

`http://localhost:8080/api/centers/admin/create/Centre%20Vaccination/Nancy/1%20Rue%20Du%20General%20Leclerc`

### Récupération de tous les centres de vaccination

`http://localhost:8080/api/centers/public/getAll`
