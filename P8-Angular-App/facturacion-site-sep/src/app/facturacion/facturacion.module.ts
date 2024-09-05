import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FacturacionRoutingModule } from './facturacion-routing.module';
import { FacturacionComponent } from './facturacion.component';
import { CrearClienteComponent } from './components/crear-cliente/crear-cliente.component';


@NgModule({
  declarations: [
    FacturacionComponent,
    CrearClienteComponent
  ],
  imports: [
    CommonModule,
    FacturacionRoutingModule
  ]
})
export class FacturacionModule { }
