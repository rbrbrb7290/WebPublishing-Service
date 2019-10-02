let popupX = (document.body.offsetWidth / 2) - (500 / 2);
let popupY = (document.body.offsetHeight / 2 ) - (500 /2 );

function loginPopup(url){
    let option = `width=500, height=500, top=${-popupY},left=${popupX},
                    scrollars, resizable, toolbar=no ,  
                     location=no , status=no`

    window.open(url, "", option)
}



