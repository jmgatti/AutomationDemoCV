Sleep(500)
ControlClick("Open","","[CLASS:ToolbarWindow32; INSTANCE:3]")
Send("{CTRLDOWN}v{CTRLUP}")
Send("{ENTER}")
Sleep(500)
ControlFocus("Open","","[CLASS:Edit; INSTANCE:1]")
Sleep(500)
Send("CVpicture.jpg")
Send("{ENTER}")
Sleep(500)
ControlClick("Open","","[CLASS:Button; INSTANCE:1]")