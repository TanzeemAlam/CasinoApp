import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  
  constructor(private location:Location, private router:Router) { }

  Name:String;
  Balance:String;

  ngOnInit() {
    console.log(history.state);
    this.Name = localStorage.getItem("name");
    this.Balance = localStorage.getItem("balance");
    console.log(this.location.getState());
  }

  exit(){
    console.log("User log's out!")
    localStorage.removeItem("loggedStatus");
    this.router.navigate(['']);
  }

}
