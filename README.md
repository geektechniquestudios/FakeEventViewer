# FakeEventViewer

This is a dopple-ganger troll application designed to look like Windows Event Viewer. The intended use for this software is scam baiting, scambaiting, scambait, or scam bait.  If you would like to see it in action: [Here's a video](https://www.youtube.com/watch?v=JpBYAqYVJxQ&t)

---
### Disclaimer
This application does not gather any informaiton on the user other than system time and mouse location. It is not malicious in any way. **This is not designed to be used for scamming people**

According to Wikipedia: 

> **Scambaiting** is a form of Internet vigilantism, where the vigilante poses as a potential victim to the scammer in order to waste their time and resources, gather information that will be of use to authorities, and publicly expose the scammer.

---

Tech support scammers cold call those less tech-savvy and use Event Viewer as a tool to convince the victim something is wrong with their computer by showing them perfectly normal error information the "Admin Events" Pane of Event Viewer. This application makes it infuriating to even get the mouse to hover that option.

### Features

-The window cannot be closed without `Task Manager`

-The mouse will become invisible and teleport

-The window will minimize semi-randomly

-The window will suddenly resize so small they have to resize it

-The window will stay on top of all other windows when not minimized

-The scammer will be presented with a series of unintelligible captchas that involve matching and writing

-After failing many captchas, a modal pops up telling them that Event Viewer is locked, refusing to let them click on anything else; they must click on an icon to contiue. That icon links to indeed.com India with the phrase "literally anything" cued in the search box.

---

# How To Use This Software

You can follow the video [here](https://www.youtube.com/watch?v=oUsCECfxe0I). Additionaly, the steps below can be followed.

1. Download and run the file named `Fake Event Viewer Installer.exe`

2. While running the installer, be sure to select the option to make a shortcut on the desktop.

3. Right-click on the shortcut, select properties, and ensure that the "Shortcut" tab is selected.

4. Observe the fields labeled "Target" and "Start in". They should have contents along the lines of `"C:\Program Files (x86)\Event Viewer\EventViewer.exe"` and `"C:\Program Files (x86)\Event Viewer"` respectively. You will copy and paste these.

5. Find the shortcut launcher for the real Event Viewer. You should be able to do this by simply searching for "event viewer" from your start menu, right-clicking on it, and clicking "open file location". Optionally, you can find event viewer in `Start-> all programs -> administrative tools -> Event Viwer`.

6. Right click on the shortcut Event Viewer that pops up, and select properties.

7. Copy the info from step 4 into the real Event Viewer properties dialog. Click apply.

And you're done! Now anytime a scammer opens "Event Viewer" from anywhere on the system, they will be greeted with this annoying hell.

#### If you decide to use this software to mess with scammers, it is highly advised that you use it on a virtual machine.

#### If you want to fork this repository, or you would like to edit the code, it is important for you to know that this project was made using the Eclipse IDE, the [JPhoenix toolkit](https://github.com/jfoenixadmin/JFoenix), and JavaFX. You must import JFoenix if you want the code to run.
