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
                                    <button><a href='?id=${ingrediente.id}'>delete</a></button>
                                </td>
                            </tr>`
                        ).join('')}
                    </tbody>
                </table>`
    }

    _templateSelect(ingredientes){
        return `<label>Ingredientes</label>
                    <select id="selectIngredientes">
                        ${ingredientes.map(ingrediente => {
                            `<option value=${ingrediente.id}>${ingrediente.nome}</option>`
                        }).join('')}
                    </select>`
    }
}