import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-listsearchcomp',
  standalone: true,                   
  imports: [FormsModule],             
  templateUrl: './listsearchcomp.html',
  styleUrls: ['./listsearchcomp.css'] 
})
export class Listsearchcomp {
  searchText: string = '';

  names: string[] = [
    'Jayanta',
    'Jayaram',
    'Rahul',
    'Amit',
    'Sanjay',
    'Priya'
  ];

  get filteredNames(): string[] {
    return this.names.filter(name =>
        name.toLowerCase().startsWith(this.searchText.toLowerCase())
    );
  }
}
