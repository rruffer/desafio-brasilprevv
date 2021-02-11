import { Cliente } from './../models/cliente';
import { ModalProgressComponent } from '../components/modal-progress/modal-progress.component';
import { Injectable } from '@angular/core';
import { MatDialog, MatDialogRef } from '@angular/material/dialog';
import { ModalDadosClienteComponent } from '../components/modal-dados-cliente/modal-dados-cliente.component';

@Injectable({
  providedIn: 'root'
})
export class ModalService {

constructor(private dialog: MatDialog) { }

progress(): MatDialogRef<ModalProgressComponent> {
  return this.dialog.open(ModalProgressComponent);
}

infoCliente(cliente: Cliente): void {
  this.dialog.open(ModalDadosClienteComponent, {
    data: cliente
  });
}

}
