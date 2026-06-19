import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterOutlet],
  template: '<div class="p-4"><h1 class="text-2xl font-bold">Home Component</h1><router-outlet></router-outlet></div>',
  styles: []
})
export class HomeComponent {
}
