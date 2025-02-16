# Simple Dialer
<img alt="Logo" src="graphics/icon.png" width="120" />

A lightweight app for handling your calls, no matter where are you. Comes with a handy call log for easy call initiation. You can now easily dial numbers using this amazing dial pad without any problem as this dial pad gives you different things to ease up your overall experience while making a call. Stay connected with your friends and family while having a smooth experience in this app. With bigger numbers and letters, it is now easier for you to see and dial numbers. Using this dialpad, you can access your contacts and maintain a call log with ease.

There is a quick dialpad at your service too, with smart contact suggestions. It supports letters too. You can use the quick search for finding your favorite contacts not just in the contact list, but also at the call history. Call log entries can be removed either one by one, but it can also be cleared out at once.

You can easily block phone numbers to avoid unwanted incoming calls. This feature is missing in most of the apps present on the store. Using this feature, you can choose who can call you. By this feature, the security of the user can be maintained easily by blocking numbers that are useless or threatening. You can block calls from not saved contacts too.

With advanced security features of this app, the numbers you type are tightly secured so you can have a seamless experience without worrying about your data going in wrong hands. Each of your phone number is safe with you. 

Supported Speed dialing makes calling your favorite contacts with this true phone a breeze. You can make any phone number your favorite so you can quickly dial it. This way, you can easily make contacts with people without finding deep down in other numbers.

To help you manage your calls quickly the phone number app also supports favorite contacts and creating shortcuts of any contact on the home screen.

It comes with material design and dark theme by default, provides great user experience for easy usage. The lack of internet access gives you more privacy, security and stability than other apps.
###### It uses internet only when using truecaller api to fetch caller details. Use of truecaller to fetch details is completely optional. App works perfectly well without internet too.

Contains no ads or unnecessary permissions. It is fully opensource, provides customizable colors. Keeping track of call logs for different phone number is also a plus point of this app.

Check out the full suite of Simple Tools here:  
https://www.simplemobiletools.com

Facebook:  
https://www.facebook.com/simplemobiletools

Reddit:  
https://www.reddit.com/r/SimpleMobileTools

Telegram:  
https://t.me/SimpleMobileTools

<a href='https://play.google.com/store/apps/details?id=com.simplemobiletools.dialer'><img src='https://simplemobiletools.com/images/button-google-play.svg' alt='Get it on Google Play' height='45' /></a>
<a href='https://f-droid.org/packages/com.simplemobiletools.dialer'><img src='https://simplemobiletools.com/images/button-f-droid.png' alt='Get it on F-Droid' height='45' /></a>

<div style="display:flex;">
<img alt="App image" src="fastlane/metadata/android/en-US/images/phoneScreenshots/1_en-US.jpeg" width="30%">
<img alt="App image" src="fastlane/metadata/android/en-US/images/phoneScreenshots/2_en-US.jpeg" width="30%">
<img alt="App image" src="fastlane/metadata/android/en-US/images/phoneScreenshots/3_en-US.jpeg" width="30%">
</div>

### Getting Truecaller auth token

~~(Tested with truecaller app version - 11.81.7)~~ **(THIS METHOD NO LONGER WORKS)**

~~Go to Truecaller app settings -> Privacy Center -> Download my data
Download the json file and open it.~~

~~Token is the value of key "id". It will look similar to -~~

**Alternate method** **(ROOT NEEDED)**

Copy the file **account.v2.bak** from  ````/data/user/0/com.truecaller/files````.
Rrename it to something like account.txt.
Open it to get the token. The token will look similar to -
```` 
a1i01--TQkyvDkO-VW8akLyvbyPBFxr11Fi_KOD1Sv1RGv7UPMJV-KU9C62xo4nd
````
Once you get the token, you can uninstall the Truecaller App.


Input this auth token in Simple Dialer app.
Settings -> Truecaller Auth Token

Once token is added, in subsequent calls(incoming/outgoing), simple dialer will make truecaller api call and display the name of the caller.

<div style="display:flex;">
<img alt="App image" src="fastlane/metadata/android/en-US/images/raw_screenshots/app_5.png" width="30%">
</div>

Also, upon adding the token, a search icon will appear in the dialpad which can be used directly to fetch the number details from truecaller. The Name, Image, City and Carrier provider info will be fetched and displayed from truecaller if available.

<div style="display:flex;">
<img alt="App image" src="fastlane/metadata/android/en-US/images/raw_screenshots/search.png" width="30%">
<img alt="App image" src="fastlane/metadata/android/en-US/images/raw_screenshots/truecaller_number_info_1.png" width="30%">
<img alt="App image" src="fastlane/metadata/android/en-US/images/raw_screenshots/truecaller_number_info_2.png" width="30%">
</div>

