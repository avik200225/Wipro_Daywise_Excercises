import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ITask } from '../itask';

@Component({
  selector: 'app-task',
  imports: [FormsModule],
  templateUrl: './task.html',
  styleUrl: './task.css',
})
export class Task {
  description = '';
  category = '';

  @Output() taskAdded = new EventEmitter<ITask>();

  addTask() {
    if (this.description && this.category) {
      const newTask: ITask = {
        description: this.description,
        category: this.category,
      };

      this.taskAdded.emit(newTask);

      this.description = '';
      this.category = '';
    }
  }
}