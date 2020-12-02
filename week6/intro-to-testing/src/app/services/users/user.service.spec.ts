import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { UserService } from './user.service';

// describe is a function to group unit tests (specs) together
// any variable declared in describe() function is accessible to the
// specs within it
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

  describe('all() method being tested', () => {
    it('should return a collection of users', () => {
      const userResponse = [
        {
          id: '1',
          name: 'Isa',
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
      // in Jasmine, mocks (like a mock service - is referred to as a spy)
      // the spyOn() method creates a mock...(only if the method exists on the object)
      spyOn(userService, 'all').and.returnValue(of(userResponse));

      userService.all().subscribe(res => {
        response = res;
      });

      expect(response).toEqual(userResponse);
    });
  });

  describe('findOne', () => {
    it('should return a single user', () => {
      const userResponse = {
        id: '2',
        name: 'Bob',
        role: 'Developer',
        pokemon: 'Charizard'
      };
      let response;
      spyOn(userService, 'findOne').and.returnValue(of(userResponse));

      userService.findOne('2').subscribe(res => {
        response = res;
      })

      expect(response).toEqual(userResponse);
    })
  })

});
