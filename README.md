# Simple Dialer
<img alt="Logo" src="fastlane/metadata/android/en-US/images/icon.png" width="120" />

A lightweight app for handling your calls, no matter where are you. Comes with a handy call log for easy call initiation.

There is a quick dialpad at your service too, with smart contact suggestions. It supports letters too.

You can easily block phone numbers to avoid unwanted incoming calls.

Supported Speed dialing makes calling your favorite contacts with this true phone a breeze.

It comes with material design and dark theme by default, provides great user experience for easy usage.
###### It uses internet only when using truecaller api to fetch caller details. Use of truecaller to fetch details is completely optional. App works perfectly well without internet too.

Contains no ads or unnecessary permissions. It is fully opensource, provides customizable colors.

<b>Check out the full suite of Simple Tools here:</b>
https://www.simplemobiletools.com

<b>Facebook:</b>
https://www.facebook.com/simplemobiletools

<b>Reddit:</b>
https://www.reddit.com/r/SimpleMobileTools

<a href='https://play.google.com/store/apps/details?id=com.simplemobiletools.dialer'><img src='https://simplemobiletools.com/assets/images/google-play.png' alt='Get it on Google Play' height='45' /></a>
<a href='https://f-droid.org/packages/com.simplemobiletools.dialer'><img src='https://simplemobiletools.com/assets/images/f-droid.png' alt='Get it on F-Droid' height='45' /></a>

<div style="display:flex;">
<img alt="App image" src="fastlane/metadata/android/en-US/images/phoneScreenshots/english/1.jpg" width="30%">
<img alt="App image" src="fastlane/metadata/android/en-US/images/phoneScreenshots/english/2.jpg" width="30%">
<img alt="App image" src="fastlane/metadata/android/en-US/images/phoneScreenshots/english/3.jpg" width="30%">
</div>

### Getting Truecaller auth token

(Tested with truecaller app version - 11.81.7)

Go to Truecaller app settings -> Privacy Center -> Download my data
Download the json file and open it.

Token is the value of key "id". It will look similar to -
```` 
a1i01--TQkyvDkO-VW8akLyvbyPBFxr11Fi_KOD1Sv1RGv7UPMJV-KU9C62xo4nd
```` 


Input this auth token in Simple Dialer app.
Settings -> Truecaller Auth Token

Once token is added, in subsequent calls(incoming/outgoing), simple dialer will make truecaller api call and display the name of the caller.

<div style="display:flex;">
<img alt="App image" src="fastlane/metadata/android/en-US/images/raw_screenshots/app_5.jpg" width="30%">
<img alt="App image" src="fastlane/metadata/android/en-US/images/raw_screenshots/app_6.jpg" width="30%">
</div>
