class View{
    constructor(seletor){
        this._elemento = document.querySelector(seletor);
    }

    update(model){
        this._elemento.innerHTML = this._template(model);
    }

    _template(model){
        throw new Error("Este metodo precisa ser implementado");
    }
}