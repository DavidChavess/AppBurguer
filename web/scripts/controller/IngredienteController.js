class IngredienteController{
    constructor(){
        const $ = document.querySelector.bind(document);
        this._inputNomeIngrediente = $("#nomeIngrediente");
        this._inputPrecoIngrediente = $("#precoIngrediente");

        this._ingredientes = new Ingredientes(); 
        this._mensagem = new Mensagem();

        this._ingredienteView = new IngredienteView("#tabelaIngrediente");
        this._ingredienteView.update(this._ingredientes);

        this._mensagemView = new MensagemView("#mensagem");
        this._mensagemView.update(this._mensagem);
    }

    adicionarIngrediente(event){
        event.preventDefault();
        Requests.post("http://localhost:8080/ingredientes", this._criaIngrediente())
        .then((ingrediente) => {
            this._ingredientes.adiciona(new Ingrediente(ingrediente.id, ingrediente.nome, ingrediente.preco));
            this._ingredienteView.update(this._ingredientes);
            this._mensagem.texto = "Ingrediente cadastrado com sucesso!";
            this._mensagemView.update(this._mensagem);
        })        
    }

    editarIngrediente(event){
        event.preventDefault();
        Requests.put(`http://localhost:8080/ingredientes`,idIngrediente, this._criaIngrediente())
        .then((ingrediente) => {
            this._ingredientes.esvaziaIngredientes();
            this._ingredientes.adiciona(new Ingrediente(ingrediente.id, ingrediente.nome, ingrediente.preco));
            this._ingredienteView.update(this._ingredientes);
            this._mensagem.texto = "Ingrediente alterado com sucesso!";
            this._mensagemView.update(this._mensagem);
        })            
    }

    importarUmIngredientePorId(id){
        Requests.get(`http://localhost:8080/ingredientes/${id}`) 
        .then((ingrediente) => {
            this._ingredientes.adiciona(new Ingrediente(ingrediente.id, ingrediente.nome, ingrediente.preco));
            this._inputAutoPreenchido(ingrediente);
            this._ingredienteView.update(this._ingredientes);
        })
    }

    importarIngredientes(){
        Requests.get("http://localhost:8080/ingredientes") 
        .then((ingredientes) => {
            ingredientes
            .map(ingrediente => new Ingrediente(ingrediente.id, ingrediente.nome, ingrediente.preco))
            .forEach(ingrediente => this._ingredientes.adiciona(ingrediente));
            this._ingredienteView.update(this._ingredientes);
        })           
    }  

    apagaIngrediente(id){
        Requests.delete(`http://localhost:8080/ingredientes`, id) 
        .then((response) => {
            if(response.status === 400){
                this._mensagem.texto = response.message;
                this._mensagemView.update(this._mensagem);
            }else{
                this._mensagem.texto = "Ingrediente apagado com sucesso";
                this._mensagemView.update(this._mensagem);
                this.importarIngredientes();
            }           
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