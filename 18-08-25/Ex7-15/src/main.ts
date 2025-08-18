import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import { Condicomp } from './app/condicomp/condicomp';
import { Switchdemo } from './app/switchdemo/switchdemo';
import { Listsearchcomp } from './app/listsearchcomp/listsearchcomp';
import { Home } from './app/home/home';

bootstrapApplication(Home, appConfig)
  .catch((err) => console.error(err));
