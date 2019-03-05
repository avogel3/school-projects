# Interface Project 4, CSC4243, S016, LSU
### Andrew Vogel & Zackery Lavalais

Java Swing based interface with JavaFX Panels for video. Interface also makes use of TouchOSC and LeapMotion. 

Notes:
The first Frame is actually the SimpleSwingBrowser class, not Frame1. Frame1 is a fallback class in case we had/have a problem with video. In any case, We found it difficult to start SimpleSwingBrowser from another frame. we played around with casting the SimpleSwingBrowser to runnable type and startign a new thread but it still wouldn't work for out implementation.

How to Run:
Start on the first frame:
`javac SimpleSwingBrowser.java`
`java SimpleSwingBrowser`
Start up Receiver for ToushOSC in a new terminal tab:
`javac Reveiver.java`
`java Receiver`

