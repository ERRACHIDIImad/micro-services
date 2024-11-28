import {
  ActivatedRouteSnapshot,
  CanActivate,
  GuardResult,
  MaybeAsync,
  Router,
  RouterStateSnapshot
} from '@angular/router';
import {Injectable} from "@angular/core";
import {AuthentificationService} from "../services/authentification.service";

@Injectable()
export class authGuard implements CanActivate{

  constructor(public authService  : AuthentificationService,public router: Router){}
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
    if(this.authService.getUsername())return true;
    else{

      this.router.navigateByUrl("login");
      return false;
    }
  }
}
