
```yml
    rabbitmq:
    image: rabbitmq:3.9.11-management-alpine
    container_name: rabbitmq
    ports:
    - "5672:5672"
    - "15672:15672"
```

rabbitmq  mesajlaşma işlemleri için amqp adında bir protokol kullanmaktadır

