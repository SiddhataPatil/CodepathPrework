# CodePath Todo App

<img src='https://github.com/SiddhataPatil/CodePath_Todo/blob/master/app/src/main/res/drawable/add_new.png' width="200" height="200" />

# Pre-work - Todo [List It]
**List It** Android App is designed to make todo lists. This has basic functionalities like **adding new tasks**, **removing tasks**,**editing** along with **prioritizing**.

Submitted by: **Siddhata Patil**

Time spent: **4** hours spent in total.

## User Stories

The following **required** functionality is completed:

* [x] User can **successfully add and remove items** from the todo list
* [x] User can **tap and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list.
* [x] User can **persist todo items** and retrieve them properly on app restart

The following **optional** features are implemented:
* [x] Persist the todo items [into SQLite](http://guides.codepath.com/android/Persisting-Data-to-the-Device#sqlite) instead of a text file
* [x] Improve style of the todo items in the list [using a custom adapter](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView)
* [ ] Add support for completion due dates for todo items (and display within listview item) 
* [ ] Use a [DialogFragment](http://guides.codepath.com/android/Using-DialogFragment) instead of new Activity for editing items
* [x] Add support for selecting the priority of each todo item (and display in listview item)
* [x] Tweak the style improving the UI / UX, play with colors, images or backgrounds
 (Used ImageButtons and modified background to improve UI)
* [x] Gold star was added to show Priority task

## Video Walkthrough 

Here's a walkthrough of implemented user stories:

<img src='https://github.com/SiddhataPatil/CodePath_Todo/blob/master/Todogif.gif' width="400" height="750" />

## Project Analysis

As part of your pre-work submission, please reflect on the app and answer the following questions below:

**Question 1:** "What are your reactions to the Android app development platform so far? Compare and contrast Android's approach to layouts and user interfaces in past platforms you've used."

**Answer:** Android development platform is used by many. So even if you get stuck anywhere, there is atleast one stack overflow solution that will work for you! 
I feel Android studio is better than the Eclipse Ide (I used only Eclipse for Android development before). One great thing is we can view the xml as well as Design at the same time which we cannot do in Eclipse. But, I struggled with library support in Android Studio.

**Question 2:** "Take a moment to reflect on the `ArrayAdapter` used in your pre-work. How would you describe an adapter in this context and what is its function in Android? Why do you think the adapter is important? Explain the purpose of the `convertView` in the `getView` method of the `ArrayAdapter`."

**Answer:** The ArrayAdapter is used to map in our case array of strings in a ListView. Adapter in Android is used to translate data to its View representation (according to the slides video). I think it is important because it directly reflcts on the UI side of the App. ConvertView can be used for reusability of old objects, maybe to save memory.


## Notes

**Problem**: R.java got removed from my working project.

**What worked for me**: Started a new application project and imported all my files there.


**Problem**: FileUtils was not recognized even after adding compile 'commons-io:commons-io:2.4' as dependency.

**What worked for me**: Had to download commons-io-2.4-sources.jar and import it as a module and then added it to the dependency.

## Application Configuration setting

Android Studio Version: 2.2.3

Minimum Required SDK: API 21


## License

    Copyright 2017 Siddhata Patil

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.



