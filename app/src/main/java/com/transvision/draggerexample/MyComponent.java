package com.transvision.draggerexample;

import com.transvision.draggerexample.module.SharedPrefModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {SharedPrefModule.class})
public interface MyComponent {
    void inject(MainActivity activity);
}
