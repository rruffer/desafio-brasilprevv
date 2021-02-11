import { Cliente } from './../../models/cliente';
import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-modal-dados-cliente',
  templateUrl: './modal-dados-cliente.component.html',
  styleUrls: ['./modal-dados-cliente.component.scss']
})
export class ModalDadosClienteComponent implements OnInit {

  constructor(@Inject(MAT_DIALOG_DATA) public data: Cliente) { }

  ngOnInit() {
  }

}
