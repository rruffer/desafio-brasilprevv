import { ConsultarBeneficiarioComponent } from './pages/views/consultar-beneficiario/consultar-beneficiario.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { MainComponent } from './pages/main/main.component';
import { CadastroBeneficiarioComponent } from './pages/views/cadastro-beneficiario/cadastro-beneficiario.component';

const routes: Routes = [
  {
    path: '',
    component: MainComponent,
    //
    //canActivate: [AuthGuard],
    //canActivateChild: [AuthGuard],
    children: [
      {
        path: '',
        component: CadastroBeneficiarioComponent,
      },
      {
        path: 'consulta',
        component: ConsultarBeneficiarioComponent,
      }
    ],
  },
  {
    path: 'login',
    component: LoginComponent,
    //canActivate: [NonAuthGuard],
  },
  /*{
    path: 'register',
    //component: RegisterComponent,
    //canActivate: [NonAuthGuard],
  },*/
  { path: '**', redirectTo: '' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
