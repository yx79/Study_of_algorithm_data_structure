//
//  CarUtilities.m
//  Methods
//
//  The corresponding implementation file defines what these functions actually do.


//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import "CarUtilities.h"

// Private function declaration
static id getRandomItemFromArray(NSArray *anArray);

// Public function implementations
NSString *CUGetRandomMake(NSArray *makes) {
    return getRandomItemFromArray(makes);
}

// Public function implementations
NSString *CUGetRandomModel(NSArray *models) {
    return getRandomItemFromArray(models);
}

NSString *CUGetRandomMakeAndModel(NSDictionary *makesAndModels) {
    // get the array of keys
    NSArray *makes = [makesAndModels allKeys];
    NSString *randomMake = CUGetRandomMake(makes);
    NSArray *models = makesAndModels[randomMake];
    NSString *randomModel = CUGetRandomModel(models);
    return [randomMake stringByAppendingFormat:@" %@", randomModel];
}

// Private function implementation
static id getRandomItemFromArray(NSArray *anArray) {
    int max = (int)[anArray count];
    int randomIndex = arc4random_uniform(max);
    return anArray[randomIndex];
}






