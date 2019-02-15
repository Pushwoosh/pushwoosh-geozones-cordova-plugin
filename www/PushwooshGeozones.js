cordova.define("pushwoosh-geozones-cordova-plugin.PushwooshGeozones", function(require, exports, module) {
//
//  PushwooshGeozones.js
//
// Pushwoosh Geozones Plugin for Cordova
// www.pushwoosh.com
//
// MIT Licensed

var exec = require('cordova/exec');

//Class: PushwooshGeozones
//Class to interact with Pushwoosh Geozones plugin
//
//Example:
//(start code)
//	    	    var pushwooshGeozones = cordova.require("pushwoosh-geozones-cordova-plugin.PushwooshGeozones");
//				pushwooshGeozones.startLocationTracking();
//(end)
function PushwooshGeozones() {}

//Function: startLocationTracking
//[android, ios] Starts geolocation based push notifications. You need to configure Geozones in Pushwoosh Control panel.
//
//Parameters:
// "success" - success callback
// "fail" - error callback
//
PushwooshGeozones.prototype.startLocationTracking = function(success, fail) {
	exec(success, fail, "PushwooshGeozones", "startLocationTracking", []);
};

//Function: stopLocationTracking
//[android, ios] Stops geolocation based push notifications
//
//Parameters:
// "success" - success callback
// "fail" - error callback
//
PushwooshGeozones.prototype.stopLocationTracking = function(success, fail) {
	exec(success, fail, "PushwooshGeozones", "stopLocationTracking", []);
};

module.exports = new PushwooshGeozones();

});
