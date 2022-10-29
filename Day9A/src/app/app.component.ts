import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title0 = 'Day9A';
  //Interpolation binding
  public name = "Marc D"
// Property binding
  image = "/assets/images/Image.png"

  //Event binding 
  onClick(){

   alert("You are genius!!");
    
  }
  // Two way binding
  public userInput = ""

  // Directives

  // There are three kinds of directives in Angular:

  // Component Directive:

  // Structural directives(like for loop, if elase & switch):
   //ngFor, ngSwitch, ngIf
  // Attribute directives(for behaviur & CCS):
      // ngModel, ngClass and ngStyle
  

  title: string = 'Movies to watch';

  movies: Movie[] = [
    {
      title: 'Zootopia',
      director: 'Byron Howard, Rich Moore',
      cast: 'Idris Elba, Ginnifer Goodwin, Jason Bateman',
      releaseDate: 'March 4, 2016',
    },
    {
      title: 'Batman v Superman: Dawn of Justice',
      director: 'Zack Snyder',
      cast: 'Ben Affleck, Henry Cavill, Amy Adams',
      releaseDate: 'March 25, 2016',
    },
    {
      title: 'Captain American: Civil War',
      director: 'Anthony Russo, Joe Russo',
      cast: 'Scarlett Johansson, Elizabeth Olsen, Chris Evans',
      releaseDate: 'May 6, 2016',
    },
    {
      title: 'X-Men: Apocalypse',
      director: 'Bryan Singer',
      cast: 'Jennifer Lawrence, Olivia Munn, Oscar Isaac',
      releaseDate: 'May 27, 2016',
    },
    {
      title: 'Warcraft',
      director: 'Duncan Jones',
      cast: 'Travis Fimmel, Robert Kazinsky, Ben Foster',
      releaseDate: 'June 10, 2016',
    },
  ];

  isActive(): boolean{
  return true;

  }
  
}
class Movie {
  title : string | undefined;
  director : string | undefined;
  cast : string | undefined;
  releaseDate : string | undefined;
}