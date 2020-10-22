import { AdmModule } from './adm/adm.module';
import { CategoriaListComponent } from './adm/categoria/categoria-list/categoria-list.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { CategoriaFormComponent } from './adm/categoria/categoria-form/categoria-form.component';

import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
<<<<<<< HEAD
import { ToastrService } from 'ngx-toastr';
=======
import { SharedModule } from './shared/shared.module';
>>>>>>> 00c56041252ec62375fa5e91a059ca660943bad5


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AdmModule,
    BrowserAnimationsModule,
    HttpClientModule,
    AppRoutingModule,
    SharedModule,
    FormsModule,
    RouterModule,
    HttpClientModule,

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
