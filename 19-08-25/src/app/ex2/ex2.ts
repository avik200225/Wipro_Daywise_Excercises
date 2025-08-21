import { Component } from '@angular/core';
import { NgClass } from '@angular/common';
@Component({
  selector: 'app-ex2',
  imports: [NgClass],
  templateUrl: './ex2.html',
  styleUrl: './ex2.css'
})
export class Ex2 {
  protected title = 'thirdapp';
  flag1: boolean = true;
  flag2: boolean = true;
}
