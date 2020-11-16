function sendLogin() {
    console.log("sendLogin() started.")
    let loginForm = document.loginForm;
    let username = document.getElementById('exampleInputEmail1').value;
    let password = document.getElementById('exampleInputPassword1').value;

    let loginTemplate = {
        username: "username",
        password: "password"
    }

    // This begins AJAX workflow.
    let xhr = new XMLHttpRequest();
    
 // setting up a callback function for when ready state changed (ready stat starts from 0 to 4)
 // this call back is called everytime readyState changes
 
    xhr.onreadystatechange = function() {
        if(this.readyState === 4 && this.status === 200) {
            sessionStorage.setItem('currentUser', this.responseText);
            window.location = "http://localhost:8080/EmployeeServletDemo/home.html";
        }

        if(this.readyState === 4 && this.status === 204) {
            alert("Failed to log in! Username or password is incorrect.")
        }
    }
    
    
    xhr.open("POST", "http://localhost:8080/EmployeeServletDemo/login");

    xhr.send(JSON.stringify(loginTemplate));
}