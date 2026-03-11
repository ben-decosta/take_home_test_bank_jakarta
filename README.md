# Microservice Java Spring Boot with PostgreSQL

Project sederhana Java Spring Boot dengan arsitektur microservice yang terhubung ke PostgreSQL untuk mengelola data.

## Fitur
- Tambah title dan description
- Lihat semua data

## Teknologi
- Spring Boot
- Spring Data JPA + Postgresql
- Java
- Lombok
- Redis (optional)
- JUnit

## Cara Menjalankan
1. Import `database/schema.sql` di PostgreSQL
2. Jalankan `Main.java`

# Endpoint
## Insert
- Method: POST
- URL: /api/addBook
## Get All
- Method: GET
- URL: /api/allBooks
