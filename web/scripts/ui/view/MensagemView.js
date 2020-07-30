class MensagemView extends View{
    _template(model){
        return model.texto ? `<p class='message'>${model.texto}</p> ` : `<p></p>`;
    }

}
