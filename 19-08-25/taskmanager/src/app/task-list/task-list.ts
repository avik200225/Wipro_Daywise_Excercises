import { Component, Input, Output, EventEmitter } from '@angular/core';
import { ITask } from '../itask';

@Component({
  selector: 'app-task-list',
  imports: [],
  templateUrl: './ex8task-list.html',
  styleUrl: './ex8task-list.css',
})
export class Ex8taskList {
  @Input() tasks: ITask[] = [];
  @Output() deleteTaskEvent = new EventEmitter<number>();

  deleteTask(id?: number) {
    if (id !== undefined) {
      this.deleteTaskEvent.emit(id);
    }
  }
}