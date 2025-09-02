import { Component, OnInit } from '@angular/core';
import { MaterialService } from './material.service';

@Component({
  selector: 'app-material-list',
  template: `
  <div>
    <h2>Materiales</h2>
    <div *ngIf="message">{{message}}</div>
    <ul>
      <li *ngFor="let m of materiales">{{m.nombre}} - {{m.tipo}} - {{m.ciudadNombre}}</li>
    </ul>
  </div>
  `
})
export class MaterialListComponent implements OnInit {
  materiales: any[] = [];
  message = '';
  constructor(private svc: MaterialService) {}
  ngOnInit() {
    this.svc.getAll().subscribe({
      next: (res: any) => { this.materiales = res.data; this.message = res.message; },
      error: (err: any) => { this.message = err.error?.message || 'Error'; }
    });
  }
}
