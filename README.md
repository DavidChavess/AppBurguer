# Teste-Java-Finch-Solucoes
Criar uma aplicação web para satisfazer as necessidades de uma startup do ramo de alimentos

# Instruções de execução

Antes de seguir o passo a passo, você irá precisar ter o Java instalado no seu computador

1 - Dentro do repositório, faça o download do zip do projeto. 

2 - Vá até o local onde você baixou o projeto e descompacte o zip

3 - Dentro da pasta Teste-Java-Finch-Solucoes-master entre em backend e copie o caminho da url

4 - Agora abri um terminal cmd e digite o comando: cd + caminhoDaUrl, deve ficar mais ou menos assim:
    cd C:\Users\david\Desktop\Projeto\Teste-Java-Finch-Solucoes-master\backend

5 - Agora digite o seguinte comando: mvn pakage 

6 - Repare que foi criado uma pasta com o nome target dentro de backend. No cmd digite cd espaço target para entrarmos na nova pasta
    cd target

7 - Dentro da pasta target tem um arquivo.jar, vamos precisar dele, portanto copie ele e dentro do cmd digite: Java -jar + nomeDoArquivo.jar, vai ficar mais ou menos assim:

   Java -jar test-backend-finchsolucoes-0.0.1-SNAPSHOT.jar

Se você preferir, pode copiar o código acima e colar dentro de target

8 - Pronto! Isso irá levanter o servidor com nosso banco de dados e requisições prontas, foi usado o banco de dados H2, que é um banco de dados em memória, senão teriamos que também criar uma conexão com o banco de dados manualmente.

9 - Agora é só navegar até a raiz do projeto, entre na pasta web, e abri a pasta index.html; 

# Ferramentas utilizadas

Java 8, JPA com Hibernate, Spring-Boot, 
Banco de Dados H2, HTML5, CSS3, Javascript e Swagger para documentação da API


