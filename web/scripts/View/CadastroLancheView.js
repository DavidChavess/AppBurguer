class CadastroLancheView extends View{
    _template(lanches){
        return `<table id="table">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Id do Ingrediente</th>
                            <th>Quantidade</th>
                        </tr>
                    </thead>
                            <tbody>
                                ${lanches.paraArray().map(lanche =>      
                                    `${this.renderizarItens(lanche.itensParaArray(), lanche)}
                            </tbody>`).join('')}
                </table>`
    }

    renderizarItens(itens, lanche){
        let html = '';
        itens.forEach(element => {
            html += 
            `<tr>
                <td>${lanche.nome}</td>
                <td>${element.ingrediente.id}</td>
                <td>${element.quantidade}</td>
            </tr>`
        });
        return html;
    }
}