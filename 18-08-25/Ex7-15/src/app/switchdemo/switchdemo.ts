//EX-13
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';   

@Component({
  selector: 'app-switchdemo',
  standalone: true,
  imports: [FormsModule],   
  templateUrl: './switchdemo.html',
  styleUrls: ['./switchdemo.css']  
})
export class Switchdemo {
  color: string = 'default';
}
