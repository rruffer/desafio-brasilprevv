import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ToastrModule } from 'ngx-toastr';



@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    ToastrModule.forRoot({
      timeOut: 7000,
      closeButton: true,
      progressBar: true,
      positionClass: 'toast-top-right',
      preventDuplicates: true,
      resetTimeoutOnDuplicate: true,
      countDuplicates: false
    }), // ToastrModule added
  ],
  exports: [
    ToastrModule
  ]
})
export class ToastModule { }
