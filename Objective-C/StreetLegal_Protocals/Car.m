//
//  Car.m
//  StreetLegal
//
//  Created by Pomme on 11/1/16.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import "Car.h"

@implementation Car

- (void)signalStop {
    NSLog(@"Bending left arm downwards");
}

- (void)signalLeftTurn {
    NSLog(@"Extending left arm outwards");
}

- (void)signalRightTurn {
    NSLog(@"Bending left arm upwards");
}

- (void)startEngine {
    NSLog(@"Start engine");
}
- (void)stopEngine {
    NSLog(@"Stop engine");
}

- (void)lockToStructure:(id)theStructure {
    NSLog(@"Locked to structure. Don't forget the combination!");
}

@end
