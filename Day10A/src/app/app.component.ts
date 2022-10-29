import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { DialogueComponent } from './dialogue/dialogue.component';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'Day10A';

  constructor(public dialogue: MatDialog) { }

  openDialogue() {
    const dialogueRef = this.dialogue.open(DialogueComponent);

    dialogueRef.afterClosed().subscribe(result => {
      console.log(`Dialogue result: ${result}`);
    });
  }
}
