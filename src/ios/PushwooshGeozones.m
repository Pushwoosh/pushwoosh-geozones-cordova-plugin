//
//  PushNotification.m
//
// Based on the Push Notifications Cordova Plugin by Olivier Louvignes on 06/05/12.
// Modified by Max Konev on 18/05/12.
//
// Pushwoosh Push Notifications Plugin for Cordova iOS
// www.pushwoosh.com
// (c) Pushwoosh 2012
//
// MIT Licensed

#import "PushwooshGeozones.h"
#import "AppDelegate.h"

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
