Swagger UI for reference: https://olegshulyakov.github.io/psn-swagger/#/Games/GetGame

Docker image for Postgres:
docker pull postgres
docker run --name games -p 5432:5432 -e POSTGRES_PASSWORD=pass -d postgres
psql -U postgres -d postgres (inside of a container)
