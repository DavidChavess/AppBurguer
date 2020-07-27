class IngredienteView extends View{
    _template(ingredientes){
        return `<table id="table">
                    <thead>
                        <tr>
                            <th>Nome </th>
                            <th>Preço</th>
                            <th>Ações</th>
                        </tr>
                    </thead>
               
                    <tbody>
                        ${ingredientes.paraArray().map(ingrediente =>  
                            `<tr>
                                <td>${ingrediente.nome}</td>
                                <td>${ingrediente.preco}</td>
                                <td id="acoes">
                                    <button><img src="image/update.png" alt=""></button>
                                    <button><img src="image/delete.png" alt="" srcset=""></button>
                                </td>
                            </tr>`
                        ).join('')}
                    </tbody>
                </table>`
    }
}