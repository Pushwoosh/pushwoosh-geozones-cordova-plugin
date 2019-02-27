//
// PushwooshGeozones.m
//
// Pushwoosh, 15/02/19.
//
// Pushwoosh Geozones Plugin for Cordova Android
// www.pushwoosh.com
//
// MIT Licensed

#import "PushwooshGeozones.h"
#import "PWGeozonesManager.h"

@implementation PushwooshGeozones

- (void)startLocationTracking:(CDVInvokedUrlCommand *)command {
	[[PWGeozonesManager sharedManager] startLocationTracking];

	CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:nil];
	[self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

- (void)stopLocationTracking:(CDVInvokedUrlCommand *)command {
	[[PWGeozonesManager sharedManager] stopLocationTracking];

	CDVPluginResult *pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:nil];
	[self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
