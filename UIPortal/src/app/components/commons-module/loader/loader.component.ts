import { Component, OnInit, Input } from '@angular/core';
import { Subject } from 'rxjs/internal/Subject';
import { LoaderService } from 'src/app/services/Loader.service';

@Component({
  selector: 'app-loader',
  templateUrl: './loader.component.html',
  styleUrls: ['./loader.component.css']
})
export class LoaderComponent implements OnInit {
  @Input() color = 'primary';
  @Input() mode = 'indeterminate';
  @Input() value = 50;
  isLoading: Subject<boolean> = this.loaderService.isLoading;

  constructor(private loaderService: LoaderService) { }

  ngOnInit() {
  }

}
