# Expense Reimbursement System

## Project Description

An expense reimbursement system which targets two different types of users. A valid employee can log in and visit their dashboard to see their pending reimbursement tickets or have the ability to post another reimbursement ticket. The other user is a finance manager that can log in and view all past reimbursement tickets posted by any "employee" users. The finance managers are able to approve or deny an employee's request depending on if the expense was incurred while on company time.

## Technologies Used

* Java 
* JavaScript 
* HTML/CSS
* JDBC 
* Servlets
* SQL

## Features

1. Employee can log in and view the employee dashboard. The employee dashboard shows two options where the employee could view their past submitted tickets or create a new reimbursement ticket.
2. The employee is given a chance to talk about the reimbursement, input the expense amount, and select the type of reimbursement (lodging, food, travel, and other)
3. The finance manager can login and view the finance manager dashboard. The finance manager dashboard shows one option which is to view all submitted tickets. As a design choice, the finance manager is not able to submit any tickets.
4. The finance manager is able to view all tickets and approve or deny tickets upto their own discretion.


## Getting Started

1. Clone the project using the following command
git clone https://github.com/2011Canada/project-1-saminislam.git
2. Have Apache Tomcat 9, the latest version of Java, Maven and PosgreSQL installed.
3. Run the posted scripts in the scripts folder in your database to initialize your database for this project to be able to run.
4. Run the program on a Java server.
5. The program will be able to run on http://localhost:8080/p1/Project_1 on your local browser.

## Usage 

* The main webpage will ask the user to login. 

![Login-p1](https://user-images.githubusercontent.com/57554163/105417348-79a13080-5c09-11eb-807a-c95111f09d61.PNG)

* The user will be sent to the appropriate login page depending on the user login credentials(finance manager/employee).
* The employee is able to submit tickets and view their previously submitted tickets.
* The following image is a picture of the employee dashboard. If a finance manager were to sign in, the choices to submit and view previous 
reimbursements would have been greyed out but they would have the option to approve/ deny requests.

![employee-login](https://user-images.githubusercontent.com/57554163/105420157-e0284d80-5c0d-11eb-8eee-e57153ad7dbf.PNG)

* The following image shows the forms required to be filled out by the employee in order to submit a reimbursement ticket.
![sub-reimb](https://user-images.githubusercontent.com/57554163/105420277-11088280-5c0e-11eb-9b95-f1039956a7e2.PNG)

## Contributors

*Samin Islam (myself)


