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
        this._cadastroLancheView.update(this._lanches);     
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

    importarUmLanchePorId(id){
        Requests.get(`http://localhost:8080/lanches/${id}`) 
        .then((lancheDaRequisicao) => {
            const lanche = new Lanche(lancheDaRequisicao.id, lancheDaRequisicao.nome, lancheDaRequisicao.valor);
            lanche.adicionaTodosItens(
                lancheDaRequisicao
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
   
}