// import { Component } from '@angular/core';
// import { DisplayList } from '../display-list/display-list';

// @Component({
//   selector: 'app-home',
//   standalone: true,
//   imports: [DisplayList],
//   template: `
//     <div class="container">
//       <h2 class="text-center">Fruit List</h2>
//       <app-display-list></app-display-list>
//     </div>
//   `
// })
// export class HomeComponent {}


//EX-5
// import { Component } from '@angular/core';
// import { DisplayList } from '../display-list/display-list';
// import { IFruit } from '../ifruit';

// @Component({
//   selector: 'app-home',
//   standalone: true,
//   imports: [DisplayList],
//   templateUrl: './home.html',
//   styleUrls: ['./home.css']
// })
// export class HomeComponent {
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
//     }
//   ];

//EX-6
import { Component } from '@angular/core';
import { DisplayList } from '../display-list/display-list';
import { IFruit } from '../ifruit';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [DisplayList],
  templateUrl: './home.html',
  styleUrls: ['./home.css']
})
export class HomeComponent {
  fruits: IFruit[] = [
    {
      name: 'Apple',
      image: 'https://upload.wikimedia.org/wikipedia/commons/1/15/Red_Apple.jpg',
      description: 'Apple Keeps Doctors Away.'
    },
    {
      name: 'Orange',
      image: 'https://upload.wikimedia.org/wikipedia/commons/c/c4/Orange-Fruit-Pieces.jpg',
      description: 'Orange Image.'
    },
    {
      name: 'Banana',
      image: 'https://upload.wikimedia.org/wikipedia/commons/8/8a/Banana-Single.jpg',
      description: 'Banana Image.'
    },
    {
      name: 'Mango',
      image: 'https://upload.wikimedia.org/wikipedia/commons/9/90/Hapus_Mango.jpg',
      description: 'Mango is the King of Fruits'
    }
  ];

  //EX-7
   removeFruit(fruit: IFruit) {
    this.fruits = this.fruits.filter(f => f !== fruit);
  }
}
