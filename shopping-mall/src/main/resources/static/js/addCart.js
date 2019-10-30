document.getElementById('addCart').addEventListener('click', e => addCart());

async function addCart() {
    var url = document.location.href;
    let param = url.split("/")[5]
    console.log("addCart")
    console.log(param)
    /*<![CDATA[*/
    let orderUserId = /*[[${session.loginUser}]]*/ orderUserId;
    /*]]>*/
    let productId = param;
    console.log(orderUserId)
    try{
        let res = await fetch(`/api/order/cart`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'Charset': 'UTF-8'
            },
            body: JSON.stringify({
                orderUserId,
                productId
            })
        });
        if(res.ok) document.location.href="/api/order/cart/list";
    }catch (e) {

    }
}

