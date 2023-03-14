# Project Title: Catalog-Food-Manager

# Description:
- This is a project to learn a little bit of building an api with Kotlin and Ktor using Postgres to persist data

# Prerequisites to run locally:
- First Install Docker and run the following commands:

    - docker run --name postgres14.5 -p 5432:5432 -e POSTGRES_USER=root -e POSTGRES_PASSWORD=secret -d postgres:14.5-alpine
  
    - docker exec -it postgres14.5 createdb --username=root --owner=root catalog_food_manager
  
    - docker exec -it postgres14.5 psql -c 'CREATE EXTENSION IF NOT EXISTS "uuid-ossp";' -d catalog_food_manager
  
    - docker exec -it postgres14.5 psql -c 'CREATE TABLE food(food_id uuid DEFAULT uuid_generate_v4(), name VARCHAR(30), quantity INT, price NUMERIC(4,2), description VARCHAR(100), created_at TIMESTAMPTZ, modified_at TIMESTAMPTZ)' -d catalog_food_manager