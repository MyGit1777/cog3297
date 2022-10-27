import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-dialogue',
  templateUrl: './dialogue.component.html',
  styleUrls: ['./dialogue.component.scss']
})
export class DialogueComponent implements OnInit {

  status: string[] = ['Active', 'Inactive'];
  fruitForm!: FormGroup;

  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {

    this.fruitForm = this.formBuilder.group({
      fruitName: ['', Validators.required],
      fruitCategory: ['', Validators.required],
      fruitAvailableDate: ['', Validators.required],
      fruitStatus: ['', Validators.required],
      fruitPrice: ['', Validators.required],
      comments: []
    })

  }
  addFruit() {
    console.log(this.fruitForm.value)
  }

}
