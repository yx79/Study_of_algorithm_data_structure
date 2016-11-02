//
//  Bicycle.m
//  StreetLegal
//
//  The StreetLegal.h protocol API can be adopted by a class by adding it in angled brackets after the class/superclass name. Create a new classed called Bicycle and change its header to the following. Note that you need to import the protocol before you can use it.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Bicycle.h"

@implementation Bicycle

- (void)signalStop {
    NSLog(@"Bending left arm downwards");
}

- (void)signalLeftTurn {
    NSLog(@"Extending left arm outwards");
}

- (void)signalRightTurn {
    NSLog(@"Bending left arm upwards");
}

- (void)startPedaling {
    NSLog(@"Here we go");
}

- (void)removeFrontWheel {
    NSLog(@"Front wheel is off");
}

- (void)lockToStructure:(id)theStructure {
    NSLog(@"Locked to structure. Don't forget the combination!");
}

@end
