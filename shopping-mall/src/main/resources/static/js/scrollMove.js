function scroll(id){
    let position = $(`${id}`).offset().top;
    console.log(id)
    $('html').animate({
        scrollTop: position
    }, 500)
}