async function viewReimbursements(e) {

    try {

        let res = await fetch("http://localhost:8080/project1/view_reimbursements" , {
            method: "POST",
            headers: {
                "Content-type": "application/json"
            }
        })
    

    let reimbursements = await res.json();

    console.log(reimbursements);

    document.querySelector(".reimbursementHistory").innerHTML = '<ol>' + reimbursements.map(function (reimbursements) {

        return `<li>For: ${reimbursements.reimb_description} in amount: $${reimbursements.amount}. Your unique reimbursement ID is: ${reimbursements.reimb_id}, Current status:  ${reimbursements.reimb_status}.</li>`

    }).join('') + '</ol>';
    

} catch (e) {
    console.log(e);
}
}

function mainMenuSubmit(e) {
    e.preventDefault()
    window.location = "./Welcome.html"
}

window.onload = function() {

    viewReimbursements();
}

document.getElementById("mainMenu").addEventListener('click', mainMenuSubmit)