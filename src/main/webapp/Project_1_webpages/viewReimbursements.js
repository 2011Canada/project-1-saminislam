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

        return `<li>For Reimbursement ID:  ${reimbursements._reimb_id}, Amount Claimed is $${reimbursements.amount}. The reimbursement description: ${reimbursements.reimb_description}.  ->  Current status:  ${reimbursements.reimb_status}.</li>`

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