function scroll(id){
    console.log("움직여!")
    let position = $(`${id}`).offset().top;
    $('html').animate({
        scrollTop: position - 10
    }, 500)
}