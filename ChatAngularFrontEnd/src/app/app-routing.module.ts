import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CodeSocketComponent } from './components/code-socket/code-socket.component';


const routes: Routes = [
  { path: '', component: CodeSocketComponent, pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
