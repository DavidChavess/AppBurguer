const formLanche = document.querySelector("#formLanche");
const lancheController = new LancheController();
formLanche.addEventListener("submit", lancheController.adicionarLanche.bind(lancheController));