//
//  main.m
//  Methods
//
//  Objective-C relies entirely on the C programming language for functions
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "CarUtilities.h"

// Declarartion
static NSString *getRandomMake(NSArray *);

int getRandomInteger(int min, int max) {
    // built-in arc4random_uniform() function returns a random number between 0 and whatever argument you pass.
    // (max - min) + 1 is 1 to 21, then -10 so is -10 to 10
    // this is preferred over rand() and random() algorithm
    return arc4random_uniform((max - min) + 1) + min;
}

int countByTwo() {
    // static local variables
    static int currentCount = 0;
    currentCount += 2;
    return currentCount;
}

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        int randomNumber = getRandomInteger(-10, 10);
        NSLog(@"The random number(-10 to 10) is %d", randomNumber);
        
        NSArray *makes = @[@"Apple", @"Pear", @"Grape"];
        NSLog(@"I selected a %@", getRandomMake(makes));
        
        // static local variables in a functions 2 2+2 2+2+2
        NSLog(@"%d", countByTwo());
        NSLog(@"%d", countByTwo());
        
        // CarUtilities
        NSDictionary *makesAndModels = @{
                                         @"Ford": @[@"Explorer",@"F-150"],
                                         @"Honda": @[@"Accord",@"Civic",@"Pilot"],
                                         @"Porshce": @[@"911 Turbo",@"Boxster",@"Cayman S"],
                                         };
        NSString *randomCar = CUGetRandomMakeAndModel(makesAndModels);
        NSLog(@"Selected a %@", randomCar);
    }
    return 0;
}

// Implementation
static NSString *getRandomMake(NSArray *makes) {
    int max = (int)[makes count];
    int randomIndex = arc4random_uniform(max);
    return makes[randomIndex];
}

