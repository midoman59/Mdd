import { Routes } from '@angular/router';
import { authGuard } from './config/guards/auth.guard';

export const appRoutes: Routes = [
  {
    path: 'auth',
    loadChildren: () => import('./auth/auth.routes').then(m => m.authRoutes)
  },
  {
    path: 'home',
    canActivate: [authGuard],
    loadChildren: () => import('./home/home.routes').then(m => m.homeRoutes)
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: '**',
    loadComponent: () => import('./not-found/not-found.component').then(m => m.NotFoundComponent)
  }
];
