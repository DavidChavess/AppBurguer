class LancheController{
    constructor(){
        const $ = document.querySelector.bind(document);
        this._inputNomeLanche = $("#nomeLanche");
        this._inputSelectIngredientes = $("#selectIngredientes");
        this._lanche = this._criaLanche();
        this._inputQuantidadeLanche = $("#quantidadeLanche");
        this._lanchesView = new LancheView("#lanche");
    }

    adicionarLanche(event){
        event.preventDefault();
        this._lanche.adicionaItem(this._criaItemLanche());
        console.log(this._lanche);
        this._lanchesView.update(this._lanche);
    }
  
    _criaLanche(){
        return new Lanche(
            null,
            this._inputNomeLanche.value
        );
    }
    _criaItemLanche(){
        return new ItemLanche(
            this._inputSelectIngredientes.value,
            this._inputQuantidadeLanche.value
        );
    }
}