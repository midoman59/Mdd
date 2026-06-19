import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-not-found',
  standalone: true,
  imports: [RouterLink],
  template: `
    <div class="flex items-center justify-center min-h-screen">
      <div class="text-center">
        <h1 class="text-4xl font-bold">404</h1>
        <p class="text-xl mt-4">Page not found</p>
        <a routerLink="/home" class="mt-4 text-blue-500 underline">Go back home</a>
      </div>
    </div>
  `,
  styles: []
})
export class NotFoundComponent {
}
