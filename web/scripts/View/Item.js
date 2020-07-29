class Item extends View{
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
        itens.forEach(element => {
            html += `
            <tr>
                <td>${lanche.id}</td>
                <td>${lanche.nome}</td>
                <td>${element.ingrediente.nome}</td>
                <td>${element.ingrediente.preco}</td>
                <td>${element.quantidade}</td>
                <td>${element.valor}</td>
                <td>
                    <button id="edit"><a href='lancheCadastrar.html?id=${lanche.id}'>edit</a></button>
                    <button><a href='?id=${lanche.id}'>delete</a></button>
                </td>
            </tr>
         
             `
            
        });
        return html;
    }
/*
    
*/

}