import { ModalProgressComponent } from './../components/modal-progress/modal-progress.component';
import { ModalService } from '../services/modal-service';
import { HttpEvent, HttpEventType, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { MatDialogRef } from '@angular/material/dialog';


@Injectable()
export class HttpProgressInterceptor implements HttpInterceptor {

  private modalProgress: MatDialogRef<ModalProgressComponent>

  constructor(
    private modalService: ModalService
    //private spinnerService: SpinnerService // my personal service for the progress bar - replace with your own
  ) {}

  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    if (req.reportProgress) {
      // only intercept when the request is configured to report its progress
      this.modalProgress =  this.modalService.progress();
      return next.handle(req).pipe(
        tap((event: HttpEvent<any>) => {
          if (event.type === HttpEventType.DownloadProgress) {
            // here we get the updated progress values, call your service or what ever here
            //this.spinnerService.updateGlobalProgress(Math.round(event.loaded / event.total * 100)); // display & update progress bar

          } else if (event.type === HttpEventType.Response) {
            //this.spinnerService.updateGlobalProgress(null); // hide progress bar
            this.closeModalProgress();
          }
        }, error => {
          this.closeModalProgress();
          //this.spinnerService.updateGlobalProgress(null); // hide progress bar
        })
      );
    } else {
      return next.handle(req);
    }
  }

  private closeModalProgress(): void {
    this.modalProgress.close();
    this.modalProgress = null;
  }

}
