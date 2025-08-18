import { Component, signal } from '@angular/core';
import { Secondcomp } from './secondcomp/secondcomp';

@Component({
  selector: 'app-root',
  imports: [Secondcomp],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('firstapp');
}
