const $ = document.querySelector.bind(document);
const lancheController = new LancheController();
const formLanche =$("#formLanche");
const idLanche = window.location.href.split('?id=')[1];

if(idLanche){
    lancheController.importarUmLanchePorId(idLanche);
    lancheController.addEventListener("submit", lancheController.editarLanche.bind(ingredienteController));
}else{
    formLanche.addEventListener("submit", lancheController.adicionarLanche.bind(lancheController));
    const btn = $("#cadastrarLanche")
    btn.addEventListener("click", lancheController.cadastrarLanche.bind(lancheController));
}