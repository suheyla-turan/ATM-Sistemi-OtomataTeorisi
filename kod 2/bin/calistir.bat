@echo off
cd /d "%~dp0"
if not exist bin mkdir bin
javac -encoding UTF-8 -d bin otomata_teorisi.java
if errorlevel 1 (
    echo Derleme hatasi.
    pause
    exit /b 1
)
start "" javaw -Dfile.encoding=UTF-8 -Djava.awt.headless=false -cp bin otomata_teorisi
