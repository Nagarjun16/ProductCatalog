import { Component, OnInit, Input, AfterViewInit } from '@angular/core';
import { Subject } from 'rxjs/internal/Subject';
import { LoaderService } from 'src/app/services/Loader.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.css']
})
export class LoaderComponent implements OnInit, AfterViewInit {
  @Input() color = 'primary';
  @Input() mode = 'indeterminate';
  @Input() value = 50;

  // tslint:disable-next-line: variable-name
  _isLoading = false;
  loadingSubscription: Subscription;

  constructor(private loaderService: LoaderService) { }

  ngOnInit() {
  }

  ngAfterViewInit(){
    this.loadingSubscription = this.loaderService.isLoading.subscribe((value=>{
      this.isLoading = value;
    }));
  }

  get isLoading(): boolean{
    return this._isLoading;
  }

  set isLoading(value) {
    this._isLoading = value;
  }

}
