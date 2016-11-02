//
//  Bicycle.h
//  StreetLegal
//
//  The StreetLegal.h protocol API can be adopted by a class by adding it in angled brackets after the class/superclass name. Create a new classed called Bicycle and change its header to the following. Note that you need to import the protocol before you can use it.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>

#import "StreetLegal.h"

@interface Bicycle : NSObject <StreetLegal>

- (void)startPedaling;
- (void)removeFrontWheel;
- (void)lockToStructure:(id)theStructure;

@end
