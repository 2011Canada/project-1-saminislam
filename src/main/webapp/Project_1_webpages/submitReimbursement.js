
async function submitReimbursement(e) {
   // e.preventDefault()
    
    let amount = document.getElementById("amount-input").value
    console.log(amount)
    let reimb_description = document.getElementById("reimb_des").value
    console.log(reimb_description)
    let reimb_type = document.querySelector('input[name="reimb_type"]:checked').value;
    console.log(reimb_type)

    var date_submitted = new Date();
    var dd = String(date_submitted.getDate()).padStart(2, '0');
    var mm = String(date_submitted.getMonth() + 1).padStart(2, '0'); //January is 0!
    var yyyy = date_submitted.getFullYear();

    var reimb_status = "Pending";

    var author = sessionStorage.getItem("UserID");

    date_submitted = dd + '/' + mm + '/' + yyyy;
    

    const reimb = {
        amount,
        date_submitted,
        reimb_description,
        author,
        reimb_status,
        reimb_type
    }

    try {
        let res = await fetch ("http://localhost:8080/project1/submit_reimbursements", {
            method: "POST",
            body: JSON.stringify(reimb),
            headers:{
                "Content-Type" : "application/json"
            }
        })

        let reimbstatus = await res.json()
        console.log(reimbstatus)

        } catch(e) {
            console.log(e)
        }

        alert("Request has been submitted")
        //window.location.href = "./Welcome.html"
    }

    /*
    function mainMenuSubmit(e) {
        //e.preventDefault()
        window.location = "./Welcome.html"
        return false;
    }
    */

    //document.getElementById("mainMenu").addEventListener('click', mainMenuSubmit)
   // document.getElementById("other-button").addEventListener('click', submitReimbursement )

    var el = document.getElementById('other-button');
    if(el){
        document.getElementById("other-button").addEventListener('click', submitReimbursement )
    }



