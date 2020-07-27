const $ = document.querySelector.bind(document);

let ingredienteController = new IngredienteController();
ingredienteController.importarIngredientes();

let form = $("form");
form.addEventListener("submit", ingredienteController.adiciona.bind(ingredienteController));




