import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginuserService } from '../loginuser.service';
import { Product } from '../product';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css']
})
export class AddProductsComponent implements OnInit {

  product = new Product();
  constructor(private route: Router, private actRoute: ActivatedRoute ,private loginService: LoginuserService) { }

  ngOnInit(): void {

    this.product = new Product();

    this.product.productId = this.actRoute.snapshot.params['id'];
    this.loginService.getProductById(this.product.productId).subscribe(data => {
      console.log(data)
      this.product = data;
    }, error => console.log(error));

}
    // this.loginService.updateProduct(this.product.productId)
    //   .subscribe(data => {
    //     console.log(data)
    //     this.product = data;
    //   }, error => console.log(error));

  
  addProductSubmit()
  {
  this.loginService.addProduct(this.product).subscribe
  (
    data =>{
      console.log("Data added successfully");
      this.route.navigate(['viewProducts']);
    },
    error =>console.log("Error")
  )
  }   
    gotolist() {
      this.route.navigate(['viewProducts']);
    }
}
