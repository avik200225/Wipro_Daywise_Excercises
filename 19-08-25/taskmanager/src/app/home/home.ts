import { Component } from '@angular/core';
import { Ex8taskList } from '../task-list/task-list';
import { ITask } from '../itask';
import { Task } from '../task/task';

@Component({
  selector: 'app-home',
  imports: [Ex8taskList, Task],
  templateUrl: './home.html',
  styleUrl: './home.css',
})
export class Home {
  tasks: ITask[] = [];
  uniqueId = 1;

  addTask(task: ITask) {
    const newTask: ITask = {
      id: this.uniqueId++,
      ...task,
    };
    this.tasks.push(newTask);
  }

  deleteTask(id?: number) {
    if (id !== undefined) {
      this.tasks = this.tasks.filter((task) => task.id !== id);
    }
  }
}