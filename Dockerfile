FROM openjdk:8-jdk
EXPOSE 8080:8080
EXPOSE 5032:5032
RUN mkdir /app
COPY ./build/install/mm/ /app/
WORKDIR /app/bin
CMD ["./mm"]