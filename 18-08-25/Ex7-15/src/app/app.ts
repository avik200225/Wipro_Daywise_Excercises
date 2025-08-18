import { Component, signal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('secondapp');
  //Ex 8,9
  
  // name:string="";
  // greet(){
  //   console.log(`${this.name} says Hello!`)
  // }

  fruitList: string[]=["Apple","Cherry","Banana","Date"];
}
