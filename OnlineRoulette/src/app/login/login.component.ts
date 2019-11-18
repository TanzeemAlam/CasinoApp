import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../shared/login-service.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private loggedInStatus = localStorage.getItem("loggedStatus") || false;

  constructor(private httpservice: LoginServiceService, private router: Router) {
    //this.loggedInStatus = localStorage.getItem("logged")
  }

  ngOnInit() {
  }


  login(id: any) {

    console.log("loggedStatus: " + this.loggedInStatus)
    if (!this.loggedInStatus) {
      console.log("Someone is already logged in: " + this.loggedInStatus);
      this.router.navigate(['']);
    }
    else {
      console.log("Someone just logged in: " + this.loggedInStatus);
      localStorage.setItem("loggedStatus", "true");
     this.loggedInStatus = true;
      console.log("Unique Id is: ", id);
      localStorage.setItem("id", id);
      this.httpservice.getUser(id).subscribe(data => {
        console.log(data);
        if (data != null) {
          console.log("Welcome", data['custName']);
          localStorage.setItem("name", data['custName']);
          localStorage.setItem("balance", data['custAccountBalance']);

          this.router.navigate(['dashboard']);
        }
        else {
          console.log("User doesn't exits");
          this.router.navigate(['']);
        }
      })
    }
  }

}
