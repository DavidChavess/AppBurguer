class LancheView extends View{
    _template(lanche){
        const idLanche = lanche.id;
        return `<table id="table">
                    <thead>
                        <tr>
                            <th>Id do Lanche</th>
                            <th>Nome do Lanche</th>
                            <th>Ingrediente</th>
                            <th>Quantidade</th>
                            <th>Preço</th>
                            <th>Total</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>${idLanche}</td>
                            <td>${lanche.nome}</td>

                        ${lanche.itens.map(item =>
                            `<td>${item.nome}</td>
                            <td>${item.quantidade}</td>
                            <td>${item.valor}</td>
                            <td>
                                <button id="edit"><a href='ingredienteCadastrar.html?id=${idLanche}'>edit</a></button>
                                <button><a href='?id=${idLanche}'>delete</a></button>
                            </td>
                        </tr>`).join('')}
                    </tbody>
                    <tfoot>
                        <tr>
                            <td>${lanche.valor}</td>
                        </tr>
                    <t/foot>
                </table>`
    }
}