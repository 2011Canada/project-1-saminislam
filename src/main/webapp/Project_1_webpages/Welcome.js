


    document.addEventListener("DOMContentLoaded", function(event) {
        let btnshow1 = document.getElementById('button1');
        let btnshow2 = document.getElementById('button2');
        let btnshow3 = document.getElementById('button3');
    
        console.log(sessionStorage.getItem('Is Finance Manager'));
    
        if (sessionStorage.getItem("Is Finance Manager") === 'true'){
            btnshow1.disabled = true;
            btnshow2.disabled = true;
            btnshow3.disabled = false;
        }
        if (sessionStorage.getItem("Is Finance Manager" ) === 'false' ){
            btnshow1.disabled = false;
            btnshow2.disabled = false;
            btnshow3.disabled = true;
        }

      });


/*
    let btnshow1 = document.getElementById('button1');
    let btnshow2 = document.getElementById('button2');
    let btnshow3 = document.getElementById('button3');

    console.log(localStorage.getItem('Is Finance Manager'));

    if (localStorage.getItem("Is Finance Manager")){
        btnshow1.disabled = true;
        btnshow2.disabled = true;
        btnshow3.disabled = false;
    }
    if (!localStorage.getItem("Is Finance Manager")){
        btnshow1.disabled = false;
        btnshow2.disabled = false;
        btnshow3.disabled = true;
    }
*/

   
/*
    try{

        let res = await fetch("http://localhost:8080/project1/options",{
            method:"POST",
            body: JSON.stringify(credentials),
            headers:{
                "Content-Type" : "application/json"
            }
        })

        let user = await res.json()
        console.log(user);
    } catch( e) {
        console.log(e);
    }

*/

//document.getElementsByTagName("form")[0].addEventListener('1', welcomeSubmit)
