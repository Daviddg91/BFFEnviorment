
CREATE DATABASE keycloakdb;

 
CREATE USER addmin WITH PASSWORD 'addmin';
CREATE USER kcuser WITH PASSWORD 'kcuser';

 

GRANT ALL PRIVILEGES ON DATABASE keycloakdb TO kcuser;
GRANT ALL PRIVILEGES ON DATABASE appdb TO addmin;


\connect appdb