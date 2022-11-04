import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Book } from '../book';
import { LoginserviceService } from '../services/loginservice.service';

@Component({
  selector: 'app-view-all-books',
  templateUrl: './view-all-books.component.html',
  styleUrls: ['./view-all-books.component.css']
})
export class ViewAllBooksComponent implements OnInit {
  public loggedIn = false;
  user: any;


  allBooks: Array<Book> = [];
  book= new Book();
  constructor(private route: Router, private actRoute: ActivatedRoute ,private loginService: LoginserviceService) { 
    console.log("this is arrived in service "+history.state.bookTitle);
    this.book= history.state;
  }
  // ngOnInit(): void {
  //  if(this.loginService.isLoggedIn()){
  //   this.getBooks();   
  //  }else{

  //   this.route.navigate(['/home']);
  //  }
  // }

  
  

  ngOnInit(): void {
    
    this.loggedIn = this.loginService.isLoggedIn();
    this.user = localStorage.getItem("user");

    //this.book = this.actRoute.snapshot.params['book'];
    console.log(" book in init"+this.book.authorId)
    if(this.book.bookTitle || this.book.author || this.book.publisher){

      this.loginService.getAllBooks(this.book).subscribe(data => {
        console.log(data)
        this.allBooks = data;
      }, error => console.log(error));
  
    }else{
      this.book= new Book();
      this.book.createdBy =this.user;
      console.log("bookk by"+this.book)
      this.loginService.getAllBooks(this.book).subscribe(data => {
        console.log(data)
        this.allBooks = data;
      }, error => console.log(error));
      
    }
}
  
  isEmpty()
  {
    if (this.allBooks == null)
    {
      return true;
    }
    else { return false; }
  }
 
  goToAddBook() {
    this.route.navigate(['/home']);
  }
 
  updateBook(id: number) {
    console.log("inside update book" + id);
    this.route.navigate(['/addBook', id]);
  }
 
  goToViewBook(id: number){
    this.route.navigate(['/viewBook', id]);
 
  }
 
  // deleteBook(authorId: number) {
  //   if (confirm('Are you sure ?'))
  // return this.loginservice.deleteBookBdyId(authorId).subscribe(success =>{
  //   this.getBooks();
  //    alert("Book deleted succesfully");
  //   },
    
  //   error=> {
  //   console.log("Exception occured 2"); 
   
  //   alert("Book deletion failed");

  // }
  //  )
  // }

}
