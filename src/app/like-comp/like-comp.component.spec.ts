import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LikeCompComponent } from './like-comp.component';

describe('LikeCompComponent', () => {
  let component: LikeCompComponent;
  let fixture: ComponentFixture<LikeCompComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LikeCompComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LikeCompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
