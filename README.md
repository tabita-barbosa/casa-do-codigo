# Casa do código - simulação

Projeto desenvolvido para o bootcamp Itaú-ZUP. Utilizando Java, Spring e MySQL.


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

/livro

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

/pais

{
	"nome" : "nome do país"
}
_____________________________________________________________________________________________

/estado

{
	"nome" : "nome do estado",
	"pais" : [
		{ "nome" : "pais ao qual o estado pertence" }
	]
}
_____________________________________________________________________________________________

/pagamento

{

}