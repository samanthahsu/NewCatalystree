# ChangeLog

**6/14/2018**
- switch to importing files by dragging in the folder...update to main

**6/12/2018**
todo:
- Create array of tasks for ChallengeFragment to display in the TaskFractal
- Create Catalystree website
- Create timer in ChallengeFragment to keep track of when tasks become overdue
- Count the days in which the challenge has been running
- Create editable version of map which gets blocks from database
- christmas countdown thing - based on its time make new check ins available / something

**6/11/2018**
- Added working RoomExample files

**5/26/2018**
- Updated all files. 
	- TODO: 
		- Implement reset password option on LogInFragment
		- Make gridview for ArchiveFragment and array that holds the image, strings associated with the specific store piece of info
		- fractal for ArchiveFragment to open to display more information
		- Create array of tasks for ChallengeFragment to display in the TaskFractal
		- Create Catalystree website and link it to the button in settings
		- Create timer in ChallengeFragment to keep track of when tasks become overdue
		- Create editing version of the map where players can tap a grid to place a block
		- Map - 

**5/25/2018**
- The MapFragment now has zoomable tiling! TODO: Make tiling modifieable. Archive. Settings. Task Fractal.

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
