gradle build
gradle wrapper --gradle-version 2.13
gradlew.bat build
"C:\Program Files\Java\jdk1.8.0_111\bin\java.exe" -jar build/libs/first-gradle-0.0.1.jar
gradlew.bat run

gradlew.bat clean shadowJar 

"C:\Program Files\Java\jdk1.8.0_111\bin\java.exe" -jar build/libs/first-gradle-0.0.1-SNAPSHOT-all.jar