const controller = new LancheController();
const idLancheDeletar = window.location.href.split('?id=')[1];
console.log(idLancheDeletar)
controller.apagaLanche(idLancheDeletar);


