# DraggerExample

What is Android Dependency Injection?
-------------------------------------
You don’t create objects yourself, you let someone else create them for you.

Let’s analyze what the above statement means.

Imagine the following scenario: We have an Activity and we wish to save some data in the SharedPreferences. Doing this without DI would lead us to instantiate, saving, retrieving data from the SharedPreferences, all within the Activity’s boilerplate code. Something that the below illustration more or less portrays to an extent.

android no dependency injection
Without DI

The above approach can lead to some serious issues especially when your codebase increases in size.

You’ll have issues with unit testing, too much boilerplate code, difficulties in modifying your current codebase with so many instances to keep an eye on (shared instances, scoped instances). This is where Android Dependency Injection Pattern can give a major boost to your code.

As mentioned in the dependency and with the following illustration, instead of instantiating the SharedPreferences in our Activity every time, we’d let it be injected from another class.

android dependency injection
With DI

So our Activity is dependent on the SharedPreferences. Thus SharedPreferences acts as a dependency for our Activity. SharedPreferences gets injected into our Activity from the outside instead of getting instantiated.

Why use Android Dependency Injection?
--------------------------------------
If you’re the boss of a company, would you prefer doing all the things yourself or delegate the tasks?

Would you prefer hiring a rookie over an expert who already knows the task?

In an ideal situation, the answer to both of the above questions should be the latter option.

That’s why Dependency Injection is so critical. Instead of instantiating SharedPreferences, Databases, Network Libraries in our Activity each time, we’ll prefer to have instances of them created somewhere else and inject them in our Activity when it’s needed.

These dependencies are normally used in our classes using constructors that we’ll be seeing soon.

What is Dagger 2?
-----------------
Dagger library was created by developers at Square, way back in 2012. Dagger 1 was used to create instances of classes and inject dependencies via Reflections. Improving upon the first version, and collaborating with a team of developers at Google, Dagger 2 a much faster and improved version without Reflections was introduced.

Dagger 2 is a compile-time android dependency injection framework and uses the Java Specification Request (JSR) 330 and uses an annotation processor.

Following are the basic annotations used in Dagger 2:

@Module : This is used on the class that does the work of constructing objects that’ll be eventually provided as dependencies.
@Provides : This is used on the methods inside the Module class that’ll return the object.
@Inject : This is used upon a constructor, field or a method and indicates that dependency has been requested.
@Component : The Module class doesn’t provide the dependency directly to the class that’s requesting it. For this, a Component interface is used that acts as a bridge between @Module and @Inject.
@Singleton : This indicates that only a single instance of the dependency object would be created.

The code to bind Dagger into our application is:
------------------------------------------------
myComponent = DaggerMyComponent.builder().sharedPrefModule(new SharedPrefModule(this)).build();
SharedPrefModule(this)).build();

Dagger keyword is prepended on the Component class name. If the component class name was AppComponent, the result would have been DaggerAppComponent.
