import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { LoginuserService } from '../loginuser.service';
import { Product } from '../product';
import { User } from '../user';

@Component({
  selector: 'app-viewsingleproduct',
  templateUrl: './viewsingleproduct.component.html',
  styleUrls: ['./viewsingleproduct.component.css']
})
export class ViewsingleproductComponent implements OnInit {
  product: Product = new Product(); 
  productId: any;
  constructor(private router: Router, private actroute: ActivatedRoute, private loginService: LoginuserService) { }

  ngOnInit(): void {
    this.product = new Product();

    this.productId = this.actroute.snapshot.params['id'];
    
    this.loginService.getProductById(this.productId)
      .subscribe(data => {
        console.log(data)
        this.product = data;
      }, error => console.log(error));

  }

  gotolist(){

    this.router.navigate(['viewProducts']);
  }

}
