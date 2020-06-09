# POC Carros
POC para validar a implementação de um microserviço com persistência de dados em memória com H2 e comunicação via Apache Kafka.
### URL's de acesso
  - http://localhost:8081/cars/v1
  - http://localhost:8081/cars/sale/v1
  - http://localhost:8081/cars/swagger-ui.html#
  
### Instalação
```sh
$ git clone https://github.com/ricardoluiz/poc-kafka-car.git
$ mvn clean install
$ mvn spring-boot:run
```