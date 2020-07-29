class LancheController{
    constructor(){
        const $ = document.querySelector.bind(document);
        this._inputNomeLanche = $("#nomeLanche");
        this._inputSelectIngredientes = $("#selectIngredientes");
        this._lanches = new Lanches();
        this._inputQuantidadeLanche = $("#quantidadeLanche");
        //this._lanchesView = new LancheView("#lanche");
        this._itemView = new Item("#lanche");
    }

    adicionarLanche(event){
        event.preventDefault();
        this._lanches.adiciona(this._criaLanche());
        this._itemView.update(this._lanches);
       
        
    }

    importarUmLanchePorId(id){
        Requests.get(`http://localhost:8080/lanches/${id}`) 
        .then((lancheDaRequisicao) => {
            const lanche = new Lanche(lancheDaRequisicao.id, lancheDaRequisicao.nome, lancheDaRequisicao.valor);
            lanche.adicionaTodosItens(
                lancheDaRequisicao
                .ingredientes.map((item => {
                    const ingrediente = new Ingrediente(item.ingrediente.id, item.ingrediente.nome, item.ingrediente.preco)
                    return new ItemLanche(ingrediente, item.quantidade)
                }))
            )
            this._lanches.adiciona(lanche);
            this._itemView.update(this._lanches);
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
                        return new ItemLanche(ingrediente, item.quantidade)
                    }))
                )
                this._lanches.adiciona(entidadeLanche);
            })
            this._itemView.update(this._lanches);
        })
    }

  
    _criaLanche(){
        const lanche = new Lanche(null, this._inputNomeLanche.value);
        lanche.adicionaItem(new ItemLanche(this._inputSelectIngredientes.value, this._inputQuantidadeLanche.value))
        return lanche;
    }
   
}