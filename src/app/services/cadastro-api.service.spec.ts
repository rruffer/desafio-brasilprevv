/* tslint:disable:no-unused-variable */

import { TestBed, async, inject } from '@angular/core/testing';
import { CadastroApiService } from './cadastro-api.service';

describe('Service: CadastroApi', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [CadastroApiService]
    });
  });

  it('should ...', inject([CadastroApiService], (service: CadastroApiService) => {
    expect(service).toBeTruthy();
  }));
});
