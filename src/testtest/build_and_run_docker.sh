#!/bin/bash

# 사용자 코드가 포함된 디렉토리
USER_CODE_DIR="/path/to/user/code"

# 유니크한 컨테이너/이미지 이름 생성 (예: timestamp 사용)
IMAGE_NAME="user_code_$(date +%s)"

# Dockerfile이 위치한 디렉토리로 이동
cd "$USER_CODE_DIR"

# Docker 이미지 빌드
docker build -t "$IMAGE_NAME" .

# 생성된 이미지를 기반으로 컨테이너 실행
docker run --rm --name "$IMAGE_NAME" "$IMAGE_NAME"

# 컨테이너 실행이 완료된 후, 생성된 이미지 삭제
docker rmi "$IMAGE_NAME"
