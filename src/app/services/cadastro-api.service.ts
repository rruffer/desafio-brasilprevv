import { environment } from './../../environments/environment';
import { Cliente } from './../models/cliente';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CadastroApiService {

  //private url = 'http://localhost:8080/cadastro-beneficio/api/cadastro/';
  private url = environment.urlApi;

  constructor(private httpClient: HttpClient) { }

  /*public cadastrarBeneficiario(cliente: Cliente) {
    return this.httpClient.get(this.url).pipe(catchError(this.handleError));
    // return this.httpClient.post(this.url, cliente).pipe(catchError(this.handleError));
  }*/

  cadastrarBeneficiario(cliente: Cliente): Observable<any> {
    return this.httpClient.post(this.url, cliente, { observe: 'response', reportProgress: true });
  }

  consultarBeneficiario(cpf: string): Observable<any> {
    return this.httpClient.get(`${this.url}${cpf} `, { observe: 'response', reportProgress: true });
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error!';
    if (error.error instanceof ErrorEvent) {
      // Client-side errors
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Server-side errors
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    //window.alert(errorMessage);
    return throwError(errorMessage);
  }

}
