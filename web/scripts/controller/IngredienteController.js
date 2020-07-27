class IngredienteController{
    constructor(){
        this._inputNomeIngrediente = $("#nomeIngrediente");
        this._inputPrecoIngrediente = $("#precoIngrediente");
        this._ingredientes = new Ingredientes(); 
        this._ingredienteView = new IngredienteView("#tabelaIngrediente"); 
    }

    adiciona(event){
        event.preventDefault();
        let body = {nome:this._criaIngrediente().nome, preco:this._criaIngrediente().preco};
        Requests.post("http://localhost:8080/ingredientes", body)
        .then(() => {
            this._ingredientes.adiciona(body);
            this._ingredienteView.update(this._ingredientes);
        })        
    }

    importarIngredientes(){
        Requests.get("http://localhost:8080/ingredientes") 
        .then((ingredientes) => {
            ingredientes
            .map(ingredientes => new Ingrediente(ingredientes.nome, ingredientes.preco))
            .forEach(ingrediente => this._ingredientes.adiciona(ingrediente));
            this._ingredienteView.update(this._ingredientes);
        })           
    }  

    _criaIngrediente(){
        return new Ingrediente(
            this._inputNomeIngrediente.value,  
            parseFloat(this._inputPrecoIngrediente.value)
        );
    }
    _criaIngredienteComIngrediente(ingrediente){
        return new Ingrediente(ingrediente.nome, ingrediente.preco);
    }
}