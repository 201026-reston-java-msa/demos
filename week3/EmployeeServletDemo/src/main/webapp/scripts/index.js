function sendLogin()
{
    console.log("sendLogin() started.")
    let uName = document.getElementById("uName").value;
    let pWord = document.getElementById("pWord").value;
    console.log("Username " + uName)
    console.log("Password " + pWord)
    let loginTemplate = {
        username: uName,
        password: pWord
    }
    //This begins AJAX workflow
    let xhr = new XMLHttpRequest()
    xhr.onreadystatechange = function(){
        if(this.readyState === 4 && this.status === 200)
        {
            console.log("Success")
            sessionStorage.setItem('currentUser', this.responseText)
            window.location = "http://localhost:8080/EmployeeServletDemo/home.html"
            console.log(sessionStorage.getItem('currentUser'))
        }
        if(this.readyState ===4 && this.status ===204)
        {
            console.log("Failed")
            //alert("Failed to log in! Username or password is incorrect")
            let childDiv= document.getElementById("warningText")
            childDiv.textContent ="Failed to log in! Username or Password is incorrect"
        }
        console.log("Processing")
        
    }
    xhr.open("POST","http://localhost:8080/EmployeeServletDemo/login")
    xhr.send(JSON.stringify(loginTemplate))
}