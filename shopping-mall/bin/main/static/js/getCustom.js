     //커스터마이징 데이터 GET
     async function getCustom() {
       let customInfo = document.querySelector("body > div.jumbotron > div")
        try {
            let res = await fetch(`/api/admin/custom/get` , {
                method:'GET',
            });
         let data = await res.json();
            data.map(custom=> {
                let block = `
                        <h1>${custom.title}</h1>
                `
                customInfo.innerHTML += block;
            });
        } catch (e) {
        }
 }
