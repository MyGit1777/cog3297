import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginuserService } from '../loginuser.service';
import { Product } from '../product';

@Component({
  selector: 'app-view-products',
  templateUrl: './view-products.component.html',
  styleUrls: ['./view-products.component.css']
})
export class ViewProductsComponent implements OnInit {

  products: Array<Product> = [];
  constructor(private route: Router, private loginService: LoginuserService) { }
  ngOnInit(): void {
   if(this.loginService.isLoggedIn()){
    this.getProducts();   
   }else{

    this.route.navigate(['/home']);
   }
  }
  getProducts() {
    this.loginService.getAllProducts().subscribe(
      data => this.products = data, error => console.log("Exception occurred 1"),
    )
  }
  isEmpty()
  {
    if (this.products == null)
    {
      return true;
    }
    else { return false; }
  }
 
  goToAddProduct() {
    this.route.navigate(['/addProduct']);
  }
 
  updateProduct(id: number) {
    console.log("inside update product" + id);
    this.route.navigate(['/addProduct', id]);
    


  }
 
  goToViewProduct(id: number){
    this.route.navigate(['/viewSingleProduct', id]);
 
  }
 
  deleteProduct(productId: number) {
    if (confirm('Are you sure ?'))
  return this.loginService.deleteProductBdyId(productId).subscribe(success =>{
    this.getProducts();
     alert("Product deleted succesfully");
    },
    
    error=> {
    console.log("Exception occured 2"); 
   
    alert("Product deletion failed");

  }
   )
  }
 

}
