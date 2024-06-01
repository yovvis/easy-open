# 使用Dockerfile构建一个Docker镜像，
FROM openjdk:8-jdk-alpine

# 设置工作目录
WORKDIR /app

# 复制jar文件到容器中
ADD target/easy-open-app-service-1.0.0.jar .

# 设置环境变量
EXPOSE 8104

# 运行jar文件
ENTRYPOINT ["java", "-jar" ,"/app/easy-open-app-service-1.0.0.jar","--spring.profiles.active=prod"]