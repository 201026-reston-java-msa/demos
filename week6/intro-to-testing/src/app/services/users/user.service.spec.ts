import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { UserService } from './user.service';

describe('UserService', () => {
  let userService: UserService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserService]
    });

    userService = TestBed.inject(UserService);
  });

  it('should be created', () => {
    expect(userService).toBeTruthy();
  });
  // the all() method is going to return all users (we will create a static collection - an array
  // from which the userService will pull all of the elements within it.)

  describe('all', () => {
    it('should return a collection of users', () => {
      const userResponse = [
        {
          id: '1',
          name: 'Jane',
          role: 'Designer',
          pokemon: 'Blastoise'
        },
        {
          id: '2',
          name: 'Bob',
          role: 'Developer',
          pokemon: 'Charizard'
        }
      ];
      let response; 
      // in Jasmine, mocks (like a mock service - is reffered to as a spy)
      // the spyOn() method creates a mock...(only if the method exists on the object)
      spyOn(userService, 'all').and.returnValue(of(userResponse));

      userService.all().subscribe(res => {
        response = res;
      });

      expect(response).toEqual(userResponse);
    });
  });
});
