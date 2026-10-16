
import { HttpClient } from '@angular/common/http';
import { Component, inject } from '@angular/core';
import { AsyncPipe } from '@angular/common';
import { Account, AccountListState, RequestStatus } from '../model/account.model';
import { LoadingService } from '../services/loading';
import { Observable } from 'rxjs';
import { map, catchError } from 'rxjs';
import { of } from 'rxjs';

@Component({
  selector: 'app-accounts',
  imports: [AsyncPipe],
  templateUrl: './accounts.html',
  styleUrl: './accounts.css',
})
export class Accounts {
  protected readonly RequestStatus = RequestStatus;

  private http = inject(HttpClient);

  public loadService=inject(LoadingService);

  


  accounts$: Observable<AccountListState> = this.http
    .get<Account[]>('http://localhost:9999/EBANK-SERVICE/accounts')
    .pipe(
      map(resp => ({
        accounts: resp,
        status: RequestStatus.SUCCESS
      })),
      catchError(err =>
        of({
          status: RequestStatus.ERROR,
          errorMessage: err.statusText
        })
      )
    );
}
