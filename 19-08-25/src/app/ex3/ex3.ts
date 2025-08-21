import { Component } from '@angular/core';
import { NgClass } from '@angular/common';
@Component({
  selector: 'app-ex3',
  imports: [NgClass],
  templateUrl: './ex3.html',
  styleUrl: './ex3.css'
})
export class Ex3 {
  flag1: boolean = true;
  flag2: boolean = false;

  getNgClass() {
    return {
      app1: this.flag1,
      app2: this.flag2
};
  }
}
