class IngredienteController{
    constructor(){
        this._ingredientes = new Ingredientes(); 
        this._ingredienteView = new IngredienteView("#tabelaIngrediente"); 
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
}