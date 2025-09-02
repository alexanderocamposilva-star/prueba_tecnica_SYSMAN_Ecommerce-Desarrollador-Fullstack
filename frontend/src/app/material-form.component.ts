import { Component } from '@angular/core';
import { MaterialService } from './material.service';
import { AuthService } from './auth.service';

@Component({
  selector: 'app-material-form',
  template: `
  <div style="margin-bottom:20px;">
    <h3>Login (demo)</h3>
    <input [(ngModel)]="user" placeholder="username" />
    <input [(ngModel)]="pass" placeholder="password" type="password" />
    <button (click)="login()">Login</button>
    <div *ngIf="authMsg">{{authMsg}}</div>
  </div>

  <div>
    <h3>Crear Material</h3>
    <form (submit)="onSubmit(); $event.preventDefault()">
      <input [(ngModel)]="payload.nombre" name="nombre" placeholder="Nombre" required />
      <input [(ngModel)]="payload.tipo" name="tipo" placeholder="Tipo" />
      <input [(ngModel)]="payload.precio" name="precio" placeholder="Precio" />
      <input [(ngModel)]="payload.fechaCompra" name="fechaCompra" placeholder="Fecha Compra (YYYY-MM-DD)" />
      <input [(ngModel)]="payload.fechaVenta" name="fechaVenta" placeholder="Fecha Venta (YYYY-MM-DD)" />
      <input [(ngModel)]="payload.ciudadId" name="ciudadId" placeholder="CiudadId" />
      <button type="submit">Crear</button>
    </form>
    <div *ngIf="message">{{message}}</div>
  </div>
  `
})
export class MaterialFormComponent {
  payload: any = { nombre: '', tipo: '', precio: null, fechaCompra: '', fechaVenta: '', ciudadId: 1 };
  message = '';
  user = 'admin';
  pass = 'password';
  authMsg = '';
  constructor(private svc: MaterialService, private auth: AuthService) {}
  login() {
    this.auth.login(this.user, this.pass).subscribe({
      next: (res:any) => {
        const token = res.data?.token;
        if (token) {
          this.auth.setToken(token);
          this.authMsg = 'Login exitoso';
        } else { this.authMsg = 'Respuesta sin token'; }
      },
      error: (err:any) => this.authMsg = err.error?.message || 'Error login'
    });
  }
  onSubmit() {
    const body = {
      nombre: this.payload.nombre,
      tipo: this.payload.tipo,
      precio: this.payload.precio ? Number(this.payload.precio) : null,
      fechaCompra: this.payload.fechaCompra ? this.payload.fechaCompra : null,
      fechaVenta: this.payload.fechaVenta ? this.payload.fechaVenta : null,
      estado: 'disponible',
      ciudadId: Number(this.payload.ciudadId)
    };
    this.svc.create(body).subscribe({
      next: (res:any) => this.message = res.message,
      error: (err:any) => this.message = err.error?.message || 'Error'
    });
  }
}
