# News Publishing System

## Overview

The News Publishing System is a console-based Java application designed to simulate a news publishing system for a communications and media company. This application allows users to manage news categories, articles, and comments. It uses Core Java for the application logic and JDBC for interacting with a MySQL database.

## Features

### News Category Management
- **Add a new news category**
- **View news category details**
- **Update news category information**
- **Delete a news category**

### Article Management
- **Add a new article to a category**
- **View article details**
- **Update article information**
- **Delete an article**

### Comment Management
- **Add a comment to an article**
- **View comments for an article**
- **Update a comment**
- **Delete a comment**

## Database Schema

### Category Table
- `category_id` (Primary Key)
- `name`
- `description`

### Article Table
- `article_id` (Primary Key)
- `category_id` (Foreign Key references Category Table)
- `title`
- `content`
- `author`
- `publish_date`

### Comment Table
- `comment_id` (Primary Key)
- `article_id` (Foreign Key references Article Table)
- `user_id` (Foreign Key references User Table)
- `content`
- `comment_date`

### User Table
- `user_id` (Primary Key)
- `username`
- `email`
- `date_of_birth`
- `registration_date`

## Requirements

- **Core Java**: For developing the console-based application.
- **JDBC**: For database interaction with MySQL.
- **MySQL Database**: Set up the provided schema in your MySQL database.
- **Java Development Kit (JDK)**: Ensure JDK 8 or later is installed.
- **MySQL Connector/J**: JDBC driver for MySQL.

## Setup Instructions

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/repositoryname.git
