class ItemLanche{
    constructor(ingrediente, quantidade){
        this._ingrediente = ingrediente;
        this._quantidade = quantidade;
        this._valor = ingrediente.preco * quantidade;
    }
    set ingrediente(ingrediente){
        this._ingrediente = ingrediente;
    }
    get ingrediente(){
        return this._ingrediente;
    }
    set quantidade(quantidade){
        this._quantidade = quantidade;
    }
    get quantidade(){
        return this._quantidade;
    }
    get valor(){
        return this._valor;
    }
    set valor(valor){
        this._valor = valor;
    }
}