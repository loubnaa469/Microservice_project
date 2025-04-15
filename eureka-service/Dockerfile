# Utilise l'image officielle OpenJDK 25 avec Debian Bullseye comme système de base
FROM openjdk:25-jdk-bullseye

# Définit le répertoire de travail dans le conteneur à /app
# Toutes les commandes suivantes (comme la copie de fichiers ou l'exécution de programmes) se feront dans ce répertoire
WORKDIR /app

# Copie le fichier JAR généré de l'application Eureka Service (situé dans le dossier target) dans le conteneur
# Le fichier sera copié sous le nom 'app.jar' dans le répertoire /app du conteneur
COPY eureka-service/target/eureka-service-0.0.1-SNAPSHOT.jar app.jar

# Définit la commande qui sera exécutée lorsque le conteneur démarre
# Cette commande va démarrer l'application Java avec la commande 'java -jar' et le fichier 'app.jar'
ENTRYPOINT ["java", "-jar", "app.jar"]
