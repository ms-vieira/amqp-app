# amqp-app
Implementação de fila no rabbitmq com consumidor e produtor.

Repositório do projeto: ->https://github.com/msvieiraweb/amqp-app

### Instruções para execução do projeto
- Clonar repositório.

- Importar o projeto em uma IDE

- Configurar o application com os parametros do rabbit:

    ``` rabbitmq: ```
    ``` host: localhost ```
    ``` username: ``` 
    ``` password: ```
 - Se for utilizar o delay, deverá instalar o pluguin:
    ```rabbitmq_delayed_message_exchange```

- Run As -> ``` WebStarter ``` com o profile ```receiver``` e ```sender```

