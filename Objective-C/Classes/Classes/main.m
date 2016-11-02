//
//  main.m
//  Classes
//
//  Created by Pomme on 11/1/16.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "Car.h"


int main(int argc, const char * argv[]) {
    @autoreleasepool {
        // first allocate memory for object by calling alloc method, then initialize it
        Car *toyota = [[Car alloc] init];
        
        [toyota setModel:@"Toyota Corolla"];
        NSLog(@"Car model is %@", [toyota model]);
        
        toyota.model = @"Camry";
        NSLog(@"Change car to %@", toyota.model);
        
        // call class method
        [Car setDefualtModel:@"Porsche"];
        
        [toyota drive];
        
        
        // Instantiating objects
        Car *nissan = [[Car alloc] init];
        NSLog(@"Created a %@.", [nissan model]);
        
        Car *chevy = [[Car alloc] initWithModel:@"Chevy Corvette"];
        NSLog(@"Created a %@", chevy.model);
        
        
        // Dynamic Typing
        
        // Classes themselves are represented as objects, which makes it possible to query their properties(introspection), or even change their behavior on-the-fly (reflection).
        Car *delorean = [[Car alloc] initWithModel:@"DeLorean"];
        
        // Get the class of an object
        NSLog(@"%@ is an instance of the %@ class", [delorean model], [delorean class]);
        
        // Check an object against a class and all subclasses
        if ([delorean isKindOfClass:[NSObject class]]) {
            NSLog(@"%@ is an instance of NSObject or one of its subclasses", [delorean model]);
        } else {
            NSLog(@"%@ is not an instance of NSObject or one of its subclasses", [delorean model]);
        }
        
        // Check an object against a class, but not its subclasses
        if ([delorean isMemberOfClass:[NSObject class]]) {
            NSLog(@"%@ is a instance of NSObject", [delorean model]);
        } else {
            NSLog(@"%@ is not an instance of NSObject", [delorean model]);
        }
        
        // Covert between strings and classes
        if (NSClassFromString(@"Car") == [Car class]) {
            NSLog(@"I can convert between strings and classes");
        }
    }
    return 0;
}
