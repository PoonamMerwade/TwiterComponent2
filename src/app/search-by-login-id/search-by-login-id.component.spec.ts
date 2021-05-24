import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchByLoginIdComponent } from './search-by-login-id.component';

describe('SearchByLoginIdComponent', () => {
  let component: SearchByLoginIdComponent;
  let fixture: ComponentFixture<SearchByLoginIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SearchByLoginIdComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SearchByLoginIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
