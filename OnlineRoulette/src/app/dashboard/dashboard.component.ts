import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { LoginServiceService } from '../shared/login-service.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router: Router, private post: LoginServiceService) { }
  count: number = 0;

  dataArray: any = [];

  formvalue: string[] = ['oneto12', 'twoto12', 'threeto12', 'zero', 'oneto18', 'nineteento36', 'even', 'odd']

  inputValue: any;
  counter: number = 0;
  type: number = 0;
  insufficientAmount: boolean = true;
  formData;

  randomNumber: number = 0;
  winningamount: number = 0;
  betAmount: number = 0;
  currentBalance: number;
  noOfInputs: boolean = false;

  ngOnInit() {
    this.currentBalance = +localStorage.getItem("balance");
  }

  onClickSubmit(data) {
    console.log(data)
    this.formData = data;
    this.count = 0;
    this.counter = 0;
    this.dataArray[0] = data.oneto12;
    this.dataArray[1] = data.twoto12;
    this.dataArray[2] = data.threeto12;
    this.dataArray[3] = data.zero;
    this.dataArray[4] = data.oneto18;
    this.dataArray[5] = data.nineteento36;
    this.dataArray[6] = data.even;
    this.dataArray[7] = data.odd;

    this.dataArray.forEach(element => {
      this.counter++;
      if (element != "") {
        this.count++;
        this.inputValue = element;
        this.type = this.counter - 1;

      }
    });

    console.log("No of inputs: " + this.count)

    if (this.count != 1) {
      this.noOfInputs = true;
    } else {
      console.log("Input Value is " + this.inputValue + " of type " + this.type)
    }


  }

  exit() {
    this.router.navigate(['']);
  }

  errorCloseModal(data) {
    console.log("Closing Modal")
    data.oneto12 = "";
    data.twoto12 = "";
    data.threeto12 = "";
    data.zero = "";
    data.oneto18 = "";
    data.nineteento36 = "";
    data.even = "";
    data.odd = "";

  }
  reload() {
    window.location.reload();
  }

  sure() {

    console.log("Form Value: " + this.formvalue[this.type])
    console.log("Bet Amount: " + (this.formData[this.formvalue[this.type]]))
    var amount = +localStorage.getItem("balance");
    console.log('Bet Amount: ' + amount)
    console.log('Bet amount is on: ' + typeof (amount))

    if (this.formData[this.formvalue[this.type]] > amount) {
      this.insufficientAmount = false;
    } else {
      this.randomNumber = Math.floor(Math.random() * 36);
      console.log("Roulette no: " + this.randomNumber)
      this.betAmount = this.formData[this.formvalue[this.type]];

      switch (this.formvalue[this.type]) {
        case 'oneto12': {
          if (this.randomNumber <= 12 && this.randomNumber >= 1) {
            this.winningamount = 1.5 * this.betAmount;
          } else {
            this.winningamount = 0;
          }
          break;
        }
        case 'twoto12': {
          if (this.randomNumber <= 24 && this.randomNumber >= 13) {
            this.winningamount = 1.5 * this.betAmount;
          } else {
            this.winningamount = 0;
          }
          break;
        }
        case 'threeto12': {
          if (this.randomNumber <= 36 && this.randomNumber >= 25) {
            this.winningamount = 1.5 * this.betAmount;
          } else {
            this.winningamount = 0;
          }
          break;
        }
        case 'zero': {
          if (this.randomNumber == 0) {
            this.winningamount = 10 * this.betAmount;
          } else {
            this.winningamount = 0;
          }
          break;
        }
        case 'oneto18': {
          if (this.randomNumber <= 18 && this.randomNumber >= 1) {
            this.winningamount = 1.25 * this.betAmount;
          } else {
            this.winningamount = 0;
          }
          break;
        }
        case 'nineteento36': {
          if (this.randomNumber <= 36 && this.randomNumber >= 19) {
            this.winningamount = 1.25 * this.betAmount;
          } else {
            this.winningamount = 0;
          }
          break;
        }
        case 'even': {
          if (this.randomNumber % 2 == 0) {
            this.winningamount = 1.25 * this.betAmount;
          } else {
            this.winningamount = 0;
          }
          break;
        }
        case 'odd': {
          if (this.randomNumber % 2 != 0) {
            this.winningamount = 1.25 * this.betAmount;
          } else {
            this.winningamount = 0;
          }
          break;
        }
      }
    }

    localStorage.setItem("balance", (this.currentBalance - this.betAmount + this.winningamount).toString());

    this.post.postAmount(localStorage.getItem("id"), localStorage.getItem("balance")).subscribe(data => {
      console.log("Balance Updated in DB.");
    })
  }
}
