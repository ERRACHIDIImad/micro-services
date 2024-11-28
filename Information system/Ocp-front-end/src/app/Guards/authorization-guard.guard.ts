import {
  ActivatedRouteSnapshot,
  CanActivate,
  GuardResult,
  MaybeAsync,
  Router,
  RouterStateSnapshot
} from '@angular/router';
import {AuthentificationService} from "../services/authentification.service";
import {Injectable} from "@angular/core";

@Injectable()
export class authorizationGuardGuard implements CanActivate{
constructor(public authService  : AuthentificationService,public router: Router){}


canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
  let requiredRoles : String[] = route.data['roles'];
  for(let role of this.authService.getRoles()) {
    if(requiredRoles.includes(role)) return true;
  }
  return false;
  }

}
