FROM postgres:16-bullseye
COPY init.sql /docker-entrypoint-initdb.d/
