//
//  CarUtilities.h
//  Functions
//
//  Function Libraries

//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>

// O-c doesn't support namespaces, so to prevent naming collisions with other global functiosn, large frameworks need to prefix their functions with a unique identifier
NSString *CUGetRandomMake(NSArray *makes);
NSString *CUGetRandomModel(NSArray *models);
NSString *CUGetRandomMakeAndModel(NSDictionary *makeAndModels);
