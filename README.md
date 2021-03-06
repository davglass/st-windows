Are My Windows Open?
===================

This is a little hack that I put together to play with SmartDevice types and doing different things with them.

It takes a list of Open/Closed sensors (for my windows) and creates a "Thing" that shows if any of them are open. If
they are then it will show that the "Thing" is open. It will also display the "count" of the number of them that are
open.

It's just a quick way to see how many windows in the house are open.

![all-windows-closed](https://cloud.githubusercontent.com/assets/32551/7288112/895674b4-e922-11e4-8439-c0190508ba26.png)
![all-windows-open](https://cloud.githubusercontent.com/assets/32551/7288111/89565218-e922-11e4-830b-614200730478.png)

Install Device
--------------

   * Go to the ST IDE and head over to [`My Device Types`](https://graph.api.smartthings.com/ide/devices)
   * Click on `New SmartDevice`
   * Select `From Code`
   * Paste in the code from `windows.device.groovy`
   * Save and Publish this

Create the Device
-----------------

   * Go to the ST IDE and head over to [`My Devices`](https://graph.api.smartthings.com/device/list)
   * Click on `New Device`
   * Give it a `Name`, `Device Network Id` and select the new SmartDevice from the list.
       * The `Device Network Id` just needs to be a unique ID on the network, I went with `12345`
   * Click Create

Create the SmartApp
-------------------

   * Go to the ST IDE and head over to [`My SmartApps`](https://graph.api.smartthings.com/ide/apps)
   * Click on `New SmartApp`
   * Select `From Code`
   * Paste in the code from `windows.app.groovy`
   * Save and Publish this

Install the SmartApp
--------------------

   * From the SmartThings app, click the big `+`
   * Scroll over to `My Apps`
   * Install the new App
   * In the list of Windows, select all of your Window Open/Close sensors
   * For the "`Thing`", select the new Device that you added in the beginning

