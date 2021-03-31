Back-end do App Doações, responsável pelos dados dos usuarios e dos utensílios doados.

No arquivo application.properties, estão definidos os dados da conexão com o banco PG, como usuário, senha, se o banco será criado na execução...

Nos controllers, estão os endpoints responsáveis pela gravação, remoção e busca dos dados, cada um em seu respectivo controller.

Não foram feitas validações nos campos, pois serão feitas no App.

Melhorias:

-> Pessoa
- inserir mais dados, como e-mail, login, senha...

-> Utensilio
- remover o campo disponível, quando o item for doado, será removido da lista
- inserir mais informações dos itens: foto, tamanho, peso, local onde se enconra...
