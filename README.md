# Casa do código - simulação

Projeto desenvolvido para o bootcamp Itaú-ZUP. Utilizando Java, Spring e MySQL.
Criar um CRUD e um processo de pagamento inicial. 
Descrição do desafio: https://github.com/zup-academy/nosso-cartao-documentacao/tree/master/treino-casa-do-codigo

Para testar os endpoints utilizar o formatação a seguir, em json, para cada um:
_____________________________________________________________________________________________

/autor

{
	"nome" : "nome do autor",
	"email" : "email@mail.com",
	"descricao" : "breve descricao de caracteristicas/história do autor"

}
_____________________________________________________________________________________________

/categoria

{
	"nome" : "nome da categoria"
}
_____________________________________________________________________________________________

/livros

{
	"titulo" : "nome do livro"
	"resumo" : "resumo de até 500 caracteres"
	"sumario" : "sumário do livro"
	"preco" : 79.90 // passar preco como numero direto e com . para designar casas
	"numPaginas" : 1000 // valor como inteiro
	"isbn" : "sequencia isbn"
	"categoria": [{"nome" : "categoria já crianda antes"}]	
	"autor": [{"nome" : "nome do autor já cadastrado"}]
}
_____________________________________________________________________________________________

/paises

{
	"nome" : "nome do país"
}
_____________________________________________________________________________________________

/estados

{
	"nome" : "nome do estado",
	"pais" : [{ "nome" : "pais ao qual o estado pertence" }]
}
_____________________________________________________________________________________________

/pagamentos

{	
	"email":"seuemail@gmail.com", 
	“nome”: “nome teste”, 
	“sobrenome”:”sobrenome”,
	“tipo”:”PF”,
	“documento”:”50909809809”,
	“endereco":"rua fluortia”,
	“complemento”:”nao tem”,
	“cidade”:”Gru”,
	“pais”:{ïd”:1},
	“estado”:{“id”:1},
	“telefone”:”978988877”,
	“cep”:”08765-987”
}
	
