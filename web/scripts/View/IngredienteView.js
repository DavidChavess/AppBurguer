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
                                    <button id="edit"><a href='ingredienteCadastrar.html?id=${ingrediente.id}'>edit</a></button>
                                    <button id="delete"><a href='?id=1'>delete</a></button>
                                </td>
                            </tr>`
                        ).join('')}
                    </tbody>
                </table>`
    }
}