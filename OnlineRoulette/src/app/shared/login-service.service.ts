import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private http:HttpClient) { }

  url="http://localhost:9999/casinoAdmin/roulette/api/rouletteCustomer/";
  getUser(id:string){
    console.log(id);
    return this.http.get<any>(this.url + id);
  }

  postAmount(id:string,amount:string){
    console.log("Inside post service: "+id);
    return this.http.get<any>(this.url+id+"/balanceUpdate/"+amount);
  }
}


