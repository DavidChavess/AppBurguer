class Ingrediente{
    constructor(nome, preco){
        this._nome = nome;
        this._preco = preco;
    }

    set nome(nome){
        this._nome = nome;
    }
    get nome(){
        return this._nome;
    }

    set preco(preco){
        this._preco = preco;
    }

    get preco(){
        return this._preco;
    }
}