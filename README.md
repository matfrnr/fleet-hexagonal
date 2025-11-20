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
├── application/              # Couche Application
│   ├── configuration/        # Configuration Spring
│   └── jobs/                 # Tâches ETL
├── domain/                   # Couche Métier (Cœur hexagonal)
│   └── models/
│       ├── entities/         # Entités du domaine
│       ├── enums/            # Énumérations métier
│       ├── repositories/     # Ports de sortie (interfaces)
│       └── ports/
│           ├── in/           # Ports d'entrée (Use Cases)
│           └── out/          # Ports de sortie (Repositories)
│   └── services/             # Services métier & Use Cases
├── infrastructure/           # Couche Infrastructure
│   ├── controllers/          # Adapters REST (Points d'entrée)
│   ├── repositories/         # Implémentations des repositories
│   ├── dtos/                 # Data Transfer Objects
│   ├── mappers/              # Mappers DTO <-> Entités
│   └── utils/                # Utilitaires techniques
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
