class IngredienteView extends View{
    _template(ingredientes){
        return `<table id="table">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Nome</th>
                            <th>Preço</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
                    <tbody>
                        ${ingredientes.paraArray().map(ingrediente =>  
                            `<tr>
                                <td>${ingrediente.id}</td>
                                <td>${ingrediente.nome}</td>
                                <td>${ingrediente.preco}</td>
                                <td>
                                    <button id="edit"><a href='ingredienteCadastrar.html?id=${ingrediente.id}'>editar</a></button>
                                    <button id="edit"><a href='ingredienteDeletar.html?id=${ingrediente.id}'>deletar</a></button>
                                </td>
                            </tr>`
                        ).join('')}
                    </tbody>
                </table>`
    }
}