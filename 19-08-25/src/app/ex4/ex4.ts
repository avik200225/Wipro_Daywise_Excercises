import { Component } from '@angular/core';
import { NgStyle } from '@angular/common';
@Component({
  selector: 'app-ex4',
  imports: [NgStyle],
  templateUrl: './ex4.html',
  styleUrl: './ex4.css'
})
export class Ex4 {
flag1: boolean = false;
flag2: boolean = true;
color1:string = 'red';
fontsize1:string = '20px'

}

