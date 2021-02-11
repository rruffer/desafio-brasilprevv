import { HttpProgressInterceptor } from './interceptors/http-progress-interceptor';
import { ToastModule } from './modules/toast-module';
import { MaskModule } from './modules/mask.module';
import { FooterComponent } from './pages/main/footer/footer.component';
import { HeaderComponent } from './pages/main/header/header.component';
import { MainComponent } from './pages/main/main.component';
import { CadastroBeneficiarioComponent } from './pages/views/cadastro-beneficiario/cadastro-beneficiario.component';
import { MaterialModule } from './modules/material.module';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ReactiveFormsModule } from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ModalProgressComponent } from './components/modal-progress/modal-progress.component';
import { ConsultarBeneficiarioComponent } from './pages/views/consultar-beneficiario/consultar-beneficiario.component';
import { ModalDadosClienteComponent } from './components/modal-dados-cliente/modal-dados-cliente.component';

@NgModule({
  declarations: [
    AppComponent,
    CadastroBeneficiarioComponent,
    MainComponent,
    HeaderComponent,
    FooterComponent,
    ConsultarBeneficiarioComponent,
    ModalProgressComponent,
    ModalDadosClienteComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MaterialModule,
    FlexLayoutModule,
    MaskModule,
    ToastModule
  ],
  entryComponents: [
    ModalProgressComponent,
    ModalDadosClienteComponent
  ],
  providers: [{ provide: HTTP_INTERCEPTORS, useClass: HttpProgressInterceptor, multi: true },],
  bootstrap: [AppComponent]
})
export class AppModule { }
