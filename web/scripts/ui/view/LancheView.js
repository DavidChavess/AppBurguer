class LancheView extends View{
    _template(lanches){
        return `<table id="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Ingrediente</th>
                            <th>Preço</th>
                            <th>Quantidade</th>
                            <th>Valor</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                            <tbody>
                                ${lanches.paraArray().map(lanche =>      
                                    `${this.renderizarItens(lanche.itensParaArray(), lanche)}
                                    <tr style='background: #fff'>
                                        <td>Total</td>
                                        <td>${lanche.valor}</td>
                                    </tr> 
                            </tbody>`).join('')}
                </table>`
    }

    renderizarItens(itens, lanche){
        let html = '';
        itens.forEach(item => {
            html += `
            <tr>
                <td>${lanche.id}</td>
                <td>${lanche.nome}</td>
                <td>${item.ingrediente.nome}</td>
                <td>${item.ingrediente.preco}</td>
                <td>${item.quantidade}</td>
                <td>${item.valor}</td>
                <td>
                    <button id="edit"><a href='lancheCadastrar.html?id=${lanche.id}'>edit</a></button>
                    <button><a href='?id=${lanche.id}'>delete</a></button>
                </td>
            </tr>
         
             `
            
        });
        return html;
    }
}