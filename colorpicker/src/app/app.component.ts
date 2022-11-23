import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})


export class AppComponent implements OnInit {
  title = 'colorpicker';

  @Input() colorOptions: string[] | undefined;
  @Input() initialColor: string | undefined;
  selectedColor : string | undefined;

  ngOnInit(): void {
    this.selectedColor = this.initialColor;

  }

changeColor(color:string){
  this.selectedColor = color;

}

}