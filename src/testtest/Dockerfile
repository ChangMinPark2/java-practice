FROM openjdk:11-jdk-slim as build
WORKDIR /app
COPY . src/testtest
RUN sh -c 'javac src/testtest/*.java'
CMD ["java", "-cp", "src", "testtest.test"]


#FROM openjdk:11-jdk-slim
## 오픈 jdk11버전 -> 자바 파일을 실행시키는 도구이다.
#
## /app 디렉토리를 작업 디렉토리로 설정
#WORKDIR /app
#
## 현재 Docker 빌드 컨텍스트의 모든 파일과 폴더를 /app으로 복사
## 이 경우, java-practice 폴더 내의 .app/src/testtest 디렉터리로 복사한다. -> 모든 소스코드와 자원을 이미지 내부로 가져온다.
#COPY . src/testtest
#
## src/testtest/test.java 파일을 컴파일
## run -> 도커 이미지를 빌드하는 동안 명령어를 실행. 여기서는 java 소스 파일을 컴파일 한다.
## run 명령어는 새로운 레이어를 생성하고, 그 결과를 커밋하여 이미지에 반영한다. 이 과정을 통해 java 애플리케이션을 실행하기 위한 준비단계를 수행.
#RUN javac src/testtest/test.java
#
## Java 애플리케이션 실행
## 클래스 패스를 src로 설정하고, testtest 패키지 내의 test 클래스를 실행
#CMD ["java", "-cp", "src", "testtest.test"]