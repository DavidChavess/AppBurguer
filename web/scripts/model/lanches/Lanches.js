class Lanches{
    constructor(){
        this._lanches = [];
    }

    adiciona(lanche){
        this._lanches.push(lanche);
    }

    esvazia(){
        this._lanches.length = 0;
    }

    paraArray(){
        return this._lanches;
    }
}