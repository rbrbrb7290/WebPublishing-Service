     //커스터마이징 데이터 GET
     async function getCustom() {
       let customInfo = document.querySelector("body > div.jumbotron > div")
         let bankInfo = document.querySelector("body > div.bankInfoBox")
        try {
            let res = await fetch(`/api/admin/custom/get` , {
                method:'GET',
            });
         let data = await res.json();
            data.map(custom=> {
                let block = `
                        <h2>${custom.title}</h2>
                `
                let block2 = `
                    <div class="customAboutBox">
                       <ul>
                        <li class="inner01">
                         <div class="innerBox">
                          <h5>ABOUT US</h5>
                          <p><span>mail order license [사업자 정보 확인]</span></p>
                          <p><span>address 제주특별자치도 제주시 00동</span></p>
                          <p><span>${custom.bankAdmin}</span></p>
                          <p><span>${custom.tellNumber}</span></p>
                         </div>
                        </li>
                 
                        <li class="inner02">
                         <div class="innerBox">
                          <h5>BANK</h5>
                          <p><span>${custom.bank} ${custom.bankAdmin}</span></p>
                          <p><span>${custom.tellNumber}</span></p>
                         </div>
                        </li>
                     
                        <li class="inner03">
                         <div class="innerBox">
                           <h5>COMMUNITY</h5>
                           <p><span>NOTICE</span></p>
                           <p><span>FAQ</span></p>
                           <p><span>Q&A</span></p>
                           <p><span>REVIEW</span></p>
                         </div>
                        </li>
                        </ul>
                   </div>
                `
                customInfo.innerHTML += block;
                bankInfo.innerHTML += block2;
            });
        } catch (e) {
        }
 }
