async function approveReimbursements(e) {

    try {

        let res = await fetch("http://localhost:8080/project1/approve_reimbursements" , {
            method: "POST",
            headers: {
                "Content-type": "application/json"
            }
        })
    

    let reimbursements = await res.json();

    console.log(reimbursements);

    console.log(user_reimb_list);

    document.querySelector(".reimbursementHistory").innerHTML = '<ol>' + reimbursements.map(function (reimbursements) {

        return `<li>For Reimbursement ID:  ${reimbursements.user_reimb_list._reimb_id}, Amount Claimed is $${reimbursements.amount}. The reimbursement description: ${reimbursements.reimb_description}.  ->  Current status:  ${reimbursements.reimb_status}.</li>`

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

    approveReimbursements();
}

document.getElementById("mainMenu").addEventListener('click', mainMenuSubmit)