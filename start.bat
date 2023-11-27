REM COMMAND INIT → ./start.bat
@echo off

REM Inicia el contenedor Docker automaticamente
docker-compose up -d

REM 30 segundos para redirigir a la ruta start ↓
timeout /t 30

REM Abre el navegador web en la siguiente ruta
start http://localhost:8080/greet/WilverAR
