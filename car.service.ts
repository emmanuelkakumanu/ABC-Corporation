import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Accessories } from '../models-ts/Accessories';
import { Colors } from '../models-ts/Colors';
import { SaveDTO } from '../models-ts/SaveDTO';
import { UserAuthService } from './user-auth.service';
const carModelsurl = "http://localhost:9761/series-model-service/cars/series/models/getmodel";
@Injectable({
  providedIn: 'root'
})
export class CarService {
  private carseriesurl = "http://localhost:9761/series-model-service/cars";

  private caraccessoriesurl = "http://localhost:9761/accessory-service/accessories";
  private carcolorurl = "http://localhost:9761/color-service/colors";
  private orderurl = "http://localhost:9761/order-service";
  constructor(private http: HttpClient, private userAuthService: UserAuthService) { }

  getAllCarSeries(): Observable<any> {
    return this.http.get(this.carseriesurl + "/series");
  }
  getAllModelsBySeriesId(seriesId) {
    return this.http.get(carModelsurl + "/" + seriesId);
  }

  getAllAccessoriesByModelId(id) {
    return this.http.get<Accessories[]>(this.caraccessoriesurl + "/getaccessory/1");
  }

  getAllColorsByModelId(id) {
    return this.http.get<Colors[]>(this.carcolorurl + "/getcolors/1");
  }

  public saveOrder(requestData): Observable<any> {
    return this.http.post<SaveDTO[]>(this.orderurl + "/placeorder", requestData).pipe(map(
      (data: any) => {
        return data;
      }
    ))
  }
}
