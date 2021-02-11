import { HttpErrorResponse } from '@angular/common/http';
import { ModalService } from '../../../services/modal-service';
import { MensagemService } from './../../../services/mensagem.service';
import { Cliente } from './../../../models/cliente';
import { CadastroApiService } from './../../../services/cadastro-api.service';
import { Validacao } from './../../../models/validacao';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-cadastro-beneficiario',
  templateUrl: './cadastro-beneficiario.component.html',
  styleUrls: ['./cadastro-beneficiario.component.scss']
})
export class CadastroBeneficiarioComponent implements OnInit {

  form: FormGroup;
  cliente: Cliente;


  constructor(
    private formBuilder: FormBuilder,
    private mensagemService: MensagemService,
    private modalService: ModalService,
    private cadastroApiService: CadastroApiService) { }

  ngOnInit() {

    this.form = this.formBuilder.group({
      nome: [null, { validators: [Validators.required], updateOn: "change" }],
      cpf: [null, { validators: [Validators.required, Validacao.ValidaCpf], updateOn: "change" }],
      email: [null, { validators: [Validators.required, Validators.email], updateOn: "change" }],
      totalSaldoAposentadoria: [null, { validators: [Validators.required], updateOn: "change" }],
      qtdAnosAposentadoria: [null, { validators: [Validators.required], updateOn: "change" }],
    });

    this.cliente = new Cliente();

  }

  onSubmit(): void {
    if (this.form.valid) {

      //this.modalService.progress();

      try {
        this.cadastroApiService.cadastrarBeneficiario(this.cliente).subscribe(
          (response: Response) => {
            console.log(response);
            //this.cliente = new Cliente();

            this.form.reset();

            Object.keys(this.form.controls).forEach(key => {
              this.form.controls[key].setErrors(null)
            });

            this.mensagemService.sucesso('Cliente salvo com sucesso!');

          },
          (error: HttpErrorResponse) => {

            if (error.status === 420) {
              this.mensagemService.alerta('Cliente já está cadastrado!');
              return;
            }

            this.mensagemService.erro('Ocorreu um erro ao salvar cliente!');
          }
        );
      } catch (error) {
        this.mensagemService.erro('Ocorreu um erro ao salvar cliente!');
      }
    }
  }

}
