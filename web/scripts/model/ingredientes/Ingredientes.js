class Ingredientes{
    constructor(){
        this._ingredientes = [];
    }

    adiciona(ingrediente){
        this._ingredientes.push(ingrediente);
    }

    paraArray(){
        return this._ingredientes;
    }
}