//
//  main.m
//  Protocol test
//  Protocols are a way to abstract shared properties and methods into a dedicted file. This helps reduce redundant code and lets you dynamically check if an object supports an arbitrary set of functionality.

//  Created by Pomme on 11/1/16.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Bicycle.h"
#import "Car.h"

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        Bicycle *myBike = [[Bicycle alloc]init];
        [myBike startPedaling];
        [myBike signalRightTurn];
        [myBike signalStop];
        [myBike lockToStructure:nil];
        
        // Just like classes, protocols can be used to type check variables
        // variable declared with id <StreetLegal>
        id <StreetLegal> mysteryVehicle = [[Car alloc] init];
        [mysteryVehicle signalStop];
        
        mysteryVehicle = [[Bicycle alloc] init];
        [mysteryVehicle signalStop];
        
        // conformsToProtocol method defined by NSObject protocol
        // make sure this object has this particular set of functionality
        if ([mysteryVehicle conformsToProtocol:@protocol(StreetLegal)]) {
            [mysteryVehicle signalStop];
        }
    }
    return 0;
}
