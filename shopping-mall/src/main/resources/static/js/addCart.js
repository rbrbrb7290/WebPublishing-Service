document.getElementById('addCart').addEventListener('click', e => addCart());

async function addCart() {
    var url = document.location.href;
    let param = url.split("/")[5]
    console.log("addCart")
    console.log(param)
    /*<![CDATA[*/
    let userId = /*[[${session.loginUser}]]*/ UserId;
    /*]]>*/
    let productId = param;
    try{
        let res = await fetch(`/api/order/cart`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Charset': 'UTF-8'
            },
            body: JSON.stringify({
                userId,
                productId,
            })
        });
        if(res.ok) document.location.href="/api/order/cart/list";
    }catch (e) {

    }
}