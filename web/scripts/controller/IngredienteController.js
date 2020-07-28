class IngredienteController{
    constructor(){
        this._inputNomeIngrediente = $("#nomeIngrediente");
        this._inputPrecoIngrediente = $("#precoIngrediente");
        this._ingredientes = new Ingredientes(); 
        this._ingredienteView = new IngredienteView("#tabelaIngrediente");
    }

    adicionarIngrediente(event){
        event.preventDefault();
        const ingrediente = this._criaIngrediente();
        const body = {nome:ingrediente.nome, preco:ingrediente.preco};
        Requests.post("http://localhost:8080/ingredientes", body)
        .then((ingrediente) => {
            this._ingredientes.adiciona(new Ingrediente(ingrediente.id, ingrediente.nome, ingrediente.preco));
            this._ingredienteView.update(this._ingredientes);
        })        
    }

    editarIngrediente(event){
        event.preventDefault();
        const ingrediente = this._criaIngrediente();
        const body = {nome:ingrediente.nome, preco:ingrediente.preco};
        Requests.put(`http://localhost:8080/ingredientes`,idIngrediente, body)
        .then((ingrediente) => {
            this._ingredientes.esvaziaIngredientes();
            this._ingredientes.adiciona(new Ingrediente(ingrediente.id, ingrediente.nome, ingrediente.preco));
            this._ingredienteView.update(this._ingredientes);
        })                    
    }

    importarUmIngredientePorId(id){
        Requests.get(`http://localhost:8080/ingredientes/${id}`) 
        .then((ingredienteDaRequisicao) => {
            const ingrediente = new Ingrediente(ingredienteDaRequisicao.id, ingredienteDaRequisicao.nome, ingredienteDaRequisicao.preco);
            this._inputAutoPreenchido(ingrediente);
            this._ingredientes.adiciona(ingrediente);
            this._ingredienteView.update(this._ingredientes);
        })
    }

    importarIngredientes(){
        Requests.get("http://localhost:8080/ingredientes") 
        .then((ingredientesDaRequisicao) => {
            ingredientesDaRequisicao
            .map(ingrediente => new Ingrediente(ingrediente.id, ingrediente.nome, ingrediente.preco))
            .forEach(ingrediente => this._ingredientes.adiciona(ingrediente));
            this._ingredienteView.update(this._ingredientes);
        })           
    }  

    _criaIngrediente(){
        return new Ingrediente(
            null,
            this._inputNomeIngrediente.value,  
            parseFloat(this._inputPrecoIngrediente.value)
        );
    }
   
    _inputAutoPreenchido(ingrediente){
        this._inputNomeIngrediente.value = ingrediente.nome;
        this._inputPrecoIngrediente.value = ingrediente.preco;
    }
}