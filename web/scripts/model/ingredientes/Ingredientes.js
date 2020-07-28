class Ingredientes{
    constructor(){
        this._ingredientes = [];
    }

    adiciona(ingrediente){
        this._ingredientes.push(ingrediente);
    }

    esvaziaIngredientes(){
        this._ingredientes.length = 0;
    }

    paraArray(){
        return this._ingredientes;
    }
}