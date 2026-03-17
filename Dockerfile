# === Build Stage ===
FROM gradle:8.5-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean bootJar -x test

# === Run Stage ===
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# 修正箇所：ワイルドカードを極限までシンプルにする、
# または、bootJarで生成される標準的な名前を直接狙います。
# 確実に1つだけ生成されているはずなので、これで通ります。
COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-Xmx512m", "-jar", "app.jar"]
