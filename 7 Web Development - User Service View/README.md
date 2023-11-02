# Exercise 7: User Service View
In this exercise, you will use the bajaux framework to create an alternative view for the User Service:

![User Service View](../images/UserServiceView.png)

## Description
In this exericse, you will create two widgets:
* A `UserCard` widget that, given a user, produces one of the cards visible in the above screenshot
* A `UserServiceView` widget that composes multiple `UserCard` widgets (one per user) into a grid as shown above and registers itself as a view on the User Service.

You may choose to use the raw `bajaux` framework or to use spandrel, but due to the complexity of this task, I recommend spandrel. The necessary CSS has been provided for you in two stylesheets: `UserCard.css` and `UserServiceView.css`. Feel free to make changes to them as you see fit or, if you have some frontend experience, scrap them altogether and create your own! The provided CSS assumes the following structure of your final HTML:
```html
<div class="user-service-view">
  <div class="user-grid">
    <div class="user-card enabled">
      <p class="user-initials">LR</p>
      <div class="user-name">
        <p class="primary-name">Lorraine Randolph</p>
        <p class="secondary-name">lrandolph</p>
      </div>
      <p class="user-roles">
        <span class="role-badge">admin</span>
        <!-- Potentially more role-badges -->
      </p>
    </div>
    <!-- More user-cards --->
  </div>
</div>
```

Also, note the following features that should be present in your final view:
* If a user's `enabled` Property is true, then the `<div>` with the class of `user-card` should also have a class of `enabled`. If the user's `enabled` Property is false, then the `<div>` with a class of `user-card` should also have a class of `disabled`. The users Maxwell Walters and Eoin Fulton in the example above are disabled.
* The initials should be determined from the `fullName` Property of each user. If the `fullName` Property is empty (as is the case for `admin`, `cgross`, and `korozco`), then the initials should be determined from each user's `name`.
* If the user has a non-empty `fullName` Property, then the `<p>` with the class of `primary-name` should contain the `fullName` and the `<p>` with the class of `secondary-name` should contain the user's `name`. If the `fullName` Property is empty, then `primary-name` should contain the user's `name` and there should be no `<p>` with a class of `secondary-name`.

This is quite a challenging exercise. Don't hesitate to reach out if you get stuck!

## Recommended Steps
Try to implement the behavior described above without reading this section. If you need a nudge in the right direction, here are some recommended steps.

1. Create a JavaScript file in the `rc` directory named `UserServiceView.js`. Implement it with something very minimal that will allow you to determine if your view is working. For instance, have your widget return `<p>Hello</p>`.
2. Create a class in the `com.tridiumuniversity.userserviceview.ux` package that implements `BIJavaScript` and `BIFormFactorMax` and declares itself as an agent on the `baja:UserService`. This class should contain a method `getJsInfo` that returns a `JsInfo` that points to your `UserServiceView.js` file.
3. Run slotomatic, compile, and start up a station. Try viewing the User Service and make sure that you can see whatever you defined in your `UserServiceView`. Note that your view probably won't be the default view, so check the View dropdown.
4. If you're planning on using spandrel, make sure you've added the pragma at the top of your file:

`/** @jsx spandrel.jsx */`

5. This is also a good time to get moduledev set up if you haven't already; it will make the rest of this exercise much easier.
6. Create a new JavaScript file in the `rc` directory named `UserCard.js`. Just like with `UserServiceView`, define a widget in this file that returns something very simple, like `<p>User Card</p>`. Now, modify `UserServiceView` to return three instances of `UserCard`.

Once that's working, you've gotten a lot of your setup done: you've defined a new view on the User Service that displays multiple instances of `UserCard`. Now, you can start filling in the details.

7. Modify `UserServiceView` to display one `UserCard` per user. Remember each user is just a Property of the User Service. To display them, you'll probably want to use the `getSlots()` method. Look into `local:|module://docDeveloper/doc/jsdoc/bajaScript-ux/baja.Component.html` and `local:|module://docDeveloper/doc/jsdoc/bajaScript-ux/module-baja_comp_SlotCursor.html` to find some helpful methods. Your goal is to get an array of users from the User Service and map over them, creating a `UserCard` for each user. Don't forget to use a `subscriberMixIn` so that you're getting live data from the station! We haven't implemented `UserCard` at this point, so you'll know you've been successful when you see a number of `UserCard`s equal to the actual number of users in your station.
8. Modify `UserCard` to start displaying some of the details of the user. Start with something simple, like displaying each user's name. Make sure to use a `subscriberMixIn` to get the live details of each user. At this point, don't worry about the `enabled` and `disabled` classes or computing the initials; just try and get _something_ from each user to show up correclty in each card.
9. Now come back to `UserCard` and fill in the finer details. Try enabling/disabling users and make sure that the card backgrounds are changing appropriately. Try adding users with empty and non-empty `fullName` Properties to ensure you're handling those correctly. Also make sure that you're correctly displaying each user's roles.

## Added Challenge
For an added challenge, add a click handler to each user card so that clicking on it hyperlinks you to that user's Property Sheet. There's an example of hyperlinking in the `BajauxExamples` in the `docDeveloper` palette.