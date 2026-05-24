@echo off
chcp 65001 >nul
cd /d "%~dp0"
if not exist bin mkdir bin
javac -encoding UTF-8 -d bin otomata_teorisi.java
if errorlevel 1 pause & exit /b 1
java -Dfile.encoding=UTF-8 -cp bin otomata_teorisi --konsol
pause
