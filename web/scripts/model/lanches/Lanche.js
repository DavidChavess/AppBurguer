class Lanche{
    constructor(id, nome, valor){
        this._id = id;
        this._nome = nome;
        this._valor = valor;
        this._itens = [];
    }
    set id(id){
        this._id = id;
    }
    get id(){
        return this._id;
    }
    set nome(nome){
        this._nome = nome;
    }
    get nome(){
        return this._nome;
    }
    set valor(valor){
        this._valor = valor;
    }
    get valor(){
        return this._valor;
    }
    
    itensParaArray(){
        return this._itens;
    }

    adicionaItem(item){
        this._itens.push(item);
    }
    
    adicionaTodosItens(itens){
        itens.forEach(item => {
            this.adicionaItem(item);
        });
    }
}