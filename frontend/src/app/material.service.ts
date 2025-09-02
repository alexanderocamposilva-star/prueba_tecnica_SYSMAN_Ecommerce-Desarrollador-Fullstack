import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
@Injectable({ providedIn: 'root' })
export class MaterialService {
  private base = '/api/materials';
  constructor(private http: HttpClient) {}
  getAll() { return this.http.get<any>(this.base); }
  getByTipo(tipo: string) { return this.http.get<any>(this.base + '?tipo=' + tipo); }
  getByFechaCompra(fecha: string) { return this.http.get<any>(this.base + '?fechaCompra=' + fecha); }
  getByCity(cityId: number) { return this.http.get<any>(this.base + '/city/' + cityId); }
  create(payload: any) { return this.http.post<any>(this.base, payload); }
  update(id: number, payload: any) { return this.http.put<any>(this.base + '/' + id, payload); }
}
