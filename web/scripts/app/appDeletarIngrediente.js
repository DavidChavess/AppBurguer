const controller = new IngredienteController();
const idIngredienteDeletar = window.location.href.split('?id=')[1];
console.log(idIngredienteDeletar)
controller.apagaIngrediente(idIngredienteDeletar);


