import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { ErrorObservable } from 'rxjs/observable/ErrorObservable';
import 'rxjs/add/operator/map';
import 'rxjs/Rx';
import 'rxjs/add/operator/catch';
import { Message } from '../model/message';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SocketService {

  url: string = environment.url + "api/socket";

  private httpOptions = { headers: new HttpHeaders({ 'Content-Type': 'application/json'})};
  constructor(private http: HttpClient) { }

  post(data: Message) {
    return this.http.post(this.url, data)
      .map((data: Message) => { return data; })
      .catch(error => {
        return new ErrorObservable(error);
      });
  }

  createMessage(data: Message): Observable<any> {
    return this.http.post(this.url, data, this.httpOptions);
  }
}
