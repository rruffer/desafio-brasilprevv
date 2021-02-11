import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { IConfig, NgxMaskModule } from 'ngx-mask';

export const options: Partial<IConfig> | (() => Partial<IConfig>) = {};

@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    NgxMaskModule.forRoot(options)
  ],
  exports: [
    NgxMaskModule
  ]
})
export class MaskModule { }
