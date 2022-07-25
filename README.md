# Gerador de Figurinhas através de APIs com imagens 
### _Realizado em - Alura Imersão Java_
A aplicação funciona em três passos distintos:

- `1`: Acessa algum API que possui imagens, neste caso tem-se os APIs da IMDB (Internet Movie Database), NASA (National Aeronautics and Space Administration) e um customizado com imagens de logos de linguagens de programação.
- `2`: Realiza o parseamento e processamento do JSON para obter a URL e o título de cada imagem (novos métodos podem ser criados para dar suporte a APIs diferentes).
- `3`: Gera uma nova imagem com texto customizável abaixo da original.

### Estrutura do repositório

&rarr; 📁 **alura-stickers** &rarr; Aplicação geradora de figurinhas
&rarr; 📁 **linguagens-api** &rarr; API com imagens de logos de linguagens de programação.

- API acessível em: https://alura-linguagens-api-jp.herokuapp.com/linguagens
- [MongoDB](https://www.mongodb.com/) utilizado para hostear o banco de dados.
- [Heroku](https://www.heroku.com/) utilizado para hostear o API.