// import { Component } from '@angular/core';

// @Component({
//   selector: 'app-display-list',
//   standalone: true,      
//   imports: [],
//   templateUrl: './display-list.html',
//   styleUrls: ['./display-list.css']
// })
// export class DisplayList {
//   fruits = [
//     {
//       name: 'Apple',
//       image: 'https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg',
//       description: 'Apple Keeps Doctors Away.'
//     },
//     {
//       name: 'Orange',
//       image: 'https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg',
//       description: 'Orange Image.'
//     },
//     {
//       name: 'Banana',
//       image: 'https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg',
//       description: 'Banana Image.'
//     },
//     {
//       name: 'Mango',
//       image: 'https://upload.wikimedia.org/wikipedia/commons/9/90/Hapus_Mango.jpg',
//       description: 'Mango is the King of Fruits'
//     },
//         {
//       name: 'Mango',
//       image: 'https://upload.wikimedia.org/wikipedia/commons/9/90/Hapus_Mango.jpg',
//       description: 'Mango is the King of Fruits'
//     }
    
//   ];
// }

//EX-5
// import { Component, Input } from '@angular/core';
// import { CommonModule } from '@angular/common';

// @Component({
//   selector: 'app-display-list',
//   standalone: true,
//   imports: [CommonModule],
//   templateUrl: './display-list.html',
//   styleUrls: ['./display-list.css']
// })
// export class DisplayList {
//   @Input() fruit: any;
// }


//EX-6
// import { Component, Input } from '@angular/core';
// import { CommonModule } from '@angular/common';
// import { IFruit } from '../ifruit';

// @Component({
//   selector: 'app-display-list',
//   standalone: true,
//   imports: [CommonModule],
//   templateUrl: './display-list.html',
//   styleUrls: ['./display-list.css']
// })
// export class DisplayList {
//   @Input() fruit!: IFruit;  // strict typing
// }


//EX-7
import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IFruit } from '../ifruit';

@Component({
  selector: 'app-display-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './display-list.html',
  styleUrls: ['./display-list.css']
})
export class DisplayList {
  @Input() fruit!: IFruit;

  @Output() remove = new EventEmitter<IFruit>();

  onRemove() {
    this.remove.emit(this.fruit);
  }
}
