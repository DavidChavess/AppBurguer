const ingredienteController = new IngredienteController();
const formIngrediente = document.querySelector("#formIngrediente");
const idIngrediente = window.location.href.split('?id=')[1];

if(idIngrediente){
    ingredienteController.importarUmIngredientePorId(idIngrediente);
    formIngrediente.addEventListener("submit", ingredienteController.editarIngrediente.bind(ingredienteController));
}else{
    formIngrediente.addEventListener("submit", ingredienteController.adicionarIngrediente.bind(ingredienteController));
}











