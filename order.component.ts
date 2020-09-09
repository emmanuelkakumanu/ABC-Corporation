import { Component, OnInit } from '@angular/core';
import { CarSeries } from '../models-ts/CarSeries';
import { CarModels } from '../models-ts/CarModels';
import { Accessories } from '../models-ts/Accessories';
import { Colors } from '../models-ts/Colors';
import { CarService } from '../services/car.service';
import { Router } from '@angular/router';
import { Converter } from '../services/Converter';
import { SaveDTO } from '../models-ts/SaveDTO';
import { FormGroup } from '@angular/forms';

//<div *ngFor="let color of colorsList">
  //                  <input type="checkbox" name="{{color.colorId}}" [value]="color.colorId">{{color.colorName}}
    //            </div>


@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orderForm: FormGroup;
  accessorySum: number;
  modelAmount: number;
  grandTotal: number;

  seriesList: CarSeries[];
  modelList: CarModels[];
  accessoriesList: Accessories[];
  colorsList: Colors[];

  accessoriesDropdownSettings = {};
  colorsDropdownSettings = {};

  selectedSeriesId: any;
  selectedModelId: any;

  selectedItems1 = [];
  selectedItems2 = [];

 // public accessoryList: Accessories[] = [];
 // public colorList: Colors[] = [];

  seriesId: number;
  modelId: number;

  //separate array

  public AccessoryIdList = [];
  public colorIdList = [];

  public accyObj = [];
  public arrayAccessories = [];
  public colorObj = [];
  public arrayColors = [];


  success: string;
  AccessoryPrice: number;
  ColorPrice: any;
  ModelPrice: any;

  colorPrice1: number = 0;
  modelPrice1: number = 0;
  totalPrice: number = 0;
  accessPrice1: number = 0;
  isDeSelectedAccessory: boolean;
  isDeselectedColor: boolean;

  constructor(private carService: CarService, private router: Router) { }

  ngOnInit() {
    this.accessoriesDropdownSettings = {
      singleSelection: false,
      idField: 'accessoryId',
      textField: 'accessoryName',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      enableCheckAll: false,
      itemsShowLimit: 3,
      allowSearchFilter: true
    };
    this.colorsDropdownSettings = {
      singleSelection: false,
      idField: 'colorId',
      textField: 'colorName',
      selectAllText: 'Select All',
      unSelectAllText: 'UnSelect All',
      enableCheckAll: false,
      itemsShowLimit: 3,
      allowSearchFilter: true

    };

    this.getCarSeries();
  }
  //get car series
  getCarSeries() {
    this.carService.getAllCarSeries().subscribe((data: CarSeries[]) => {
      this.seriesList = data;
    });
  }
  public getSeriesId(event: any) {
    this.selectedSeriesId = event.target.value;
    this.getCarModels();
  }

  getCarModels() {
    this.carService.getAllModelsBySeriesId(this.selectedSeriesId).subscribe((data: CarModels[]) => {
      this.modelList = data;      
    });
  }

  //get modell id
  public getModelId(event: any) {
    this.selectedModelId = event.target.value;
    var convertedModelId = Number(this.selectedModelId);
    for (var i = 0; i < this.modelList.length; i++) {
      if (this.modelList[i].modelId === convertedModelId) {
        this.modelPrice1 = this.modelList[i].modelPrice;
      }
    }
    this.calculateTotalPrice();
    this.getCarColors();
    this.getCarAccessories();
  }

  //get car accessories
  getCarAccessories() {
    this.carService.getAllAccessoriesByModelId(this.selectedModelId).subscribe((data: Accessories[]) => {
      this.accessoriesList = data;
    });
  }

  //get colors
  getCarColors() {
    this.carService.getAllColorsByModelId(this.selectedModelId).subscribe((data: Colors[]) => {
      this.colorsList = data;
    });
  }

  //get selected accessories
  onAccessSelect(event: any) {
    this.accyObj = event;
    this.arrayAccessories = Converter.convertObjectToArray(event);
    this.setAccessoryDto();
    this.accessPriceCalculation(this.arrayAccessories[0].accessoryId);
  }

  //Deselect accessories
  onAccessDeSelect(event: any) {
    this.accyObj = event;
    this.isDeSelectedAccessory = true;
    this.arrayAccessories = Converter.convertObjectToArray(event);
    this.setAccessoryDto();
    this.accessPriceDeCalculation(this.arrayAccessories[0].accessoryId);
    return this.arrayAccessories;
  }

  //Trasfer selected accessory to List
  setAccessoryDto() {
    if (this.isDeSelectedAccessory) {
      const index = this.AccessoryIdList.indexOf(this.accyObj);
      this.AccessoryIdList.splice(index, 1);
    }
    else {
      this.AccessoryIdList.push(this.accyObj);
    }
  }

  //calculate accessory price
  accessPriceCalculation(aid: number) {
    for (var i = 0; i < this.accessoriesList.length; i++) {
      if (this.accessoriesList[i].accessoryId == aid) {
        this.accessPrice1 = this.accessPrice1 + this.accessoriesList[i].accessoryPrice;
      }
      else {
      }
    }
    this.calculateTotalPrice();
  }

  //decalculate accessory price
  accessPriceDeCalculation(aid: number) {
    for (var i = 0; i < this.accessoriesList.length; i++) {
      if (this.accessoriesList[i].accessoryId == aid) {
        const index = this.AccessoryIdList.indexOf(aid);
        this.accessPrice1 = this.accessPrice1 - this.accessoriesList[i].accessoryPrice;
      }
    }
    this.calculateTotalPrice();
  }

  //get selected color
  onColorSelect(event: any) {
    // console.log('Selectcolor',item);
    //console.log(item);
    this.colorObj = event;
    console.log('onSelectColorItem', event);
    this.arrayColors = Converter.convertObjectToArray(event);
    this.setColorDto();
    //console.log('colorselect',colorSelect[0].colors_id);1
    this.colorPriceCalculation(this.arrayColors[0].colorId);
    this.calculateTotalPrice();
    return this.arrayColors;
  }

  //deselect selected color
  onColorDeSelect(event: any) {
    // console.log('deSelectcolor',item);
    console.log('onDeSelectnumber', event);
    this.arrayColors = Converter.convertObjectToArray(event);
    this.isDeselectedColor = true;
    this.setColorDto();
    this.colorPriceDeCalculation(this.arrayColors[0].colorId);
    return this.arrayColors;
  }

  //transfer colors to colors List
  setColorDto() {
    if (this.isDeselectedColor) {
      let index = this.colorIdList.indexOf(this.colorObj);
      this.colorIdList.splice(index, 1);
    }
    else {
      this.colorIdList.push(this.colorObj);
    }
    console.log(this.colorIdList);
  }

  //calculate color price calculation
  colorPriceCalculation(cid: number) {
    for (var i = 0; i < this.colorsList.length; i++) {
      if (this.colorsList[i].colorId == cid) {
        this.colorPrice1 = this.colorPrice1 + this.colorsList[i].colorPrice;
        console.log(this.colorPrice1);
      }
    }
    this.calculateTotalPrice();
  }

  //decalculate color price
  colorPriceDeCalculation(cid: number) {
    for (var i = 0; i < this.colorsList.length; i++) {
      if (this.colorsList[i].colorId == cid) {
        const index = this.colorIdList.indexOf(cid);
        this.colorPrice1 = this.colorPrice1 - this.colorsList[i].colorPrice;
        console.log(this.colorPrice1);
      }
    }
    this.calculateTotalPrice();
  }

  //calculate total price
  calculateTotalPrice() {
    this.totalPrice = this.modelPrice1 + this.accessPrice1 + this.colorPrice1;
  }
  resetFunction() {
    location.reload();
  }
  onSubmit() {
    this.calculateTotalPrice();
    let rp = new SaveDTO();
    rp.seriesId = this.seriesId;
    rp.modelId = this.selectedModelId;
    rp.price = this.totalPrice;
    rp.accessoriesSelected = this.AccessoryIdList;
    rp.colorsSelected = this.colorIdList;
    console.log(rp);
    console.log('price:', this.totalPrice);
    this.carService.saveOrder(rp).subscribe(data => {
      console.log(data);
    })
    this.success = "Your Order has been Created Successfully";
    console.log(this.success);
  }
}