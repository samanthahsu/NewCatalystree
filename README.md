# ChangeLog

**5/21/2018**
- Files in "Catalystree" folder updated. Splash screen, Sign up, and Log in now working properly. TODO: Creation of HomeActivity which holds pretty much all of the app with bottom buttons. Also figure out how to make the map and EVERYTHING.

**5/20/2018**
- "Catalystree" folder added along with working Sign In fragment (it connects to Firebase Authentication, yay!) TODO: Log In fragment, and auto login.

**5/19/2018** 
- Installed Firebase (updated "build.gradle (Module: app)", "build.gradle (Project: New Catalystree)", "AndroidManifest.xml", copy "google-services.json" into the "app" folder in "project" mode (not post it here because it exposes the API or something (hence git guardian))). Also firebase testing and tutorial "https://youtu.be/vJ7bfAPt4hY".
- How do you implement instance ID? https://developers.google.com/instance-id/#identify-and-track-apps (still doesnt know)
Best practices for unique identifiers (user ID syncing): https://developer.android.com/training/articles/user-data-ids#java
- Right now, unique user ID is bound to phone - bad because can't move to new phone? Also google says its bad so yeah (but it works)
- Added "MainActivity.java" and "activity_main.xml" used to test adding data associated with unique device ID (feel free to use and test, I think you have access to everything so you'll be able to see the updates in the Firebase>Database>RealtimeDatabase page!)
- EVERYTHING HAS BEEN SORTED INTO FOLDERS!
