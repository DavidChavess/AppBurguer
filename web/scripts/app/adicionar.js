const form = $("#formIngrediente");
const idIngrediente = window.location.href.split('?id=')[1];

if(idIngrediente){
    ingredienteController.importarUmIngredientePorId(idIngrediente);
    form.addEventListener("submit", ingredienteController.editarIngrediente.bind(ingredienteController));
}else{
    form.addEventListener("submit", ingredienteController.adicionarIngrediente.bind(ingredienteController));
}











