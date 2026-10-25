@echo off
echo 1. Creating output directory...
if not exist out mkdir out

echo 2. Compiling Java source files...
dir /s /b *.java > sources.txt
javac -encoding UTF-8 -d out @sources.txt
del sources.txt

echo 3. Creating manifest file...
echo Main-Class: ru.university.lab2.Main > manifest.txt

echo 4. Packing into executable JAR...
jar cvfm Lab2.jar manifest.txt -C out .

echo 5. Cleaning temporary manifest...
del manifest.txt

echo === Build successful! Run with: java -jar Lab2.jar ===
pause