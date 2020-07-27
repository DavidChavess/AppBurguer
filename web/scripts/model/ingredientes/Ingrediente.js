class Ingrediente{
    constructor(id, nome, preco){
        this._id = id;
        this._nome = nome;
        this._preco = preco;
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
    set preco(preco){
        this._preco = preco;
    }
    get preco(){
        return this._preco;
    }
}