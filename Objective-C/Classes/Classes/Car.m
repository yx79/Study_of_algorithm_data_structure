//
//  Car.m
//  Classes
//
//  Created by Pomme on 11/1/16.
//  Copyright © 2016 Yuanjie Xie. All rights reserved.
//

#import "Car.h"

static NSString *_defaultModel;


@implementation Car {
    // Private instance variables
    double _odometer;
}

// @synthesize is a convenience directive that automatically generates accessor meoths for the property. By default, the getter is simply the property name (model), and the setter is the capitalized name with the set prefix(setModel)


// optional for xcode 4.4+, as @property will automatically synthesized properties
//@synthesize model = _model;
// _model is instance variable

// super keyword refers to the parent class, the self keyword refers to the instance calling the method
- (id)initWithModel:(NSString *)aModel {
    self = [super init];
    if (self) {
        // Any custom setup work goes here
        _model = [aModel copy];
        _odometer = 0;
    }
    return self;
}

- (id)init {
    // Forward to the "designated" initialization method
    return [self initWithModel:_defaultModel]; // we directly assigned values to the _model and _odometer instance variables in initWithModel:.
}

// Class-level initialization. The initialize method is the class-level equivalent of init
+ (void)initialize {
    if (self == [Car class]) {
        // Makes sure this isn't executed more than once
        _defaultModel = @"Porsche";
    }
}

+ (void)setDefualtModel:(NSString *)aModel {
    _defaultModel = [aModel copy]; // [aModel copy] call creates a copy of the parameter instead of assigning it directly.
}

-(void)drive {
    NSLog(@"Driving a %@ car.", self.model); // self.model utilizes the property's accessor methods. Typically, the only place you'll need to directly accesss instance variables is in init methods and the dealloc method.
    
    // the self keyword refers to the instance calling the method (like this in C++ and java).In addition to accessing properties, this can be used to call other methods defined on the same class (e.g., [self method])
}
@end
