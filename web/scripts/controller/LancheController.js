class LancheController{
    constructor(){
        const $ = document.querySelector.bind(document);
        this._inputNomeLanche = $("#nomeLanche");
        this._inputIdIngrediente = $("#idIngrediente");
        this._inputQuantidadeLanche = $("#quantidadeLanche");

        this._lanches = new Lanches();
        this._mensagem = new Mensagem();

        this._lancheView = new LancheView("#lanche");
        this._cadastroLancheView = new CadastroLancheView("#lanche");
        this._mensagemView = new MensagemView("#mensagem");

        this._mensagemView.update(this._mensagem);
        this._lancheView.update(this._lanches);
        this._cadastroLancheView.update(this._lanches);
    }

    adicionarLanche(event){
        event.preventDefault();
        this._lanches.adiciona(this._criaLanche());
        this._limparCampos();
        this._desabilitarInputNome();
        this._cadastroLancheView.update(this._lanches);     
    }

    apagaLanche(id){
        Requests.delete(`http://localhost:8080/lanches`, id) 
        .then((response) => {
            if(response.status === 400){
                this._mensagem.texto = response.message;
                this._mensagemView.update(this._mensagem);
            }else{
                this._mensagem.texto = "Lanche apagado com sucesso";
                this._mensagemView.update(this._mensagem);
                this.importarLanches();
            }           
        }) 
    }


        cadastrarLanche(event){
            event.preventDefault();
            const entidadeLanche = new Lanche();
            this._lanches.paraArray()
            .forEach(lanche => {
                entidadeLanche.nome = lanche.nome;
                entidadeLanche.adicionaTodosItens(
                    lanche.itensParaArray().map(item => {
                    const ingrediente = new Ingrediente(item.ingrediente.id)
                    return new ItemLanche(ingrediente,item.quantidade)})
                )
            })
    
            Requests.post("http://localhost:8080/lanches", entidadeLanche)
            .then((lancheDaRequisicao) => {
                const lanche = new Lanche(lancheDaRequisicao.id, lancheDaRequisicao.nome, lancheDaRequisicao.valor);
                lanche.adicionaTodosItens(
                    lancheDaRequisicao
                    .ingredientes.map((item => {
                        const ingrediente = new Ingrediente(item.ingrediente.id, item.ingrediente.nome, item.ingrediente.preco)
                        return new ItemLanche(ingrediente, item.quantidade, item.valor)
                    }))
                )
                this._lanches.esvazia();
                this._lanches.adiciona(lanche);
                this._lancheView.update(this._lanches);
                this._mensagem.texto = "Lanche cadastrado com sucesso!";
                this._mensagemView.update(this._mensagem);
            })
        }
    
/*
        event.preventDefault();
        const entidadeLanche = new Lanche();
        this._lanches.paraArray()
        .forEach(lanche => {
            entidadeLanche.nome = lanche.nome;
            entidadeLanche.adicionaTodosItens(
                lanche.itensParaArray().map(item => {
                const ingrediente = new Ingrediente(item.ingrediente.id)
                return new ItemLanche(ingrediente,item.quantidade)})
            )
        })

        Requests.post("http://localhost:8080/lanches", entidadeLanche)
        .then((response) => {
            if(response.status === 201){
                console.log(response)
                const lanche = new Lanche(response.id, response.nome, response.valor);
                lanche.adicionaTodosItens(
                    response
                    .ingredientes.map((item => {
                        const ingrediente = new Ingrediente(item.ingrediente.id, item.ingrediente.nome, item.ingrediente.preco)
                        return new ItemLanche(ingrediente, item.quantidade, item.valor)
                    }))
                )
                this._lanches.esvazia();
                this._lanches.adiciona(lanche);
                console.log(this._lanches)
                this._lancheView.update(this._lanches);
                this._mensagem.texto = "Lanche cadastrado com sucesso!";
                this._mensagemView.update(this._mensagem);
            }else if(response.status === 404){
                this._mensagem.texto = "Ingrediente não encontrado";
                this._mensagemView.update(this._mensagem);
            }else{
                this._mensagem.texto = "Não foi possivel cadastrar o lanche";
                this._mensagemView.update(this._mensagem);
            }
        })
     }   */
    

    importarUmLanchePorId(id){
        Requests.get(`http://localhost:8080/lanches/${id}`) 
        .then((lancheDaRequisicao) => {
            const lanche = new Lanche(lancheDaRequisicao.id, lancheDaRequisicao.nome, lancheDaRequisicao.valor);
            lanche.adicionaTodosItens(
                lanche
                .ingredientes.map((item => {
                    const ingrediente = new Ingrediente(item.ingrediente.id, item.ingrediente.nome, item.ingrediente.preco)
                    return new ItemLanche(ingrediente, item.quantidade, item.valor)
                }))
            )
            this._lanches.adiciona(lanche);
            this._lancheView.update(this._lanches);
        })
    }

    importarLanches(){
        Requests.get(`http://localhost:8080/lanches`) 
        .then((lanchesDaRequisicao) => {
            lanchesDaRequisicao
            .forEach(lanche => { 
                const entidadeLanche = new Lanche(lanche.id, lanche.nome, lanche.valor)
                entidadeLanche.adicionaTodosItens(
                    lanche
                    .ingredientes.map((item => {
                        const ingrediente = new Ingrediente(item.ingrediente.id, item.ingrediente.nome, item.ingrediente.preco)
                        return new ItemLanche(ingrediente, item.quantidade, item.valor)
                    }))
                )
                this._lanches.adiciona(entidadeLanche);
            })
            this._lancheView.update(this._lanches);
        })
    }

  
    _criaLanche(){
        const lanche = new Lanche(null, this._inputNomeLanche.value);
        lanche.adicionaItem(new ItemLanche(
            new Ingrediente(this._inputIdIngrediente.value),
            this._inputQuantidadeLanche.value)
        )
        return lanche;
    }

    _desabilitarInputNome(){
        this._inputNomeLanche.setAttribute("disabled", '');
    }

    _limparCampos(){
        this._inputIdIngrediente.value = '';
        this._inputQuantidadeLanche.value = '';
    }
   
}