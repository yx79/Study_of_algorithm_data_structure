//
//  Car.h
//  StreetLegal
//
//  Created by Pomme on 11/1/16.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import <Foundation/Foundation.h>
#import "StreetLegal.h"

@interface Car : NSObject <StreetLegal>

- (void)startEngine;
- (void)stopEngine;
- (void)lockToStructure:(id)theStructure;

@end
