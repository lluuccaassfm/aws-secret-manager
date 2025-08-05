
# aws-secret-manager

## Projeto: Integração com AWS Secrets Manager

Este projeto demonstra a integração de uma aplicação Java Spring Boot com o AWS Secrets Manager para recuperar informações confidenciais. Ele utiliza Spring Cloud AWS para facilitar a integração com os serviços da AWS e LocalStack para simular o ambiente da AWS localmente durante o desenvolvimento.

## Tecnologias Utilizadas

*   **Java 21:** Linguagem de programação principal.
*   **Spring Boot:** Framework para facilitar a criação de aplicações Java.
*   **Spring Cloud AWS:** Módulo Spring Cloud para integração com serviços da AWS.
*   **LocalStack:** Ferramenta para simular serviços da AWS em ambiente local.
*   **AWS Secrets Manager:** Serviço da AWS para armazenar e gerenciar segredos.


## Considerações

*   **Versões das dependências:** Ajuste as versões das dependências (`spring-cloud-starter-aws` e `spring-cloud-aws-secrets-manager`) para as versões mais recentes compatíveis com o seu projeto Spring Boot.
*   **Nomes dos Secrets:**  Certifique-se de que o nome do secret configurado no `application.properties` (`database-teste`) corresponde ao nome do secret criado no AWS Secrets Manager (ou LocalStack).
*   **Credenciais:** As credenciais configuradas no `application.properties` (access-key e secret-key) são apenas para testes locais com o LocalStack.  Em um ambiente real, utilize roles do IAM para conceder permissões à sua aplicação.
*   **Região:** A região configurada deve corresponder à região utilizada no LocalStack ou na AWS.

### Srecret AWS
A secret criada na AWS Secret Manager foi "database-teste" com o valor em formato json: 
```
{
    "username": "User Test",
    "surname": "UT",
    "password": "xxx-123"
}
```

Para recuperar a secret e seus respectivos valores foi adicionado a configuração no 'application.yaml':
`spring.config.import: aws-secretsmanager:database-teste?prefix=db.`

**"database-teste"** -> Nome da secret definina na AWS  
**"?prefix=db."** -> Adiciona um prefixo às chaves de propriedades


Para recuperar os valores dessa secret, basta seguir o exemplo da classe AwsSecretManagerApplication.java, utilizando a notação @Value e o prefixo 
definido nas configs + o nome da propriedade: 
````
@Value("${db.username}")
private String username;

@Value("${db.surname}")
private String surname;

@Value("${db.password}")
private String password;

````

## Próximos Passos

*   Implementar tratamento de erros e exceções ao acessar o Secrets Manager.
*   Configurar o uso de roles do IAM para ambientes de produção.
*   Criar testes unitários e de integração para validar a funcionalidade.
