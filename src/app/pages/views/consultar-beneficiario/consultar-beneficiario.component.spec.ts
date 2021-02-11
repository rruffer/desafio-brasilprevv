import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultarBeneficiarioComponent } from './consultar-beneficiario.component';

describe('ConsultarBeneficiarioComponent', () => {
  let component: ConsultarBeneficiarioComponent;
  let fixture: ComponentFixture<ConsultarBeneficiarioComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultarBeneficiarioComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultarBeneficiarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
