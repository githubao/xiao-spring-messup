mvnw.cmd install dockerfile:build

docker run -p 8080:8089 -t --name sample-app xiaobao/spring-docker

docker run -p 8080:8080 -t xiaobao/spring-docker

docker-machine ls

http://192.168.99.101:8080/