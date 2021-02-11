import { Injectable } from '@angular/core';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class MensagemService {

  constructor(private toastr: ToastrService) {

  }

  info(mensagem: string): void {
    this.toastr.info(mensagem, 'Informação');
  }
  sucesso(mensagem: string): void {
    this.toastr.success(mensagem, 'Sucesso');
  }
  alerta(mensagem: string): void {
    this.toastr.warning(mensagem, 'Alerta');
  }
  erro(mensagem: string): void {
    this.toastr.error(mensagem, 'Erro');
  }

}
