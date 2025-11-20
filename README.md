# Fleet - Star Wars Fleet Management API

Une API de gestion de flotte spatiale Star Wars construite avec **Spring Boot 3.5.7** et une architecture **hexagonale**.

## 📋 Description

Fleet est une API REST permettant de gérer une flotte de vaisseaux spatiaux et leur équipage dans l'univers Star Wars. Le projet suit les principes de l'architecture hexagonale pour une meilleure maintenabilité et testabilité.

## 🛠️ Technologies

- **Java 25**
- **Spring Boot 3.5.7**
- **Spring Data JPA**
- **PostgreSQL**
- **Maven**
- **Lombok**

## 🏗️ Architecture Hexagonale

Le projet est organisé selon les principes de l'architecture hexagonale :

```
src/main/java/org/ort/starwars/fleet/
├── api/
│   └── controllers/          # Points d'entrée REST
├── configuration/            # Configuration de l'application
├── utils/                    # Utilitaires et helpers
└── FleetApplication.java     # Classe principale
```

## 📊 Entités Principales

### Starship (Vaisseau)

- Représente un vaisseau spatial avec ses caractéristiques
- Types : Fighters, Transports, Capital Ships, etc.

### Staff (Personnel)

- Représente un membre de l'équipage
- Races : Humain, Wookiee, Ewok, etc.

## 🚀 Démarrage Rapide

```bash
# Cloner et lancer
git clone https://github.com/matfrnr/fleet-hexagonal.git
cd fleet

# Créer la BD PostgreSQL
createdb fleet

# Lancer l'application
./mvnw spring-boot:run
```

Application disponible sur `http://localhost:8080`
