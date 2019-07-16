# amqp-app
Implementação de fila no rabbitmq com consumidor e produtor.

Repositório do projeto: ->https://github.com/msvieiraweb/amqp-app

### Instruções para execução do projeto
- Clonar repositório.

- Importar o projeto em uma IDE

- Configurar o application com os parametros do rabbit:

    ``` rabbitmq: ```
    ``` host:  ```
    ``` username: ``` 
    ``` password: ```
    
 - Para utilizar o delay, deverá instalar o pluguin:
    - No diretório:../resources
    ```rabbitmq_delayed_message_exchange```
    
    - Utilizando a imagem do docker
    
    ```docker cp rabbitmq_delayed_message_exchange-20171215-3.6.x.ez rabbit-server:/plugins```
    
    ```docker exec rabbit-server rabbitmq-plugins enable rabbitmq_delayed_message_exchange```
    
    ```docker exec rabbit-server rabbitmq-plugins list```
    
- Run As -> ``` WebStarter ``` com os profiles: 

    ```-Dspring.profiles.active=receiver```
    
    ```-Dspring.profiles.active=sender```

