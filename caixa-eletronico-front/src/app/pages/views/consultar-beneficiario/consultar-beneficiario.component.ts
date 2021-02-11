import { ModalService } from './../../../services/modal-service';
import { HttpErrorResponse } from '@angular/common/http';
import { Validacao } from './../../../models/validacao';
import { CadastroApiService } from './../../../services/cadastro-api.service';
import { MensagemService } from './../../../services/mensagem.service';
import { Cliente } from './../../../models/cliente';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-consultar-beneficiario',
  templateUrl: './consultar-beneficiario.component.html',
  styleUrls: ['./consultar-beneficiario.component.scss']
})
export class ConsultarBeneficiarioComponent implements OnInit {

  form: FormGroup;
  cpf: string;


  constructor(
    private formBuilder: FormBuilder,
    private mensagemService: MensagemService,
    private modalService: ModalService,
    private cadastroApiService: CadastroApiService) { }

  ngOnInit() {

    this.form = this.formBuilder.group({
      cpf: [null, { validators: [Validators.required, Validacao.ValidaCpf], updateOn: "change" }]
    });

  }

  onSubmit(): void {
    if (this.form.valid) {

      this.cadastroApiService.consultarBeneficiario(this.cpf).subscribe(
        response => {
          console.log(response);
          this.modalService.infoCliente(response.body);
          //this.mensagemService.sucesso('Cliente salvo com sucesso!');
        },
        (error: HttpErrorResponse) => {

          if (error.status === 404) {
            this.mensagemService.alerta('Cliente não cadastrado');
          } else {
            console.log(error)
            this.mensagemService.erro('Ocorreu um erro ao consultar cliente!');
          }

        }
      );
    }
  }


}
