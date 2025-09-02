import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class AuthService {
  private base = '/auth';
  token: string | null = null;
  constructor(private http: HttpClient) {}
  login(username: string, password: string) {
    return this.http.post<any>(this.base + '/login', { username, password });
  }
  setToken(t: string) { this.token = t; localStorage.setItem('token', t); }
  getToken() { return this.token || localStorage.getItem('token'); }
}
