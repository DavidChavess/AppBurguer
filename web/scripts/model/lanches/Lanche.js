class Lanche{
    constructor(id, nome, valor){
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = [];
    }
    
    itensParaArray(){
        return this.ingredientes;
    }

    adicionaItem(item){
        this.ingredientes.push(item);
    }
    
    adicionaTodosItens(itens){
        itens.forEach(item => {
            this.adicionaItem(item);
        });
    }
}