# Sports Tournament Management System

## Overview

The Sports Tournament Management System is a console-based application developed using Core Java, MySQL, and JDBC. It allows users to manage teams, players, and matches for a sports tournament. The application supports operations such as adding, viewing, updating, and deleting records.

## Features

- **Team Management**:
  - Add a new team
  - View team details
  - Update team information
  - Delete a team

- **Player Management**:
  - Add a new player
  - View player details
  - Update player information
  - Delete a player

- **Match Management**:
  - Schedule a new match
  - View match details
  - Update match information
  - Record match results

## Database Schema

The application uses the following database schema:

- **Team Table**:
  - `team_id` (Primary Key)
  - `name`
  - `coach`
  - `captain`
  - `total_players`

- **Player Table**:
  - `player_id` (Primary Key)
  - `name`
  - `age`
  - `team_id` (Foreign Key references Team Table)
  - `position`

- **Match Table**:
  - `match_id` (Primary Key)
  - `team1_id` (Foreign Key references Team Table)
  - `team2_id` (Foreign Key references Team Table)
  - `match_date`
  - `venue`
  - `result`

## Prerequisites

Before you begin, ensure you have the following installed:

- [Java JDK 8 or higher](https://www.oracle.com/java/technologies/javase-downloads.html)
- [MySQL Server](https://dev.mysql.com/downloads/mysql/)
- [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

## Setup

1. **Clone the repository**:
   ```bash
   git clone https://github.com/MOHANA-SABARI/sports-tournament-management.git
   cd sports-tournament-management
   
2. **Create a Database and Tables in MySql**:
  use my : `sportsmanagement.sql` file

4. **Include yor MySql Jarfile in yoru Project**:
    ```bash
   javac -cp .:mysql-connector-java-9.0.0.jar *.java
   java -cp .:mysql-connector-java-9.0.0.jar SportsManage
    
5. **Configure the Database Connection**
   
6. **Usage**
- Follow the menu prompts to manage teams, players, and matches.
- The application will automatically update the total_players in the Team table when players are added or deleted.
- Match results can be recorded and updated in the Match table.
